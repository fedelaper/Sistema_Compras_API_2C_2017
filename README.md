"# Sistema_Compras_API_2C_2017" 

INSERT INTO API.dbo.Operacion (idOperacion,titulo,descripcion,fechaDesde,fechaHasta,efectivo,tarjeta,trasferecia) VALUES (
1,'Instalacion a/c','Instalador de aire acondicionado en CABA y Gran Buenos aires',{ts '2017-10-28 12:12:02.000000'},{ts '2017-12-28 12:12:02.000000'},1,1,1);
INSERT INTO API.dbo.Operacion (idOperacion,titulo,descripcion,fechaDesde,fechaHasta,efectivo,tarjeta,trasferecia) VALUES (
2,'Pote de helado','Pote de helado antiguo para coleccion',{ts '2017-10-28 12:13:52.000000'},{ts '2017-11-28 12:13:52.000000'},1,1,1);


INSERT INTO API.dbo.Producto (idOperacion,precio,fechaGarantia,cantMesesGtia) VALUES (
2,250,NULL,NULL);


INSERT INTO API.dbo.Servicio (idOperacion,precio,contratacionAbono,acreditProfesional) VALUES (
1,500,0,'Instalador matriculado');

