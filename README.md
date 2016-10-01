# _Vinyard Salon_

#### _An exercise in SQL, postgres, and Spark, September 2016_

#### By _**Ryan Vinyard**_

## Description

_This is a webapp that allows you to make a list of stylists and their clients. It stores the databases on a postgres server._

## Setup/Installation Requirements

* _In PSQL:_
* _CREATE DATABASE hair_salon;_
* _CREATE TABLE stylists (id serial PRIMARY KEY, stylistName varchar, bio varchar);_
* _CREATE TABLE clients (id serial PRIMARY KEY, clientName varchar, info varchar, stylistId int);_
* _Clone repo at https://github.com/RyanVinyard/hair-salon_
* _Run on a gradle server and connect!_

## Known Bugs

_Currently, a 500 error is thrown when attempting to delete a stylist._

## Support and contact details

_Rav.ryanvinyard@gmail.com_

## Technologies Used

_Java, postgresql, SQL, Spark, Velocity_

### License

*Free use under MIT license*

Copyright (c) 2016 **_Ryan Vinyard_**
