create database tabelefx;
use tabelefx;
drop database tabelefx;

select * from log;
drop table log;
CREATE TABLE log (
    id INT unique auto_increment primary key,
    login varchar (20) unique not null,
    pass varchar (20) not null,
    role varchar (15) not null);
    
    insert into log (login,pass,role) values 
    ('admin','a','admin'),
	('maja','b','admin'),
	('user','u','user'),
	('basia','b','user');
    select * from log;
    Select login From log where login='admin';
    
    select*from employee;
    drop table employee;
    
    create table employee(
id_e int auto_increment unique primary key,
id_log_e int unique,
FirstName varchar(25),
LastName varchar(25),
service1 varchar(5),
service2 varchar(5),
foreign key (id_log_e) references log (id)
);


insert into employee (FirstName, LastName, service1, service2) values ("Admin", "Admin", "0", "0"), ("Maja", "Kowalska", "0", "0"),("User", "User", "0", "0"),("Basia", "Nowak", "0", "0") ;
drop table summary;
select * from summary;
create table summary(
id_summary int  auto_increment unique primary key,
id_em int,
Month int,
hrs_service1 varchar(5),
hrs_service2 varchar(5),
ttl_service1 float (15),
ttl_service2 float(15),
ttl_gross float (20),
ttl_net float (20),
ttl_sum float (20), 
foreign key (id_em) references employee(id_e)
);
create view users_accounts as select * from log inner join employee where employee.id_e=log.id;
select * from users_accounts;
create view employee_accounts as select id_e, login, pass, FirstName, LastName from users_accounts;
select* from employee_accounts;
drop view employee_accounts;
create view userss_earnings as select id, FirstName, LastName, Month, ttl_service1, ttl_service2, ttl_net, ttl_gross from users_accounts inner join summary where summary.id_em=users_accounts.id_e;
select* from userss_earnings;
drop view userss_earnings;

Alter table employee
add foreign key (id_log_e)
references log(id) 
on delete cascade;

Alter table summary
add foreign key (id_em)
references employee(id_e) 
on delete cascade;



Select id_e From employee, log where login="user" and employee.id_e = log.id ;

create view users_earnings as select * from employee inner join summary where summary.id_em=employee.id_e;
select* from users_earnings;
select * from employee_earnings;
create view employee_earnings as select id_em, FirstName, LastName, Month, ttl_gross, ttl_net, ttl_sum from users_earnings ;
drop view employee_earnings;

create table messages (
id_m int auto_increment unique primary key,
msg_from varchar (20),
msg_to varchar (20),
msg_subject varchar (30),
msg_content varchar (1000));

select * from messages;
DELETE FROM messages WHERE msg_content="s";
DELETE FROM messages WHERE msg_from="martyna";
drop table messages;

DELETE FROM employee WHERE id_e=4;

INSERT into messages (msg_from, msg_to, msg_subject, msg_content) values("a","a","a","a");

UPDATE log SET login='maja' ,pass='c' where id=2;

create database auth;
create database authreg;
create database testauth;
use testauth;
select * from user;
select * from user_rol;
