package controller;


import org.junit.Assert;
import org.junit.Test;

import com.uade.grupo9.controller.PublicacionController;
import com.uade.grupo9.model.Garantia;
import com.uade.grupo9.model.ItemProducto;
import com.uade.grupo9.model.Producto;

public class PublicacionControllerTest {

	@Test
	public void altaProductosRepetidos() {
		PublicacionController uController = new PublicacionController();
		ItemProducto iProd = new ItemProducto(222,"PS4");
		Garantia gtia = new Garantia();
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
		Garantia gtia = new Garantia();
		Producto producto = new Producto(iProd,gtia);
		uController.altaProducto(producto);
		Assert.assertTrue(uController.getProductos().size() == 1);
		ItemProducto iProd2 = new ItemProducto(222,"PS3");
		Garantia gtia2 = new Garantia();
		Producto producto2 = new Producto(iProd2,gtia2);
		uController.altaProducto(producto2);
		Assert.assertTrue(uController.getProductos().size() == 2);
	}
	
	@Test
	public void bajaProductos(){
		PublicacionController uController = new PublicacionController();
		ItemProducto iProd = new ItemProducto(222,"PS4");
		Garantia gtia = new Garantia();
		Producto producto = new Producto(iProd,gtia);
		uController.altaProducto(producto);
		Assert.assertTrue(uController.getProductos().size() == 1);
		ItemProducto iProd2 = new ItemProducto(222,"PS3");
		Garantia gtia2 = new Garantia();
		Producto producto2 = new Producto(iProd2,gtia2);
		uController.altaProducto(producto2);
		Assert.assertTrue(uController.getProductos().size() == 2);
		uController.bajaProducto(producto);
		Assert.assertTrue(uController.getProductos().size() == 1);
		uController.bajaProducto(producto2);
		Assert.assertTrue(uController.getProductos().size() == 0);
	}
	
	
	
}
