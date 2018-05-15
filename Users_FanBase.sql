drop table if exists Images;
drop table if exists Users;

create table Users (
Username varchar(45) not null primary key,
User_Password varchar(45)
);
create table Images (
Image_Id int not null primary key auto_increment,
Username varchar(45),
Image_Name varchar(90),
Description varchar(180),
Image mediumblob NOT NULL,
foreign key (`Username`) references Users(`Username`)
);

create table Test (

Image mediumblob NOT NULL

);
INSERT  into Users (Username, User_Password) Values ('madridfan', 'cr7');
INSERT  into Users (Username, User_Password) Values ('bayernfan', 'fcb');

