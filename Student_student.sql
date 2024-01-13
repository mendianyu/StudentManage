create table student
(
    id      int         not null
        primary key,
    name    varchar(10) null,
    classes varchar(10) null,
    age     int         null,
    sex     varchar(10) null,
    tel     varchar(11) null
);

INSERT INTO Student.student (id, name, classes, age, sex, tel) VALUES (20211432, '王小五', '信2105-1', 21, '男', '17332062304');
INSERT INTO Student.student (id, name, classes, age, sex, tel) VALUES (20213222, '李文滨', '信2101-2', 21, '男', '18832252601');
INSERT INTO Student.student (id, name, classes, age, sex, tel) VALUES (20213231, '章若楠', '信2105-1', 20, '女', '13323456774');
INSERT INTO Student.student (id, name, classes, age, sex, tel) VALUES (20213471, '刘锡兵', '信2102-1', 20, '男', '18232632532');
INSERT INTO Student.student (id, name, classes, age, sex, tel) VALUES (20213888, '张思思', '信2103-1', 20, '女', '18132052502');
INSERT INTO Student.student (id, name, classes, age, sex, tel) VALUES (20213971, '门殿宇', '信2105-1', 20, '男', '18332052507');
INSERT INTO Student.student (id, name, classes, age, sex, tel) VALUES (20215425, '李萌', '信2105-2', 20, '女', '18532052503');
INSERT INTO Student.student (id, name, classes, age, sex, tel) VALUES (20217643, '蔡徐坤', '信2105-3', 22, '男', '18732042506');
INSERT INTO Student.student (id, name, classes, age, sex, tel) VALUES (20218888, '李明', '信2101-1', 21, '男', '13345678910');