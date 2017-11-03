USE [API]
GO
/****** Object:  Table [dbo].[Calificacion]    Script Date: 03/11/2017 18:11:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Calificacion](
	[idCalificacion] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [datetime] NULL,
	[idTransaccion] [int] NULL,
	[valor] [int] NULL,
	[obs] [text] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CtaCorriente]    Script Date: 03/11/2017 18:11:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CtaCorriente](
	[numCuenta] [int] NOT NULL,
	[titular] [varchar](50) NULL,
	[saldo] [decimal](18, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[numCuenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Operacion]    Script Date: 03/11/2017 18:11:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Operacion](
	[idOperacion] [int] IDENTITY(1,1) NOT NULL,
	[titulo] [varchar](100) NULL,
	[descripcion] [text] NULL,
	[fechaDesde] [datetime] NULL,
	[fechaHasta] [datetime] NULL,
	[efectivo] [bit] NULL,
	[tarjeta] [bit] NULL,
	[trasferecia] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idOperacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Productos]    Script Date: 03/11/2017 18:11:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Productos](
	[id] [int] NOT NULL,
	[tiempoGarantia] [int] NULL,
	[detalle] [varchar](100) NULL,
	[Nombre] [varchar](100) NULL,
	[tipoGarantia] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Publicaciones]    Script Date: 03/11/2017 18:11:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Publicaciones](
	[nombreUsuario] [varchar](100) NOT NULL,
	[nombreProductoServicio] [varchar](100) NOT NULL,
	[tipo] [varchar](20) NOT NULL,
	[fechaPublicacion] [datetime] NULL,
	[fechaHastaVigenciaPublicacion] [datetime] NULL,
	[precio] [decimal](18, 0) NULL,
	[efectivo] [bit] NULL,
	[tarjeta] [bit] NULL,
	[transferencia] [bit] NULL,
 CONSTRAINT [PK_Publicaciones_1] PRIMARY KEY CLUSTERED 
(
	[nombreProductoServicio] ASC,
	[nombreUsuario] ASC,
	[tipo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Servicios]    Script Date: 03/11/2017 18:11:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Servicios](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[detalle] [varchar](100) NULL,
	[nombre] [varchar](100) NULL,
	[tipoContratacion] [varchar](100) NULL,
 CONSTRAINT [PK_Servicios] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subasta]    Script Date: 03/11/2017 18:11:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subasta](
	[idOperacion] [int] NOT NULL,
	[precioMinimo] [decimal](18, 0) NULL,
	[diasVigencia] [int] NULL,
	[precioIni] [decimal](18, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[idOperacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TiposContratacion]    Script Date: 03/11/2017 18:11:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TiposContratacion](
	[IdContratacion] [int] IDENTITY(1,1) NOT NULL,
	[DescripcionContratacion] [varchar](100) NULL,
 CONSTRAINT [PK_TiposContratacion] PRIMARY KEY CLUSTERED 
(
	[IdContratacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Transaccion]    Script Date: 03/11/2017 18:11:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transaccion](
	[idTransaccion] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [datetime] NULL,
	[usrVendedor] [varchar](50) NULL,
	[usrComprador] [varchar](50) NULL,
	[idProducto] [int] NULL,
	[monto] [decimal](18, 0) NULL,
	[recibida] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idTransaccion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 03/11/2017 18:11:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[idUsuario] [int] IDENTITY(1,1) NOT NULL,
	[nomUsuario] [varchar](50) NOT NULL,
	[nombre] [varchar](100) NULL,
	[apellido] [varchar](100) NULL,
	[dni] [varchar](12) NULL,
	[domicilio] [varchar](100) NULL,
	[mail] [varchar](100) NULL,
	[contrasena] [varchar](40) NULL,
	[fechaUpdatePass] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[nomUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Calificacion]  WITH CHECK ADD FOREIGN KEY([idTransaccion])
REFERENCES [dbo].[Transaccion] ([idTransaccion])
GO
ALTER TABLE [dbo].[CtaCorriente]  WITH CHECK ADD FOREIGN KEY([titular])
REFERENCES [dbo].[Usuario] ([nomUsuario])
GO
ALTER TABLE [dbo].[Subasta]  WITH CHECK ADD FOREIGN KEY([idOperacion])
REFERENCES [dbo].[Operacion] ([idOperacion])
GO
ALTER TABLE [dbo].[Transaccion]  WITH CHECK ADD FOREIGN KEY([idProducto])
REFERENCES [dbo].[Operacion] ([idOperacion])
GO
ALTER TABLE [dbo].[Transaccion]  WITH CHECK ADD FOREIGN KEY([usrComprador])
REFERENCES [dbo].[Usuario] ([nomUsuario])
GO
ALTER TABLE [dbo].[Transaccion]  WITH CHECK ADD FOREIGN KEY([usrVendedor])
REFERENCES [dbo].[Usuario] ([nomUsuario])
GO
ALTER TABLE [dbo].[Calificacion]  WITH CHECK ADD CHECK  (([valor]<(0) AND [valor]>(11)))
GO
