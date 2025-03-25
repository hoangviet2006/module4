create database if not exists customer;
use customer;
create table customer(
id int primary key auto_increment,
`name` varchar(255),
email varchar(255),
address varchar(255)
);
insert into customer(`name`,email,address) value("viet","haha@gail.com","hue");
SELECT *  FROM Customer AS c;