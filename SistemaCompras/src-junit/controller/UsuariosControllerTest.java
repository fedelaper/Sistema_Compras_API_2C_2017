package controller;

import org.junit.Assert;
import org.junit.Test;

import com.uade.grupo9.controller.UsuariosController;
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
}
