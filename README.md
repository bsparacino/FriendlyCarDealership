export CLASSPATH=.:/home/group/s485/p485-01e/cars/postgresql-9.2-1000.jdbc4.jar

import SQL file
psql -U p48501e p48501e < cars_tables.sql

login to db:
psql -U p48501e p48501e

list all tables
\dt

FriendlyGroup5Cars