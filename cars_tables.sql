-- --------------------------------------------------------

--
-- Table structure for table customer
--

DROP TABLE IF EXISTS customer;
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

DROP TABLE IF EXISTS employee;
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

DROP TABLE IF EXISTS financing;
CREATE TABLE IF NOT EXISTS financing (
  customer_id int NOT NULL,
  car_id int NOT NULL,
  type varchar(10) NOT NULL,
  interest_rate int NOT NULL,
  length int NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table option
--

DROP TABLE IF EXISTS option;
CREATE TABLE IF NOT EXISTS option (
  id SERIAL,
  name varchar(100) NOT NULL,
  price int NOT NULL,
  PRIMARY KEY (id)
);

-- --------------------------------------------------------

--
-- Table structure for table sales
--

DROP TABLE IF EXISTS sales;
CREATE TABLE IF NOT EXISTS sales (
  id SERIAL,
  customer_id int NOT NULL,
  employee_id int NOT NULL,
  vehicle_id int NOT NULL,
  tax int NOT NULL,
  fee int NOT NULL,
  price int NOT NULL,
  date date NOT NULL,
  PRIMARY KEY (id)
);

-- --------------------------------------------------------

--
-- Table structure for table sales_options
--

DROP TABLE IF EXISTS sales_options;
CREATE TABLE IF NOT EXISTS sales_options (
  sales_id int NOT NULL,
  option_id int NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table vehicle
--

DROP TABLE IF EXISTS vehicle;
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