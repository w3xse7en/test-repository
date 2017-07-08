# SSM-SalesSystem

IDE：Idea

版本控制：git

项目管理：Maven

框架：Spring+SpringMVC+Mybatis

目的：小型销售系统,类似taobao.com

how to easy work this project?

do you see the out/artifacts/ROOT

first: put the ROOT floder into your tomcat webapp floder

second: open ROOT/WEB-INF/classes/db.properties

now you must write your sql driver,name and password

third:write these into your sql and finally open your browser and enter localhost:8080

create table person(
id int auto_increment primary key comment "主键", 
userName varchar(100) comment "用户名", 
password varchar(100) comment "密码md5加密",
nickName varchar(50) comment "用户昵称",
userType tinyint(3) comment "类型，买家0，卖家1") 
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

create table content(
id int auto_increment primary key comment "主键",  
price bigint  comment "当前价格",
title varchar(100) comment "标题",
icon VARCHAR(100) comment "图片",
abstract varchar(200) comment "摘要",
text LONGTEXT comment "正文"  )
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

create table trx(
id int auto_increment primary key comment "主键",  
contentId int  comment "内容ID",
personId int comment "用户ID",
price int comment "购买价格",
time bigint comment "购买时间")
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

insert into `person` (`id`, `userName`, `password`, `nickName`, `userType`) values('1','buyer','37254660e226ea65ce6f1efd54233424','buyer','0');

insert into `person` (`id`, `userName`, `password`, `nickName`, `userType`) values('2','seller','981c57a5cfb0f868e064904b8745766f','seller','1');
