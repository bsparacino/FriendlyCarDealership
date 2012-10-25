DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS financing;
DROP TABLE IF EXISTS option;
DROP TABLE IF EXISTS vehicle CASCADE;
DROP TABLE IF EXISTS sales_options;
DROP TABLE IF EXISTS sales CASCADE;
DROP VIEW IF EXISTS saleView;

-- --------------------------------------------------------

--
-- Table structure for table customer
--

CREATE TABLE IF NOT EXISTS customer (
  id SERIAL,
  first_name varchar(25) NOT NULL,
  last_name varchar(25) NOT NULL,
  gender varchar(1) NOT NULL,
  dob date NOT NULL,
  address varchar(100) NOT NULL,
  city varchar(50) NOT NULL,
  state varchar(20) NOT NULL,
  zip int NOT NULL,
  PRIMARY KEY (id)
);

-- --------------------------------------------------------

--
-- Table structure for table employee
--

CREATE TABLE IF NOT EXISTS employee (
  id SERIAL,
  first_name varchar(25) NOT NULL,
  last_name varchar(25) NOT NULL,
  gender varchar(1) NOT NULL,
  dob date NOT NULL,
  address varchar(100) NOT NULL,
  city varchar(50) NOT NULL,
  state varchar(20) NOT NULL,
  zip int NOT NULL,
  position varchar(20) NOT NULL,
  PRIMARY KEY (id)
);

-- --------------------------------------------------------

--
-- Table structure for table financing
--

CREATE TABLE IF NOT EXISTS financing (
  customer_id int NOT NULL,
  car_id int NOT NULL,
  type varchar(10) NOT NULL,
  interest_rate numeric(2,2) NOT NULL,
  length int NOT NULL,
  PRIMARY KEY (customer_id, car_id)
);

-- --------------------------------------------------------

--
-- Table structure for table option
--


CREATE TABLE IF NOT EXISTS option (
  id SERIAL,
  name varchar(100) NOT NULL,
  price int NOT NULL,
  PRIMARY KEY (id)
);

-- --------------------------------------------------------

--
-- Table structure for table sales_options
--

CREATE TABLE IF NOT EXISTS sales_options (
  sales_id int NOT NULL,
  option_id int NOT NULL,
  PRIMARY KEY (sales_id, option_id)
);

-- --------------------------------------------------------

--
-- Table structure for table vehicle
--


CREATE TABLE IF NOT EXISTS vehicle (
  id SERIAL,
  vin varchar(17) NOT NULL,
  invoice_price int,
  sticker_price int,
  new_used varchar(4) NOT NULL,
  year int NOT NULL,
  make varchar(50) NOT NULL,
  model varchar(50) NOT NULL,
  trim varchar(50),
  mileage int NOT NULL,
  color varchar(50),
  date_in_stock date NOT NULL,
  PRIMARY KEY (id)
);

-- --------------------------------------------------------

--
-- Table structure for table sales
--

CREATE TABLE IF NOT EXISTS sales (
  id SERIAL,
  customer_id int references customer(id),
  employee_id int references employee(id),
  vehicle_id int references vehicle(id),
  tax int NOT NULL,
  fee int NOT NULL,
  price int NOT NULL,
  date date NOT NULL,
  PRIMARY KEY (id)
);

-- --------------------------------------------------------

--
-- View for sale view
--

CREATE VIEW saleView AS SELECT sales.id,sales.tax,sales.fee,sales.price,sales.date,vehicle.vin,customer.first_name AS cust_first_name,customer.last_name AS cust_last_name,employee.first_name AS emp_first_name,employee.last_name AS emp_last_name FROM sales,vehicle,customer,employee WHERE sales.vehicle_id=vehicle.id AND sales.customer_id=customer.id AND sales.employee_id=employee.id;


-- --------------------------------------------------------

--
-- Stores procedure for insert sale
--

CREATE OR REPLACE FUNCTION insert_sale(integer,integer,integer,integer,integer,integer,date) 
RETURNS void AS $delimiter$
INSERT INTO sales (customer_id,employee_id,vehicle_id,tax,fee,price,date) VALUES($1, $2, $3, $4, $5, $6, $7)
$delimiter$
LANGUAGE SQL;


-- --------------------------------------------------------

--
-- Stored procedure for insert customer
--

CREATE OR REPLACE FUNCTION insert_customer() RETURNS trigger AS $insert_customer$
BEGIN

  IF NEW.first_name='John' THEN RAISE EXCEPTION 'first name cannot be John';
  END IF;

  RETURN NEW;
END;
$insert_customer$ LANGUAGE plpgsql;

-- --------------------------------------------------------

--
-- Trigger for insert customer
--

CREATE TRIGGER insert_customer BEFORE INSERT OR UPDATE ON customer
FOR EACH ROW EXECUTE PROCEDURE insert_customer();