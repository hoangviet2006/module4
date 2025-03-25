create database if not exists bus_management;
use bus_management;
create table user(
id int primary key auto_increment,
username varchar(255) unique not null,
password varchar(255) not null,
role varchar(255) default 'employee'
);
create table employees(
id int primary key auto_increment,
name varchar(255) not null,
phone varchar(255) unique not null,
email varchar(255) unique not null,
birth_date date not null,
address varchar(255),
is_delete boolean default false,
id_user int,
foreign key (id_user) references user(id)
);
create table salary(
id int primary key auto_increment,
month int not null check (month BETWEEN 1 AND 13),
basic_salary double not null,
reward double,
id_employees int ,
foreign key(id_employees) references employees(id)
);
create table car(
id int primary key auto_increment,
license_plate varchar(255) unique not null,
vehicle_type varchar(255) not null,
seat_number int not null,
vehicle_status varchar(255),
last_maintenance date,
is_delete boolean default false,
url_img varchar(255)
);
create table maintenance(
id int primary key auto_increment,
fee double not null,
date date not null,
description varchar(255),
time time not null,
id_car int not null,
id_employees int not null,
foreign key(id_car) references car(id),
foreign key(id_employees) references employees(id)
);
create table bus_route(
id int primary key auto_increment,
start varchar(255) not null,
end varchar(255) not null,
distance int not null check (distance>0),
is_delete boolean default false
);
create table trip(
id int primary key auto_increment,
time datetime not null,
expected_time time not null,
status varchar(255) default 'Chưa khởi hành',
id_bus_route int not null,
is_delete boolean default false,
id_driver1 int not null,
id_driver2 int not null,
id_support_driver int not null,
foreign key(id_driver1) references employees(id),
foreign key(id_driver2) references employees(id),
foreign key(id_support_driver) references employees(id),
foreign key(id_bus_route) references bus_route(id)
);
create table customer(
id int primary key auto_increment,
name varchar(255) not null,
phone varchar(255) unique not null
);
create table revenue(
id int primary key auto_increment,
month int not null
);
create table promotion(
id int primary key auto_increment,
code varchar(255) unique not null,
discount int not null check (discount BETWEEN 0 AND 100),
start_date date not null,
end_date date not null
);
create table ticket(
id int primary key auto_increment,
quantity int not null default 1,
price double not null,
status varchar(255),
date date not null,
id_customer int not null,
id_trip int not null,
id_revenue int,
id_promotion int,
foreign key(id_promotion) references promotion(id),
foreign key(id_customer) references customer(id),
foreign key(id_trip) references trip(id) on delete cascade,
foreign key(id_revenue) references revenue(id)
);
create table feedback(
id int primary key auto_increment,
content varchar(255) not null,
id_customer int not null,
id_trip int not null,
foreign key(id_customer) references customer(id),
foreign key(id_trip) references trip(id) on delete cascade
);
create table vehicle_assignment(
assigned_time datetime not null,
id_car int not null,
id_trip int not null,
primary key(id_car,id_trip),
foreign key(id_car) references car(id),
foreign key(id_trip) references trip(id)
);