USE [Library_system]
GO
/****** Object:  Table [dbo].[Books_]    Script Date: 22.05.2023 12:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books_](
	[BookID] [int] IDENTITY(1,1) NOT NULL,
	[BookName] [nvarchar](50) NULL,
	[BookNumber_of_Pages] [int] NULL,
	[Book_is_Selected] [bit] NULL,
	[WriterID] [int] NULL,
	[BookTypeID] [int] NULL,
 CONSTRAINT [PK_Books_] PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BookType]    Script Date: 22.05.2023 12:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookType](
	[BookTypeID] [int] IDENTITY(1,1) NOT NULL,
	[BookTypeName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_BookType] PRIMARY KEY CLUSTERED 
(
	[BookTypeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Process]    Script Date: 22.05.2023 12:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Process](
	[ProcessID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NULL,
	[StudentID] [int] NULL,
	[BookID] [int] NULL,
	[WriterID] [int] NULL,
	[BookTypeID] [int] NULL,
	[P.ReceivedDate] [date] NOT NULL,
	[BookGiveDate] [date] NOT NULL,
 CONSTRAINT [PK_Process] PRIMARY KEY CLUSTERED 
(
	[ProcessID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Students]    Script Date: 22.05.2023 12:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Students](
	[StudentID] [int] IDENTITY(1,1) NOT NULL,
	[StudentName] [nvarchar](50) NULL,
	[StudentLastname] [nvarchar](50) NULL,
	[StudentGender] [nchar](50) NULL,
	[StudentBirtday] [date] NULL,
	[StudentPoint] [int] NULL,
 CONSTRAINT [PK_Students] PRIMARY KEY CLUSTERED 
(
	[StudentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 22.05.2023 12:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserID] [int] NOT NULL,
	[UserName] [nchar](50) NOT NULL,
	[UserLastName] [nchar](50) NOT NULL,
	[UserPassword] [sql_variant] NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Writer]    Script Date: 22.05.2023 12:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Writer](
	[WriterID] [int] IDENTITY(1,1) NOT NULL,
	[WriterName] [nvarchar](50) NOT NULL,
	[WriterLastname] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Writer] PRIMARY KEY CLUSTERED 
(
	[WriterID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Books_] ON 

INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (1, N'Helping The North', 280, 1, 3, 1)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (2, N'Choking In The Shadows', 210, 0, 28, 11)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (3, N'Drinking At My End', 290, 1, 24, 9)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (4, N'Shelter In The East', 700, 1, 3, 6)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (5, N'Whispers In My Friends', 100, 1, 40, 5)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (6, N'Faith Of The Hunter', 250, 1, 10, 4)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (7, N'Learning From The Depths', 240, 1, 11, 2)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (8, N'Bleeding At The Dark', 170, 1, 35, 3)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (9, N'Blinded In Time', 450, 1, 11, 8)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (10, N'Visiting The Animals', 470, 1, 33, 10)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (11, N'Punished By The East', 363, 1, 32, 6)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (12, N'Punished By The East', 229, 1, 21, 2)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (13, N'Choking In The Shadows', 385, 1, 19, 3)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (14, N'Laughing At The Void', 365, 1, 33, 5)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (15, N'Death In The King', 280, 1, 24, 4)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (16, N'Invited By The Mist', 180, 1, 25, 9)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (17, N'Vultures And Fish', 195, 1, 4, 8)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (18, N'Death In The Night', 860, 1, 22, 6)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (19, N'Changing The Void', 352, 1, 36, 3)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (20, N'Walking A Storm', 600, 1, 38, 4)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (21, N'Accepting The Dungeons', 630, 1, 31, 11)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (22, N'Faith Of My Future', 610, 1, 18, 5)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (23, N'Listening To The Mist', 720, 1, 35, 9)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (24, N'Helping The North', 280, 1, 3, 7)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (25, N'Belonging To My Wife', 873, 1, 17, 2)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (26, N'Life At The Mines', 705, 1, 9, 3)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (27, N'Rescue At The Fog', 276, 1, 25, 8)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (28, N'Screams At The Slaves', 836, 1, 29, 9)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (29, N'Pleasing The Mist', 153, 1, 33, 1)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (30, N'Separated At The Angels', 195, 1, 30, 4)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (31, N'Travel To The East', 245, 1, 40, 6)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (32, N'Chasing The West', 763, 1, 24, 8)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (33, N'Remember The Ocean', 877, 1, 8, 9)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (34, N'Life Beneath The Universe', 430, 1, 12, 10)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (35, N'Life Beneath The Universe', 131, 1, 13, 11)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (36, N'Blinded In The Animals', 305, 1, 14, 4)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (37, N'Helping The Moon', 669, 1, 13, 8)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (38, N'Praised By The World', 568, 1, 16, 7)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (39, N'Forsaken By Nature', 721, 1, 6, 4)
INSERT [dbo].[Books_] ([BookID], [BookName], [BookNumber_of_Pages], [Book_is_Selected], [WriterID], [BookTypeID]) VALUES (40, N'Vanish At The Darkness', 813, 1, 36, 6)
SET IDENTITY_INSERT [dbo].[Books_] OFF
GO
SET IDENTITY_INSERT [dbo].[BookType] ON 

INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (1, N'Serüven Roman')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (2, N'Psikolojik Roman')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (3, N'Dini Kitap')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (4, N'Ansiklopedi')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (5, N'Durum Hikayesi')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (6, N'Olay Hikayesi')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (7, N'Modern Hikaye')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (8, N'Toplumsal Gerçekçi Hikaye')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (9, N'Gotik Hikaye')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (10, N'Mizah Hikayesi')
INSERT [dbo].[BookType] ([BookTypeID], [BookTypeName]) VALUES (11, N'Korku Hikayesi')
SET IDENTITY_INSERT [dbo].[BookType] OFF
GO
SET IDENTITY_INSERT [dbo].[Process] ON 

INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (1, 1, 1, 1, 1, 1, CAST(N'1980-01-03' AS Date), CAST(N'1980-12-03' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (2, 2, 4, 2, 4, 2, CAST(N'2008-04-04' AS Date), CAST(N'2008-04-19' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (3, 3, 5, 3, 5, 3, CAST(N'1970-05-27' AS Date), CAST(N'1970-06-12' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (4, 4, 7, 4, 6, 4, CAST(N'1983-05-29' AS Date), CAST(N'1983-06-14' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (5, 5, 9, 5, 11, 5, CAST(N'1991-01-15' AS Date), CAST(N'1991-01-30' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (6, 6, 11, 6, 13, 6, CAST(N'1981-05-07' AS Date), CAST(N'1981-05-22' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (7, 7, 12, 7, 15, 7, CAST(N'1968-02-29' AS Date), CAST(N'1968-03-14' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (8, 8, 15, 10, 14, 8, CAST(N'1961-07-17' AS Date), CAST(N'1961-08-01' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (9, 9, 14, 14, 18, 9, CAST(N'2019-12-26' AS Date), CAST(N'2020-01-11' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (10, 11, 13, 16, 19, 10, CAST(N'1983-07-27' AS Date), CAST(N'1983-08-12' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (11, 12, 18, 18, 16, 11, CAST(N'2020-03-25' AS Date), CAST(N'2020-04-10' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (12, 13, 20, 21, 26, 4, CAST(N'1986-05-15' AS Date), CAST(N'1986-05-30' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (13, 14, 22, 19, 25, 5, CAST(N'2018-08-28' AS Date), CAST(N'2018-09-13' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (14, 15, 21, 24, 35, 6, CAST(N'2018-08-14' AS Date), CAST(N'2018-08-29' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (15, 16, 24, 22, 34, 7, CAST(N'2002-04-20' AS Date), CAST(N'2002-05-05' AS Date))
INSERT [dbo].[Process] ([ProcessID], [UserID], [StudentID], [BookID], [WriterID], [BookTypeID], [P.ReceivedDate], [BookGiveDate]) VALUES (16, 17, 23, 23, 30, 8, CAST(N'1992-05-30' AS Date), CAST(N'1992-06-15' AS Date))
SET IDENTITY_INSERT [dbo].[Process] OFF
GO
SET IDENTITY_INSERT [dbo].[Students] ON 

INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (1, N'ZELİHA', N'ÖNAL', N'Kadın                                             ', CAST(N'2074-01-17' AS Date), 60)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (2, N'SEYFULLAH', N'BUDAKÇI', N'Erkek                                             ', CAST(N'2075-12-15' AS Date), 35)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (3, N'ÖMÜR', N'CEYHAN', N'Kadın                                             ', CAST(N'2037-05-19' AS Date), 80)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (4, N'ÖZLEM', N'ÇENETOĞLU', N'Kadın                                             ', CAST(N'2037-05-19' AS Date), 68)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (5, N'REZAN', N'AKOL', N'Erkek                                             ', CAST(N'1964-06-05' AS Date), 75)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (6, N'GÜLFEM', N'BARBAROS', N'Erkek                                             ', CAST(N'2063-03-28' AS Date), 35)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (7, N'AYDEMİR', N'ÇÖLBE', N'Erkek                                             ', CAST(N'1993-07-10' AS Date), 90)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (8, N'DİLEK', N'CANDEMİR', N'Kadın                                             ', CAST(N'2053-11-29' AS Date), 31)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (9, N'YILDIZ', N'AKOVA', N'Kadın                                             ', CAST(N'2079-11-02' AS Date), 68)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (10, N'PINAR', N'KIRLI', N'Kadın                                             ', CAST(N'2010-11-09' AS Date), 70)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (11, N'MUHAMMED TAHA', N'KAN', N'Erkek                                             ', CAST(N'2053-01-01' AS Date), 86)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (12, N'ADA', N'ULUBA', N'Kadın                                             ', CAST(N'1989-12-25' AS Date), 90)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (13, N'SUNAY', N'KINIK', N'Kadın                                             ', CAST(N'2037-02-19' AS Date), 45)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (14, N'CAHİDE', N'GÜRLER', N'Kadın                                             ', CAST(N'2075-04-18' AS Date), 70)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (15, N'ÖMER GÖKHAN', N'MERSİN', N'Erkek                                             ', CAST(N'2028-01-30' AS Date), 62)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (16, N'VİLDAN', N'YAKICI', N'Kadın                                             ', CAST(N'2020-05-17' AS Date), 79)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (17, N'ABDULKADİR', N'ÇİLEK', N'Erkek                                             ', CAST(N'2052-02-23' AS Date), 78)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (18, N'ABDULGAFUR', N'ALABAY', N'Erkek                                             ', CAST(N'1986-09-21' AS Date), 90)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (19, N'EMRE MERTER', N'FAYDACI', N'Erkek                                             ', CAST(N'1973-05-21' AS Date), 45)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (20, N'MELİKE', N'ÇINARLIK', N'Kadın                                             ', CAST(N'1963-03-05' AS Date), 17)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (21, N'NECMİYE GÜL', N'TEZER', N'Kadın                                             ', CAST(N'2012-03-17' AS Date), 89)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (22, N'TOYANÇ', N'OLMAZ', N'Erkek                                             ', CAST(N'1970-05-16' AS Date), 90)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (23, N'MEHMETCAN', N'ÖZSARAÇ', N'Erkek                                             ', CAST(N'2052-01-19' AS Date), 0)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (24, N'ORGÜL DERYA', N'ÇIBIK', N'Kadın                                             ', CAST(N'1989-11-15' AS Date), 45)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (25, N'ENVER', N'SÜZEN', N'Erkek                                             ', CAST(N'1961-03-29' AS Date), 67)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (26, N'ELİF NİHAL', N'GÜRPINAR', N'Kadın                                             ', CAST(N'1996-10-25' AS Date), 98)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (27, N'GURBET', N'BAĞLI', N'Kadın                                             ', CAST(N'1987-12-28' AS Date), 100)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (28, N'ÇAĞAN', N'EMLEK', N'Kadın                                             ', CAST(N'2027-02-13' AS Date), 78)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (29, N'BURÇİN', N'KINALIOĞLU', N'Kadın                                             ', CAST(N'2036-06-11' AS Date), 77)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (30, N'SERHAT', N'DÜZGÜN', N'Erkek                                             ', CAST(N'2039-05-10' AS Date), 76)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (31, N'BARKIN', N'OYANIK', N'Erkek                                             ', CAST(N'2012-07-12' AS Date), 98)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (32, N'SEBİHA', N'YALINKILIÇ', N'Kadın                                             ', CAST(N'2078-10-30' AS Date), 54)
INSERT [dbo].[Students] ([StudentID], [StudentName], [StudentLastname], [StudentGender], [StudentBirtday], [StudentPoint]) VALUES (33, N'EYYÜP', N'ABACIOĞLU', N'Erkek                                             ', CAST(N'2004-11-03' AS Date), 53)
SET IDENTITY_INSERT [dbo].[Students] OFF
GO
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (1, N'Ahmet                                             ', N'Kılınç                                            ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (2, N'MEVLÜT                                            ', N'KURU                                              ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (3, N'ERSAGUN                                           ', N'ÖZDOĞRU                                           ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (4, N'AYŞEGÜL                                           ', N'TÜRKASLAN                                         ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (5, N'SONER                                             ', N'BALCIOĞLU                                         ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (6, N'SAVAŞ                                             ', N'ÇOLAKEROL                                         ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (7, N'FUNDA                                             ', N'SARIOĞLU                                          ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (8, N'MEHMED                                            ', N'AKBAY                                             ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (9, N'CÖMERT                                            ', N'AKSEL                                             ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (10, N'BENGÜHAN                                          ', N'ÖÇAL                                              ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (11, N'ZARİFE                                            ', N'YÖNET                                             ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (12, N'KAMERCAN                                          ', N'ADISANLI                                          ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (13, N'GÖNÜL                                             ', N'KAYABAŞI                                          ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (14, N'BERİL GÜLÜŞ                                       ', N'YENİÇERİ                                          ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (15, N'GÖKÇE                                             ', N'BOLKAN                                            ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (16, N'CEM ÖZGÜR                                         ', N'SAĞ                                               ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (17, N'DERYA                                             ', N'AKYOL                                             ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (18, N'SALİH                                             ', N'ALBAŞ                                             ', CAST(1234 AS int))
INSERT [dbo].[Users] ([UserID], [UserName], [UserLastName], [UserPassword]) VALUES (19, N'ECENUR                                            ', N'ŞAŞMAZ                                            ', CAST(1234 AS int))
GO
SET IDENTITY_INSERT [dbo].[Writer] ON 

INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (1, N'Lauren', N'Smith')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (2, N'Anthony', N'Burke')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (3, N'Linda', N'Hernandez')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (4, N'Rachel', N'Pratt')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (5, N'Stanley', N'Alexander')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (6, N'Michael', N'Jones')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (7, N'Kelly', N'Johnson')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (8, N'Brenda', N'Wallace')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (9, N'Ashley', N'Hampton')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (10, N'Brandi', N'Gould')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (11, N'Jacob', N'Charles')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (12, N'Dr. Tyler', N'Williams')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (13, N'Natasha', N'Miller')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (14, N'Gregory', N'Morris')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (15, N'Audrey', N'Green')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (16, N'Theresa', N'Flores')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (17, N'Erin', N'Reeves')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (18, N'Mrs. Julie', N'Montoya')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (19, N'Pamela', N'Vaughn')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (20, N'Steven', N'Anderson')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (21, N'Regina', N'Dudley')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (22, N'Christine', N'Bell')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (23, N'Michael', N'Smith')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (24, N'Melanie', N'Harrison')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (25, N'Lauren', N'Cantu')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (26, N'Jennifer', N'Cruz')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (27, N'Mr. Ivan', N'Orr')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (28, N'Melissa', N'Coleman')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (29, N'Jason', N'Powers')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (30, N'Crystal', N'Moore')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (31, N'Jessica', N'Wu')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (32, N'Justin', N'Miller')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (33, N'Alyssa', N'Henson')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (34, N'Dr. Lori', N'Lawrence')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (35, N'Steven', N'Barber')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (36, N'Elizabeth', N'Swanson')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (37, N'Miss Karen', N'Jenkins')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (38, N'Sue', N'Shea')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (39, N'Ryan', N'Robertson')
INSERT [dbo].[Writer] ([WriterID], [WriterName], [WriterLastname]) VALUES (40, N'Thomas', N'Thomas')
SET IDENTITY_INSERT [dbo].[Writer] OFF
GO
ALTER TABLE [dbo].[Books_]  WITH CHECK ADD  CONSTRAINT [FK_Books__BookType] FOREIGN KEY([BookTypeID])
REFERENCES [dbo].[BookType] ([BookTypeID])
GO
ALTER TABLE [dbo].[Books_] CHECK CONSTRAINT [FK_Books__BookType]
GO
ALTER TABLE [dbo].[Books_]  WITH CHECK ADD  CONSTRAINT [FK_Books__Writer] FOREIGN KEY([WriterID])
REFERENCES [dbo].[Writer] ([WriterID])
GO
ALTER TABLE [dbo].[Books_] CHECK CONSTRAINT [FK_Books__Writer]
GO
ALTER TABLE [dbo].[Process]  WITH CHECK ADD  CONSTRAINT [FK_Process_Books_] FOREIGN KEY([BookID])
REFERENCES [dbo].[Books_] ([BookID])
GO
ALTER TABLE [dbo].[Process] CHECK CONSTRAINT [FK_Process_Books_]
GO
ALTER TABLE [dbo].[Process]  WITH CHECK ADD  CONSTRAINT [FK_Process_BookType] FOREIGN KEY([BookTypeID])
REFERENCES [dbo].[BookType] ([BookTypeID])
GO
ALTER TABLE [dbo].[Process] CHECK CONSTRAINT [FK_Process_BookType]
GO
ALTER TABLE [dbo].[Process]  WITH CHECK ADD  CONSTRAINT [FK_Process_Students] FOREIGN KEY([StudentID])
REFERENCES [dbo].[Students] ([StudentID])
GO
ALTER TABLE [dbo].[Process] CHECK CONSTRAINT [FK_Process_Students]
GO
ALTER TABLE [dbo].[Process]  WITH CHECK ADD  CONSTRAINT [FK_Process_Users] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Process] CHECK CONSTRAINT [FK_Process_Users]
GO
ALTER TABLE [dbo].[Process]  WITH CHECK ADD  CONSTRAINT [FK_Process_Writer] FOREIGN KEY([WriterID])
REFERENCES [dbo].[Writer] ([WriterID])
GO
ALTER TABLE [dbo].[Process] CHECK CONSTRAINT [FK_Process_Writer]
GO
