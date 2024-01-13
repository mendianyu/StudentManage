create table admin
(
    account  varchar(10) not null
        primary key,
    password varchar(10) null
);

INSERT INTO Student.admin (account, password) VALUES ('admin', '1');