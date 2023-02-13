附加四个表
-- auto-generated definition
create table bkrr
(
    book_id   int null,
    id        int auto_increment
        primary key,
    reader_id int null
);

-- auto-generated definition
create table book
(
    book_id   int auto_increment
        primary key,
    book_name varchar(255) null
);

create table reader
(
    reader_id    int auto_increment
        primary key,
    reader_name  varchar(255) null,
    reader_hobby varchar(255) null,
    reader_age   varchar(255) null
);


-- auto-generated definition
create table country
(
id      int          not null
primary key,
country varchar(255) null
);

