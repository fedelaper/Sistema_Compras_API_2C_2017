"# Sistema_Compras_API_2C_2017" 


CREATE TABLE dbo.Usuario
(
	idUsuario INT IDENTITY(1,1),
	nomUsuario VARCHAR(50) PRIMARY KEY,
	nombre VARCHAR(100),
	apellido VARCHAR(100),
	dni VARCHAR(100),
	domicilio VARCHAR (100),
	mail VARCHAR(100),
	contrasena VARCHAR(40),
	fechaUpdatePass DATETIME,
	isSubasta BIT
)



CREATE TABLE dbo.CtaCorriente
(
	numCuenta INT PRIMARY KEY,
	titular VARCHAR(50) FOREIGN KEY REFERENCES Usuario(nomUsuario),
	saldo DECIMAL 
)


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

CREATE TABLE dbo.Servicio
(
	idOperacion INT PRIMARY KEY FOREIGN KEY REFERENCES Operacion(idOperacion),
	precio DECIMAL,
	contratacionAbono BIT,
	acreditProfesional VARCHAR(100)
)


CREATE TABLE dbo.Producto
(
	idOperacion INT PRIMARY KEY FOREIGN KEY REFERENCES Operacion(idOperacion),
	precio DECIMAL,
	fechaGarantia DATETIME,
	cantMesesGtia INT
)

CREATE TABLE dbo.Subasta
(
	idOperacion INT PRIMARY KEY FOREIGN KEY REFERENCES Operacion(idOperacion),
	precioMinimo DECIMAL,
	diasVigencia INT,
	precioIni DECIMAL
)


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


CREATE TABLE dbo.Calificacion
(
	idCalificacion INT IDENTITY(1,1),
	fecha DATETIME,
	idTransaccion INT FOREIGN KEY REFERENCES Transaccion(idTransaccion),
	valor INT CHECK (valor <0 AND valor >11),
	obs TEXT
)




INSERT INTO API.dbo.Operacion (idOperacion,titulo,descripcion,fechaDesde,fechaHasta,efectivo,tarjeta,trasferecia) VALUES (
1,'Instalacion a/c','Instalador de aire acondicionado en CABA y Gran Buenos aires',{ts '2017-10-28 12:12:02.000000'},{ts '2017-12-28 12:12:02.000000'},1,1,1);
INSERT INTO API.dbo.Operacion (idOperacion,titulo,descripcion,fechaDesde,fechaHasta,efectivo,tarjeta,trasferecia) VALUES (
2,'Pote de helado','Pote de helado antiguo para coleccion',{ts '2017-10-28 12:13:52.000000'},{ts '2017-11-28 12:13:52.000000'},1,1,1);


INSERT INTO API.dbo.Producto (idOperacion,precio,fechaGarantia,cantMesesGtia) VALUES (
2,250,NULL,NULL);


INSERT INTO API.dbo.Servicio (idOperacion,precio,contratacionAbono,acreditProfesional) VALUES (
1,500,0,'Instalador matriculado');


INSERT INTO API.dbo.Usuario (idUsuario,nomUsuario,nombre,domicilio,mail,contraseña,fechaUpdatePass,isSubasta,apellido,dni) VALUES (
1,'pepe','Jose','av siempre viva 266','pepe@gmail.com','Josele1',{ts '2017-10-28 21:58:45.023000'},0,'Perez','12432879');

