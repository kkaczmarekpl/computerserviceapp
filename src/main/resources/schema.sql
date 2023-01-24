IF NOT EXISTS (SELECT name FROM master.sys.databases WHERE name = N'computerservicedb')
BEGIN
    CREATE DATABASE computerservicedb
END
GO

IF NOT EXISTS  (SELECT * FROM sys.tables where name = N'CompanyClient')
BEGIN
	CREATE TABLE [dbo].[CompanyClient](
		[ID] [int] IDENTITY(1,1) NOT NULL,
		[CompanyName] [varchar](255) NOT NULL,
		[NIP] [int] NOT NULL,
		[REGON] [int] NULL,
		[FK_AddressID] [int] NOT NULL,
		CONSTRAINT PK_CompanyID PRIMARY KEY CLUSTERED
		(
			[ID] ASC
		)
	) ON [PRIMARY]
END
GO

IF NOT EXISTS  (SELECT * FROM sys.tables where name = N'Address')
BEGIN
	CREATE TABLE [dbo].[Address](
		[ID] [int] IDENTITY(1,1) NOT NULL,
		[CityName] [varchar](255) NOT NULL,
		[PostalCode] [varchar](255) NOT NULL,
		[StreetName] [varchar](255) NULL,
		[ApartmentNumber] [varchar](255) NULL,
		[HouseNumber] [varchar](255) NOT NULL,
		CONSTRAINT PK_AddressID PRIMARY KEY CLUSTERED
		(
			[ID] ASC
		)
	) ON [PRIMARY]
END
GO