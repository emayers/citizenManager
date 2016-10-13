create database country;

use country;

create table basicinfo(
ID int,
FirstName varchar(20),
LastName varchar(20),
Sex enum('M', 'F'),
Birthday date,
primary key (ID));

create table address(
City varchar(50),
State varchar(50),
Street varchar(100),
Zip varchar(5),
ID int,
primary key (Zip),
foreign key (ID) 
references basicinfo(ID));

create table emails(
Email varchar(50),
ID int,
primary key (Email),
foreign key (ID)
references basicinfo(ID));

create table phones(
Number varchar(10),
Type enum('Cel','Tel'),
ID int,
primary key (Number),
foreign key (ID)
references basicinfo(ID));