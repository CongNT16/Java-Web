USE [master]
GO

CREATE DATABASE [MyOrder] 
GO
USE [MyOrder]
GO

CREATE TABLE [dbo].[Users](
	[account] [nchar](10) NOT NULL,
	[Password] [nchar](10) NULL,
	[name] [nvarchar](50) NULL,
	[gender] [bit] NULL,
	[address] [nvarchar](50) NULL,
	[dateofbirth] [date] NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[account] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL primary key,
	[CategoryName] [nvarchar](50) NULL
)
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](50) NULL,
	[UnitPrice] [money] NULL,
	[UnitsInStock] [int] NULL,
	[Image] [nvarchar](max),
	[CategoryID] [int] NULL,
	[Discontinued] [bit] NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[CustomerID] [int] IDENTITY(1,1) NOT NULL,
	[CustomerName] [nvarchar](50) NOT NULL,
	[Gender] [bit] NOT NULL,
	[Address] [nvarchar](50) NULL,
	[Birthdate] [datetime] NULL,
 CONSTRAINT [PK_Customers] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[CustomerID] [varchar](10) NOT NULL,
	[OrderDate] [datetime] NOT NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderItems](
	[OrderItemID] [int] IDENTITY(1,1) NOT NULL,
	[OrderID] [numeric](18, 0) NOT NULL,
	[ProductID] [varchar](10) NOT NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_OrderItems] PRIMARY KEY CLUSTERED 
(
	[OrderItemID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (1, N'Laptop')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (2, N'PC')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (3, N'Mobile')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (4, N'Tablet')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([ProductID], [ProductName], [UnitPrice], [UnitsInStock],[Image], [CategoryID], [Discontinued]) VALUES (1, N'Laptop Acer', 10.0000, 100,'', 3, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [UnitPrice], [UnitsInStock],[Image], [CategoryID], [Discontinued]) VALUES (2, N'Printer Sony', 15.5000, 50,'', 2, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [UnitPrice], [UnitsInStock],[Image], [CategoryID], [Discontinued]) VALUES (3, N'Projector HP', 16.5000, 250,'', 1, 0)
INSERT [dbo].[Products] ([ProductID], [ProductName], [UnitPrice], [UnitsInStock],[Image], [CategoryID], [Discontinued]) VALUES (4, N'Camery Sony', 15.5000, 100,'', 4, 1)
INSERT [dbo].[Products] ([ProductID], [ProductName], [UnitPrice], [UnitsInStock],[Image], [CategoryID], [Discontinued]) VALUES (5, N'PC Compact', 20.5000, 100,'', 3, 1)
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Categories] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Categories] ([CategoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Categories]
GO

SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderID], [CustomerId], [OrderDate]) VALUES (1, 1, '2022-01-01')
INSERT [dbo].[Orders] ([OrderID], [CustomerId], [OrderDate]) VALUES (2, 1, '2022-05-05')
INSERT [dbo].[Orders] ([OrderID], [CustomerId], [OrderDate]) VALUES (3, 2, '2022-07-07')
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO

SET IDENTITY_INSERT [dbo].[OrderItems] ON 

INSERT [dbo].[OrderItems] ([OrderItemID],[OrderID], [ProductID], [Quantity]) VALUES (1,1, 1, 3)
INSERT [dbo].[OrderItems] ([OrderItemID],[OrderID], [ProductID], [Quantity]) VALUES (2,1, 2, 12)
INSERT [dbo].[OrderItems] ([OrderItemID],[OrderID], [ProductID], [Quantity]) VALUES (3,1, 3, 1)
INSERT [dbo].[OrderItems] ([OrderItemID],[OrderID], [ProductID], [Quantity]) VALUES (4,2, 4, 31)
INSERT [dbo].[OrderItems] ([OrderItemID],[OrderID], [ProductID], [Quantity]) VALUES (5,2, 3, 1)
INSERT [dbo].[OrderItems] ([OrderItemID],[OrderID], [ProductID], [Quantity]) VALUES (6,3, 5, 3)
SET IDENTITY_INSERT [dbo].[OrderItems] OFF
GO

SET IDENTITY_INSERT [dbo].[Customers] ON 
INSERT [dbo].[Customers] ([CustomerId], [CustomerName], [Birthdate], [Gender], [Address]) VALUES (1, N'Nguyen Van A', '1986-01-01', 1, N'Gia Lâm, Hà Nội')
INSERT [dbo].[Customers] ([CustomerId], [CustomerName], [Birthdate], [Gender], [Address]) VALUES (2, N'Nguyen Van B', '1990-06-03', 1, N'Lương Sơn, Hòa Bình')
INSERT [dbo].[Customers] ([CustomerId], [CustomerName], [Birthdate], [Gender], [Address]) VALUES (3, N'Nguyen Thi C', '1985-11-10', 0, N'Sapa, Lào Cai')
INSERT [dbo].[Customers] ([CustomerId], [CustomerName], [Birthdate], [Gender], [Address]) VALUES (4, N'Nguyen Van D', '2000-01-09', 1, N'Thạch Thất, Hà Nội')
INSERT [dbo].[Customers] ([CustomerId], [CustomerName], [Birthdate], [Gender], [Address]) VALUES (5, N'Nguyen Thi E', '1996-11-01', 0, N'Lý Nhân, Hà Nam')
SET IDENTITY_INSERT [dbo].[Customers] OFF
GO

INSERT [dbo].[Users] ([Account], [Password], [Name], [Gender], [Address]) VALUES ('admin', '123',N'Nguyen Van A', 1, N'Gia Lâm, Hà Nội')
GO

Select * from Products

insert into Products ([ProductName],[UnitPrice],[UnitsInStock],[Image],[CategoryID],[Discontinued])
values ('Laptop Lenovo','10','100','anh1.jpg','1','0')


DELETE FROM Products WHERE ProductID='8'

UPDATE Products
SET [ProductName] = 'Smartphone Sony', [UnitPrice]= '10'
WHERE [ProductID] = '7';