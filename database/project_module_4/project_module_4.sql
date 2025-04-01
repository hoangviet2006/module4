create database if not exists bus_management;
use bus_management;
create table user(
id int primary key auto_increment,
username varchar(50) unique not null,
password varchar(255) not null,
role enum('ADMIN', 'EMPLOYEE', 'CUSTOMER') default 'CUSTOMER'
);
create table employee(
id int primary key auto_increment,
name varchar(255) not null,
phone varchar(20) unique not null,
email varchar(255) unique not null,
birth_date date ,
address varchar(255),
is_deleted boolean default false,
employee_type enum('STAFF', 'DRIVER', 'ASSISTANT') default 'ASSISTANT',
id_user int not null unique,
foreign key (id_user) references user(id)
);
create table customer(
id int primary key auto_increment,
name varchar(255) not null,
phone varchar(20) unique not null,
email varchar(255) unique not null,
birth_date date ,
address varchar(255),
id_user int not null unique,
foreign key (id_user) references user(id)
);
create table salary(
id int primary key auto_increment,
date_time date not null,
basic_salary double not null,
reward double default 0,
id_employee int not null unique,
foreign key(id_employee) references employee(id)
);
create table car(
id int primary key auto_increment,
license_plate varchar(255) unique not null,
vehicle_type enum('STANDARD', 'SLEEPER', 'LIMOUSINE', 'PRIVATECABIN')  default 'STANDARD',
seat_number int not null,
vehicle_status enum( 'ACTIVATE','MAINTENANCE','DEACTIVATED')  default 'ACTIVATE',
last_maintenance date,
is_deleted boolean default false,
url_img varchar(255) not null
);
create table maintenance(
id int primary key auto_increment,
fee double default 0,
maintenance_date date not null,
description varchar(255),
maintenance_time time not null,
id_car int not null,
id_employee int not null,
foreign key(id_car) references car(id),
foreign key(id_employee) references employee(id)
);
create table bus_route(
id int primary key auto_increment,
start_location varchar(255) not null,
end_location varchar(255) not null,
distance double not null check (distance > 0),
is_deleted boolean default false
);
create table revenue(
id int primary key auto_increment,
date_time date not null
);
create table promotion(
id int primary key auto_increment,
code varchar(255) unique not null,
discount int not null check (discount BETWEEN 0 AND 100),
start_date date not null,
end_date date not null
);
create table trip(
id int primary key auto_increment,
departure_time datetime not null,
expected_time varchar(255) not null,
status enum('NOTDEPARTED', 'DEPARTED', 'COMPLETED') default 'NOTDEPARTED',
is_deleted boolean default false,
id_bus_route int not null unique,
foreign key(id_bus_route) references bus_route(id)
);
create table ticket(
id int primary key auto_increment,
quantity int default 0,
price double not null,
status enum('PAID', 'UNPAID') default 'UNPAID',
date_time datetime not null,
id_customer int not null,
id_trip int not null,
id_revenue int not null,
id_promotion int not null,
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
id int primary key auto_increment,
assigned_time datetime not null,
id_car int not null,
id_trip int not null,
foreign key(id_car) references car(id),
foreign key(id_trip) references trip(id)
);
create table employees_assignment(
id int primary key auto_increment,
id_driver1 int not null ,
id_driver2 int not null ,
id_assistant int not null ,
id_trip int not null unique,
foreign key(id_driver1) references employee(id),
foreign key(id_driver2) references employee(id),
foreign key(id_assistant) references employee(id),
foreign key(id_trip) references trip(id)
);