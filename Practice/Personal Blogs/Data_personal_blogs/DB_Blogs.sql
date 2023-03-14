use master
go

---Tạo blogs database
create database Blogs_DB

go
use Blogs_DB
go


--Information ussers

Drop table [dbo].[Users];

CREATE TABLE [dbo].[Users](
	[user_id] [nvarchar](10) NOT NULL,
	[role_id] [nvarchar](10) NOT NULL DEFAULT '4',
	[user_account] [nvarchar](10) NOT NULL,
	[user_password] [nvarchar](10) NOT NULL,
	[user_email] [nvarchar](25) NOT NULL,
	[user_name] [nvarchar](50) NULL,
	[user_gender] [bit] NULL,
	[user_dateofbirth] [date] NULL,
	[user_address] [nvarchar](50) NULL,
	[user_phone] [nvarchar](12) NULL,
	[user_avatar] [nvarchar](255) NULL,
	
	primary key([user_id],[user_account],[user_email])
) 

INSERT INTO [dbo].[Users]
VALUES ('14578963', '4', 'user0', '123', 'user123@gmail.com', 'Nguyen Van A', '1', '2002-01-01', 'ha noi', '0857689020', null);

INSERT INTO [dbo].[Users] ([user_id],[user_account],[user_password],[user_email],[user_name],[user_gender],[user_dateofbirth])
VALUES ('12628390', 'user1', '123', 'user124@gmail.com', 'Nguyen Van B', '0', '2002-01-01');

INSERT INTO [dbo].[Users]
VALUES ('18273647', '1','admin0', '123', 'admin123@gmail.com', 'Admin', '0', '2002-01-01', 'ha noi', '0857689020', null);

Select top 100 * from [dbo].[Users];



--Role of user


CREATE TABLE [dbo].[User_Role_Id](
	[user_id] [nvarchar](10) NOT NULL,
	[role_id] [nvarchar](10) NOT NULL,
	primary key([user_id],[role_id])
)

INSERT INTO [dbo].[User_Role_Id]
VALUES ('14578963', '4'),
	   ('18273647', '1');

Select top 100 * from [dbo].[User_Role_Id];



CREATE TABLE [dbo].[User_Role_Name](
	[role_id] [nvarchar](10) NOT NULL,
	[role_name] [nvarchar](10) NOT NULL,

	primary key([role_id])
)


INSERT INTO [dbo].[User_Role_Name] ([role_id], [role_name]) VALUES
('1', 'Admin'),
('2', 'Editor'),
('3', 'Poster'),
('4', 'User');



--Post

CREATE TABLE [dbo].[Posts](
	[post_id] [nvarchar](10) NOT NULL,
	[post_title] [nvarchar](100) NOT NULL,
	[post_thumb][nvarchar](255) NOT NULL,
	[topic_id][nvarchar](10) NOT NULL,
	[post_tag_id1] [nvarchar](10) NOT NULL,
	[post_tag_id2] [nvarchar](10) NULL,
	[post_tag_id3] [nvarchar](10) NULL,
	[post_tag_id4] [nvarchar](10) NULL,
	[post_tag_id5] [nvarchar](10) NULL,
	[post_create_date] date NOT NULL,
	[post_create_time] time NOT NULL,
	[post_body] text NOT NULL,
	[post_author] [nvarchar](100) NOT NULL,
	[post_img1] [nvarchar](255) NOT NULL,
	[post_img2] [nvarchar](255) NULL,
	[post_img3] [nvarchar](255) NULL,
	[post_img4] [nvarchar](255) NULL,
	[post_img5] [nvarchar](255) NULL,

	primary key([post_id],[topic_id],[post_tag_id1])
)


INSERT INTO [dbo].[Posts] ([post_id],[topic_id],[post_tag_id1],[post_thumb],[post_img1], [post_title],[post_body],[post_author],[post_create_date],[post_create_time]) VALUES
('1625374859','2673','142738','blog-10.png','blog-10.png', 'How to connect a React frontend with a NodeJS/Express backen',' The MERN (MongoDB, Express, React, NodeJS) stack is very popular for making full stack applications, utilizing Javascript for both the backend and frontend as well as a document-oriented or non relational database meaning that it s structured like JSON rather than a large excel sheet like SQL databases are.','admin','2022-10-10','10:10:10');

