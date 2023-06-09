USE [master]
GO

CREATE DATABASE PRJ321_FALL_2019_B5 
GO
USE PRJ321_FALL_2019_B5
GO

USE [PRJ321_FALL_2019_B5]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 12/11/2019 9:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 12/11/2019 9:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[gender] [bit] NOT NULL,
	[did] [int] NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 12/11/2019 9:17:24 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[gender] [bit] NOT NULL,
	[did] [int] NOT NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Department] ([id], [name]) VALUES (1, N'Information Technology')
INSERT [dbo].[Department] ([id], [name]) VALUES (2, N'Business Administration')
INSERT [dbo].[Department] ([id], [name]) VALUES (3, N'Data Science')
INSERT [dbo].[Department] ([id], [name]) VALUES (4, N'Marketing and PR')
INSERT [dbo].[Employee] ([id], [name], [gender], [did]) VALUES (1, N'Mr A', 1, 1)
INSERT [dbo].[Employee] ([id], [name], [gender], [did]) VALUES (2, N'Ms B', 0, 2)
INSERT [dbo].[Employee] ([id], [name], [gender], [did]) VALUES (3, N'MrC', 1, 3)
INSERT [dbo].[Employee] ([id], [name], [gender], [did]) VALUES (4, N'mr D', 1, 2)
INSERT [dbo].[Student] ([id], [name], [gender], [did]) VALUES (1, N'Mr A', 1, 1)
INSERT [dbo].[Student] ([id], [name], [gender], [did]) VALUES (2, N'Ms B', 0, 2)
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Department] FOREIGN KEY([did])
REFERENCES [dbo].[Department] ([id])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Department]
GO
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [FK_Student_Department] FOREIGN KEY([did])
REFERENCES [dbo].[Department] ([id])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK_Student_Department]
GO
