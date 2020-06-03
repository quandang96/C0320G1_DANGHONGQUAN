create table customer(
customer_number int  primary key auto_increment,
fullname varchar(50),
address varchar(255),
email varchar(50),
phone int(10)
);

create table accounts(
account_number int primary key auto_increment,
account_type varchar(50),
dates date,
balance int,
customer_number int, foreign key (customer_number) references customer(customer_number)
);

create table trancustomersactions(
tran_number int  primary key auto_increment,
account_number int,
dates date,
amounts int,
descriptions varchar(100),
customer_number int, foreign key (customer_number) references accounts(customer_number)
);


