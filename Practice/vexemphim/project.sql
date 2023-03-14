create database projectPRJ


create table Users(
	UserId int NOT NULL IDENTITY(1,1)  ,
	account nvarchar(50),
	Password nvarchar(50),
	fullname nvarchar(50),
	email nvarchar(50),
	sdt nvarchar(20),
	address nvarchar(50),
	gender nvarchar(50),
	dateofbirth nvarchar(50),
	PRIMARY KEY (account)
)

create table Ticket(
	ticketID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	seatID nvarchar(50),
	movieID nvarchar(50),
	account nvarchar(50),
	foreign key (account) references Users(account)
)

drop table movie
create table Cinema(
	cinemaID int NOT NULL IDENTITY(1,1),
	nameCinema nvarchar(50) PRIMARY KEY,
	address nvarchar(50),
	ticketID int,
	foreign key (ticketID) references Ticket(ticketID)
)
create table room(
	roomID int NOT NULL IDENTITY(1,1),
	roomName nvarchar(50) PRIMARY KEY,
	nameCinema nvarchar(50),
	foreign key (nameCinema) references Cinema(nameCinema)
)
drop table movie
create table movie(
	movieID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	moviename nvarchar(50),
	detail text,
	thoiluong nvarchar(50),
	loai nvarchar(50),
	trailer nvarchar(50),
	poster nvarchar(50),
	images nvarchar(MAX),
	nameCinema nvarchar(50),
	foreign key (nameCinema) references Cinema(nameCinema)
)
create table Ticket_price(
	ticket_price int primary key,
	ticketID int,
	foreign key (ticketID) references ticket(ticketID)
)

create table Seat(
	seatid int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	seatname nvarchar(50),
	roomName nvarchar(50),
	foreign key (roomName) references room(roomName)
 )