### Author
Glory Kiogora

### Description
This is an app that creates API for news in different departments.

### Installation
Install sdk

Install java

Install Intellij

Install heroku CLI

Install Postgres

Install Postman

sql SQL CREATE DATABASE departments

Create 3 tables departments, news, users.

CREATE TABLE departments (id SERIAL PRIMARY KEY, departmentname VARCHAR, departmentdescription VARCHAR, noofemployees INT)

CREATE TABLE news (id SERIAL PRIMARY KEY, username VARCHAR, userposition VARCHAR, userrole VARCHAR, departmentId INT)

CREATE TABLE users (id SERIAL PRIMARY KEY, departmentId INT, title VARCHAR, news VARCHAR, author VARCHAR)

### Set-Up
Get a computer and internet

Clone the repository

Git clone repository--link

Move into the directory

cd directory name

Open project on code editor

code .

### BDD
Open App.java

Test the routes with Postman;

### Link to gh-pages
https://github.com/Glo18/News-Portal.git

### Technologies used
Java to develop back-end and run test.

Spark to display application the browser

Postman to test the routes

### License
MIT Copyright (c) 2021 Glory Kiogora

