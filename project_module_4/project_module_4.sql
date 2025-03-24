create database if not exists bus_management;
use bus_management;
create table user(
id int primary key auto_increment,
username varchar(255),
password varchar(255),
role varchar(255)
);
create table employees(
id int primary key auto_increment,
name varchar(255),
phone varchar(255),
email varchar(255),
birth date,
address varchar(255),
id_user int,
foreign key (id_user) references user(id)
);
create table salary(
id int primary key auto_increment,
month int,
basic_salary double,
reward double,
id_employees int,
foreign key(id_employees) references employees(id)
);
create table car(
id int primary key auto_increment,
license_plate varchar(255),
vehicle_type varchar(255),
seat_number int,
vehicle_status varchar(255),
last_maintenance date
);
create table maintenance(
id int primary key auto_increment,
fee double,
date date,
description varchar(255),
time time,
id_car int,
id_employees int,
foreign key(id_car) references car(id),
foreign key(id_employees) references employees(id)
);
create table bus_route(
id int primary key auto_increment,
start varchar(255),
end varchar(255),
distance int
);
create table trip(
id int primary key auto_increment,
time datetime,
expected_time time,
status varchar(255),
id_bus_route int,
id_driver1 int,
id_driver2 int,
id_support_driver int,
foreign key(id_driver1) references employees(id),
foreign key(id_driver2) references employees(id),
foreign key(id_support_driver) references employees(id),
foreign key(id_bus_route) references bus_route(id)
);
create table customer(
id int primary key auto_increment,
name varchar(255),
phone varchar(255)
);
create table revenue(
id int primary key auto_increment,
month int
);
create table ticket(
id int primary key auto_increment,
quntity int,
price double,
status varchar(255),
date date,
id_customer int,
id_trip int,
id_revenue int,
foreign key(id_customer) references customer(id),
foreign key(id_trip) references trip(id),
foreign key(id_revenue) references revenue(id)
);
create table feedback(
id int primary key auto_increment,
content varchar(255),
id_customer int,
id_trip int,
foreign key(id_customer) references customer(id),
foreign key(id_trip) references trip(id)
);
create table promotion(
id int primary key auto_increment,
code varchar(255),
discount int,
start_date date,
end_date date,
id_ticket int,
foreign key(id_ticket) references ticket(id)
);
create table vehicle_assignment(
assigned_time datetime,
id_car int,
id_trip int,
primary key(id_car,id_trip),
foreign key(id_car) references car(id),
foreign key(id_trip) references trip(id)
);