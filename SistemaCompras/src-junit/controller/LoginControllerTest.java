package controller;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.uade.grupo9.controller.LoginController;
import com.uade.grupo9.controller.UsuariosController;
import com.uade.grupo9.model.Contrasenia;

public class LoginControllerTest {

	@Test
	public void testContraseniaNOK() {
		LoginController loginController = new LoginController();
		Assert.assertFalse(loginController.validarFormatoContraseniaUsuario("claveinvalida"));
	}
	
	@Test
	public void testContraseniaOK() {
		LoginController loginController = new LoginController();
		Assert.assertTrue(loginController.validarFormatoContraseniaUsuario("claveVALIDA1"));
	}

	@Test
	public void testContraseniaCorta() {
		LoginController loginController = new LoginController();
		Assert.assertFalse(loginController.validarFormatoContraseniaUsuario("clavE1"));
	}

	@Test
	public void testContraseniaLarga() {
		LoginController loginController = new LoginController();
		Assert.assertFalse(loginController.validarFormatoContraseniaUsuario("clavE12345654756649849849849849849848"));
	}

	@Test
	public void testContraseniaVencida(){
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 10, 20);
		LoginController loginController = new LoginController();
		Assert.assertFalse(loginController.validarExpiracionContraseniaUsuario(new Contrasenia("1234aAaa", cal.getTime())));
	}
	
	@Test
	public void testContraseniaNoVencida(){
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 5, 20);
		LoginController loginController = new LoginController();
		Assert.assertTrue(loginController.validarExpiracionContraseniaUsuario(new Contrasenia("1234aAaa", cal.getTime())));
	}

}
