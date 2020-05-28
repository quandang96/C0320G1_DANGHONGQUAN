create table  contacts
( contact_id Int(11) not null auto_increment,
last_name varchar(30) not null,
first_name varchar(25),
birthday date,
constraint contacts_pk primary key  (contact_id) 
);
create table suppliers
( supplier_id int(11) not null auto_increment,
  supplier_name varchar(50) not null,
  account_rep varchar(30) not null default 'TBD',
  constraint supplier_pk primary key (supplier_id)
  );
  #drop table customers,suppliers;
  alter table contacts
  add last_name2 varchar(40) not null
  after contact_id,
  add first_name2 varchar(35) null
  after last_name;
  
  alter table contacts
  modify last_name varchar(50) null;
  
  alter table contacts
  drop column last_name2;
  
  alter table contacts
  change column last_name last_name1 varchar(20) not null;
  
  alter table contacts 
  rename to people;
  
