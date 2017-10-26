package controller;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.uade.grupo9.controller.UsuariosController;
import com.uade.grupo9.model.Contrasenia;
import com.uade.grupo9.model.GtiaExtendida;
import com.uade.grupo9.model.ItemProducto;
import com.uade.grupo9.model.Producto;

public class UsuariosControllerTest {

	@Test
	public void altaProductosRepetidos() {
		UsuariosController uController = new UsuariosController();
		ItemProducto iProd = new ItemProducto(222,"PS4");
		GtiaExtendida gtia = new GtiaExtendida();
		Producto producto = new Producto(iProd,gtia);
		uController.altaProducto(producto);
		Assert.assertTrue(uController.getProductos().size() == 1);
		uController.altaProducto(producto);
		uController.altaProducto(producto);
		Assert.assertTrue(uController.getProductos().size() == 1);
	}

	@Test
	public void altaProductosDiferentes() {
		UsuariosController uController = new UsuariosController();
		ItemProducto iProd = new ItemProducto(222,"PS4");
		GtiaExtendida gtia = new GtiaExtendida();
		Producto producto = new Producto(iProd,gtia);
		uController.altaProducto(producto);
		Assert.assertTrue(uController.getProductos().size() == 1);
		ItemProducto iProd2 = new ItemProducto(222,"PS3");
		GtiaExtendida gtia2 = new GtiaExtendida();
		Producto producto2 = new Producto(iProd2,gtia2);
		uController.altaProducto(producto2);
		Assert.assertTrue(uController.getProductos().size() == 2);
	}
	
	@Test
	public void bajaProductos(){
		UsuariosController uController = new UsuariosController();
		ItemProducto iProd = new ItemProducto(222,"PS4");
		GtiaExtendida gtia = new GtiaExtendida();
		Producto producto = new Producto(iProd,gtia);
		uController.altaProducto(producto);
		Assert.assertTrue(uController.getProductos().size() == 1);
		ItemProducto iProd2 = new ItemProducto(222,"PS3");
		GtiaExtendida gtia2 = new GtiaExtendida();
		Producto producto2 = new Producto(iProd2,gtia2);
		uController.altaProducto(producto2);
		Assert.assertTrue(uController.getProductos().size() == 2);
		uController.bajaProducto(producto);
		Assert.assertTrue(uController.getProductos().size() == 1);
		uController.bajaProducto(producto2);
		Assert.assertTrue(uController.getProductos().size() == 0);
	}
	
	@Test
	public void testContraseniaNOK() {
		UsuariosController uController = new UsuariosController();
		Assert.assertFalse(uController.validarFormatoContraseniaUsuario("claveinvalida"));
	}
	
	@Test
	public void testContraseniaOK() {
		UsuariosController uController = new UsuariosController();
		Assert.assertTrue(uController.validarFormatoContraseniaUsuario("claveVALIDA1"));
	}

	@Test
	public void testContraseniaCorta() {
		UsuariosController uController = new UsuariosController();
		Assert.assertFalse(uController.validarFormatoContraseniaUsuario("clavE1"));
	}

	@Test
	public void testContraseniaLarga() {
		UsuariosController uController = new UsuariosController();
		Assert.assertFalse(uController.validarFormatoContraseniaUsuario("clavE12345654756649849849849849849848"));
	}

	@Test
	public void testContraseniaVencida(){
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 10, 20);
		UsuariosController uController = new UsuariosController();
		Assert.assertFalse(uController.validarExpiracionContraseniaUsuario(new Contrasenia("1234aAaa", cal.getTime())));
	}
	
	@Test
	public void testContraseniaNoVencida(){
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 5, 20);
		Date date = cal.getTime();
		UsuariosController uController = new UsuariosController();
		Assert.assertTrue(uController.validarExpiracionContraseniaUsuario(new Contrasenia("1234aAaa", cal.getTime())));
	}
	
}
