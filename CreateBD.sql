CREATE TABLE dbo.Usuario
(
	idUsuario INT IDENTITY(1,1),
	nomUsuario VARCHAR(50) PRIMARY KEY,
	nombre VARCHAR(100),
	domicilio VARCHAR (100),
	mail VARCHAR(100),
	contraseña VARCHAR(40),
	fechaUpdatePass DATETIME,
	isSubasta BIT
)
GO


CREATE TABLE dbo.CtaCorriente
(
	numCuenta INT PRIMARY KEY,
	titular VARCHAR(50) FOREIGN KEY REFERENCES Usuario(nomUsuario),
	saldo DECIMAL 
)
GO

CREATE TABLE dbo.Operacion
(
	idOperacion INT IDENTITY(1,1)PRIMARY KEY,
	titulo VARCHAR(100),
	descripcion TEXT,
	fechaDesde DATETIME,
	fechaHasta DATETIME,
	efectivo BIT,
	tarjeta BIT,
	trasferecia BIT
)
GO

CREATE TABLE dbo.Servicio
(
	idOperacion INT PRIMARY KEY FOREIGN KEY REFERENCES Operacion(idOperacion),
	precio DECIMAL,
	contratacionAbono BIT,
	acreditProfesional VARCHAR(100)
)
GO

CREATE TABLE dbo.Producto
(
	idOperacion INT PRIMARY KEY FOREIGN KEY REFERENCES Operacion(idOperacion),
	precio DECIMAL,
	fechaGarantia DATETIME,
	cantMesesGtia INT
)
GO

CREATE TABLE dbo.Subasta
(
	idOperacion INT PRIMARY KEY FOREIGN KEY REFERENCES Operacion(idOperacion),
	precioMinimo DECIMAL,
	diasVigencia INT,
	precioIni DECIMAL
)
GO

CREATE TABLE dbo.Transaccion
(
	idTransaccion INT IDENTITY(1,1)PRIMARY KEY,
	fecha DATETIME,
	usrVendedor VARCHAR(50) FOREIGN KEY REFERENCES Usuario(nomUsuario),
	usrComprador VARCHAR(50) FOREIGN KEY REFERENCES Usuario(nomUsuario),
	idProducto INT FOREIGN KEY REFERENCES Operacion(idOperacion),
	monto DECIMAL,
	recibida BIT
)
GO

CREATE TABLE dbo.Calificacion
(
	idCalificacion INT IDENTITY(1,1),
	fecha DATETIME,
	idTransaccion INT FOREIGN KEY REFERENCES Transaccion(idTransaccion),
	valor INT CHECK (valor <0 AND valor >11),
	obs TEXT
)
GO
