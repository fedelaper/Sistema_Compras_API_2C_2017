package controller;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.uade.grupo9.controller.PublicacionController;
import com.uade.grupo9.model.GtiaExtendida;
import com.uade.grupo9.model.ItemProducto;
import com.uade.grupo9.model.Producto;

public class PublicacionControllerTest {

	@Test
	public void altaProductosRepetidos() {
		PublicacionController uController = new PublicacionController();
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
		PublicacionController uController = new PublicacionController();
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
		PublicacionController uController = new PublicacionController();
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
