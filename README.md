# _Vinyard Salon_

#### _An exercise in SQL, postgres, and Spark, September 2016_

#### By _**Ryan Vinyard**_

## Description

_This is a webapp that allows you to make a list of stylists and their clients. It stores the databases on a postgres server._

## Setup/Installation Requirements

* _Run a postgres server by typing "postgres" into the terminal_
* _Start PSQL by typing PSQL in a separate terminal window_
* _In PSQL:_
* _CREATE DATABASE hair_salon;_
* _Connect to hair_salon database by typing "\c hair_salon"_
* _CREATE TABLE stylists (id serial PRIMARY KEY, stylistName varchar, bio varchar);_
* _CREATE TABLE clients (id serial PRIMARY KEY, clientName varchar, info varchar, stylistId int);_
* _CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon_
* _Clone repo at https://github.com/RyanVinyard/hair-salon_
* _In a separate terminal window, connect to hair-salon and run gradle test_
* _Run on a gradle server and connect!_

## Known Bugs

_No known bugs at this time._

## Support and contact details

_Rav.ryanvinyard@gmail.com_

## Technologies Used

_Java, postgresql, SQL, Spark, Velocity_

### License

*Free use under MIT license*

Copyright (c) 2016 **_Ryan Vinyard_**
