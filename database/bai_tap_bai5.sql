create database if not exists bai_tap_bai_5;
use bai_tap_bai_5;
create table product(
id int primary key auto_increment,
`name` varchar(255),
price double,
quantity int
);
insert into product(`name`,price,quantity) value("áo",20000,3);
insert into product(`name`,price,quantity) value("quần",20000,3);
insert into product(`name`,price,quantity) value("giày",20000,3);
insert into product(`name`,price,quantity) value("m",20000,3);
insert into product(`name`,price,quantity) value("giày",20000,3);
