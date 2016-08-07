# _Best Restaurant_

#### _Practice building an application with two models, saving data to PSQL database, creating both the back-end and front-end of a RESTful database-backed Spark application that is fully tested with both unit tests and integration tests., 05/05/2016_

#### By _**LaTaevia**_

## Description

_Java application where users can add their favorite restaurants by the type of cuisine they offer._

## Prerequisites

You will need the following properly installed on your computer.

* [Gradle](https://gradle.org/gradle-download/)
* PostgreSQL on Mac with HomeBrew `brew install postgres` 
* [PostgreSQL (All OS)] (http://www.enterprisedb.com/products-services-training/pgdownload#windows)

## Installation

* `git clone https://github.com/LATAEVIA/Best-Restaurant.git`
* Change into the new directory
* In a new terminal window/tab `postgres` to launch postgres
* In another new terminal window/tab `psql` to launch psql
* In psql window/tab `CREATE DATABASE best_restaurant;`
* In the terminal window/tab `psql best_restaurant < best_restaurant.sql`
* `gradle build`

## Running / Development

* `gradle run`
* Visit app at [http://localhost:4567](http://localhost:4567).

## Technologies Used

* _HTML_
* _CSS_
* _Bootstrap_
* _Java_
* _Gradle_
* _Spark_
* _Velocity_
* _FluentLenium_
* _PostgreSQL_

### License

*This software is licensed under the MIT license*

Copyright (c) 2016 **_LaTaevia_**