INSERT INTO [dbo].[Posts] ([post_id],[topic_id],[post_tag_id1],[post_thumb],[post_img1], [post_title],[post_body],[post_author],[post_create_date],[post_create_time]) VALUES
('2342784328','2673','142738','blog-10.png','blog-10.png', 'How to connect a React frontend with a NodeJS/Express backen',' The MERN (MongoDB, Express, React, NodeJS) stack is very popular for making full stack applications, utilizing Javascript for both the backend and frontend as well as a document-oriented or non relational database meaning that it s structured like JSON rather than a large excel sheet like SQL databases are.','admin','2022-10-10','10:10:10');

Select top 100 * from [dbo].[Posts];

--Category

CREATE TABLE [dbo].[Category](
	[category_id] [nvarchar](10) NOT NULL,
	[category_name] [nvarchar](20) NOT NULL,

	primary key([category_id],[category_name])
)

INSERT INTO [dbo].[Category] ([category_id], [category_name]) VALUES
('1', 'Dev'),
('2', 'Travel'),
('3', 'Anime'),
('4', 'Movie'),
('5', 'Music');


--Topics
Drop table [dbo].[Topics];

CREATE TABLE [dbo].[Topics](
	[category_id] [nvarchar](10) NOT NULL,
	[topic_id] [nvarchar](10) NOT NULL,
	[topic_name] [nvarchar](30) NOT NULL

	primary key([category_id],[topic_id])
)

INSERT INTO [dbo].[Topics] ([category_id], [topic_id],[topic_name]) VALUES
('1', '2673' ,'Font End'),
('1', '2537','Back End'),
('3', '1825','Anime mùa thu 2022'),
('4', '1628','Phim chiếu rạp tháng 12'),
('5', '4924','Jazz');





--Tags

Drop table [dbo].[Tags];

CREATE TABLE [dbo].[Tags](
	[topic_id] [nvarchar](10) NOT NULL,
	[tag_id] [nvarchar](10) NOT NULL,
	[tag_name] [nvarchar](20) NOT NULL,

	primary key([topic_id],[tag_id])
)

INSERT INTO [dbo].[Tags] ([topic_id], [tag_id] , [tag_name]) VALUES
('2673', '142738','html'),
('2673', '142538','css'),
('1825', '354816','doremon'),
('1825', '192638','naruto'),
('1628', '354627','home alone');

select count(*) from Posts 



Select p.*, tp.topic_name,c.category_id,c.category_name, im.img_filename from Posts p 
join Topics tp on p.topic_id = tp.topic_id 
join Categories c on c.category_id = tp.category_id
inner join Images im on p.post_id = im.post_id;

select * from Posts
where post_id= '4537628957'

Select * from Posts p join Topics tp on p.topic_id = tp.topic_id join Categories c on c.category_id = tp.category_id

Select ta.*, pt.post_id from Tags ta
join PostTag pt on ta.tag_id = pt.tag_id


Select u.*,ur.role_id,r.role_name from Users u 
join UserRole ur on u.user_id = ur.user_id
join Roles r on r.role_id = ur.role_id


Select * from Images 
Select * from Categories

Select t.*,p.post_id from Topics t
join Posts p on t.topic_id = p.topic_id

Select c.*,t.topic_id from Categories c
right join Topics t on  c.category_id = t.category_id

Select * from Images 
where post_id = '1526374657'

Select t.*,p.post_id from Topics t
join Posts p on t.topic_id = p.topic_id
where post_id ='1526374657'

Select c.*,t.topic_id from Categories c
join Topics t on  c.category_id = t.category_id
where topic_id ='2435'


Select t.*,p.post_id from Topics t
left join Posts p on t.topic_id = p.topic_id
where category_id ='435'

Select * from Categories 