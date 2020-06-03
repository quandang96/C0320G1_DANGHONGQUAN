create table category(
category_id int primary key,
categoty_name varchar(100),
book_id int,
foreign key (book_id) references book(book_id)
);

create table book(
book_id int primary key,
book_name varchar(100)
);

create table student (
student_number int(15) primary key ,
student_name varchar(50),
address text(500),
email varchar(50) unique,
image_url varchar(255)
);

create table borrow_order(
id int primary key,
category_id int unique,
student_number int unique,
foreign key (category_id) references category(category_id),
foreign key (student_number) references student(student_number)

);