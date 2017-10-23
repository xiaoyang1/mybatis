1 create database mybatis_test;
2 use mybatis;
3 CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT);
4 INSERT INTO users(NAME, age) VALUES('孤傲苍狼', 27);
5 INSERT INTO users(NAME, age) VALUES('白虎神皇', 27);

create table teacher(
   t_id int primary key auto_increment,
   t_name varchar(20)
);
create table class(
   c_id int primary key auto_increment,
   c_name varchar(20),
   teacher_id INT,
   foreign key (teacher_id) references teacher(t_id)
);

insert into teacher(t_name) values('ls1');
insert into teacher(t_name) values('ls2');

insert into class(c_name,teacher_id) values('bj_a',1);
insert into class(c_name,teacher_id) values('bj_b',2);

select * from class where c_id =1;
##1.连表查询
select * from class c,teacher t  where c.teacher_id = t.t_id and c.c_id=2
##2 执行两次查询
select * from class where c_id = 2
select * from teacher where t_id=1


create table student(
   s_id int primary key auto_increment,
   s_name varchar(20),
   class_id int
);

insert into student(s_name,class_id)values('xs_A',1);
insert into student(s_name,class_id)values('xs_B',1);
insert into student(s_name,class_id)values('xs_C',1);
insert into student(s_name,class_id)values('xs_D',2);
insert into student(s_name,class_id)values('xs_E',2);
insert into student(s_name,class_id)values('xs_F',2);

select * from class where c_id=1

select * from class c,student s where c.c_id=s.class_id and c_id =2;


 CREATE TABLE d_user(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(10), age INT(3));
 INSERT INTO d_user(NAME, age) VALUES('tom', 12);
 INSERT INTO d_user(NAME, age) VALUES('bob', 13);
 INSERT INTO d_user(NAME, age) VALUES('jack', 18);

 select * from d_user where age

 create table p_user(
    id int primary key auto_increment,
    name varchar(10),
    sex char(2)
 );

  insert into p_user(name,sex) values('A',"m");
  insert into p_user(name,sex) values('B',"f");
  insert into p_user(name,sex) values('C',"m");
//in 是输入参数，类型int ，out是输出参数，
delimiter $
create procedure mybatis.get_user_count(IN sex_id int,out user_count int)
begin
if sex_id=0 then
select count(*) from mybatis.p_user where p_user.sex='f' into user_count;
else
select count(*) from mybatis.p_user where p_user.sex='m' into user_count;
end if;
end
$

//调用存储过程
set @user_count = 0;
call mybatis.get_user_count(0,@user_count);
select @user_count;