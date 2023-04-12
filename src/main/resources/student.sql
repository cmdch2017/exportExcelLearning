create table student
(
    testID int auto_increment
        primary key,
    name   varchar(30) not null comment '姓名',
    no     int         not null comment '学号'
);

