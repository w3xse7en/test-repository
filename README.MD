SSM-SalesSystem

IDE：Idea

版本控制：git

项目管理：Maven

框架：Spring+SpringMVC+Mybatis

数据库：mysql

服务器：tomcat

如何看项目效果？

将out/artifacts/ROOT中的ROOT放入你的tomcat的webapps下面

修改位于ROOT/WEB-INF/classes/db.properties的配置

设置默认数据库ssm，在sql中添加下面的语句，然后打开浏览器进入localhost:8080

----------------------------------------------------------------------------------------------------------------------

how to easy work this project?

do you see the out/artifacts/ROOT

first: put the ROOT floder into your tomcat webapp floder

second: open ROOT/WEB-INF/classes/db.properties

now you must write your sql driver,name and password

third:set the database ssm and write below statement into your sql

finally open your browser and enter localhost:8080

----------------------------------------------------------------------------------------------------------------------

create table person(
id int auto_increment primary key comment "主键", 
userName varchar(100) comment "用户名", 
password varchar(100) comment "密码md5加密",
nickName varchar(50) comment "用户昵称",
userType tinyint(3) comment "类型，买家0，卖家1") 
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

create table content(
id int auto_increment primary key comment "主键",  
price double  comment "当前价格",
title varchar(100) comment "标题",
icon VARCHAR(100) comment "图片",
abstract varchar(200) comment "摘要",
text LONGTEXT comment "正文"  )
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

create table trx(
id int auto_increment primary key comment "主键",  
contentId int  comment "内容ID",
personId int comment "用户ID",
price double comment "购买价格",
num varchar(100)comment "交易数量",
time bigint comment "购买时间")
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

insert into `person` (`id`, `userName`, `password`, `nickName`, `userType`) values('1','buyer','37254660e226ea65ce6f1efd54233424','buyer','0');

insert into `person` (`id`, `userName`, `password`, `nickName`, `userType`) values('2','seller','981c57a5cfb0f868e064904b8745766f','seller','1');

insert into `person` (`id`, `userName`, `password`, `nickName`, `userType`) values('3','admin','099af53f601532dbd31e0ea99ffdeb64','admin','1');
