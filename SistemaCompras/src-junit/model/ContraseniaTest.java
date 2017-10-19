package model;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.uade.grupo9.model.Contrasenia;

public class ContraseniaTest {

private static final String MENSAJE_ERROR_CLAVE_INVALIDA = "Clave inv�lida";
	
	@Test
	public void testContraseniaNOK() {
		Boolean tiroException = false;
		String eMessage = "";
		
		try{
			Contrasenia contrasenia = new Contrasenia("1234aA",new Date());
			contrasenia.setClave("claveinvalida");
		}catch(Exception e)
		{
			tiroException = true;
			eMessage = e.getMessage();
		}
		Assert.assertTrue(tiroException);
		Assert.assertTrue(eMessage == MENSAJE_ERROR_CLAVE_INVALIDA);
	}
	
	@Test
	public void testContraseniaOK() {
		Boolean tiroException = false;
		
		try{
			Contrasenia contrasenia = new Contrasenia("1234aA",new Date());
			contrasenia.setClave("claveVALIDA1");
		}catch(Exception e)
		{
			tiroException = true;
		}
		Assert.assertTrue(!tiroException);
	}

	@Test
	public void testContraseniaCorta() {
		Boolean tiroException = false;
		String eMessage = "";
		
		try{
			Contrasenia contrasenia = new Contrasenia("1234aA",new Date());
			contrasenia.setClave("clavE1");
		}catch(Exception e)
		{
			tiroException = true;
			eMessage = e.getMessage();
		}
		Assert.assertTrue(tiroException);
		Assert.assertTrue(eMessage == MENSAJE_ERROR_CLAVE_INVALIDA);
	}

	@Test
	public void testContraseniaLarga() {
		Boolean tiroException = false;
		String eMessage = "";
		
		try{
			Contrasenia contrasenia = new Contrasenia("1234aA",new Date());
			contrasenia.setClave("clavE12345654756649849849849849849848");
		}catch(Exception e)
		{
			tiroException = true;
			eMessage = e.getMessage();
		}
		
		Assert.assertTrue(tiroException);
		Assert.assertTrue(eMessage == MENSAJE_ERROR_CLAVE_INVALIDA);
	}

	@Test
	public void testContraseniaVencida(){
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 10, 20);
		Date date = cal.getTime();
		Contrasenia contrasenia = new Contrasenia("1234aA", date);
		
		Assert.assertTrue(contrasenia.estaVencida());
	}
	
	@Test
	public void testContraseniaNoVencida(){
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 5, 20);
		Date date = cal.getTime();
		Contrasenia contrasenia = new Contrasenia("1234aA", date);
		
		Assert.assertFalse(contrasenia.estaVencida());
	}
}
