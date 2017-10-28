package com.uade.grupo9.controller;

import java.util.Date;

import com.uade.grupo9.model.Contrasenia;

public class LoginController {
	public LoginController(){
		super();
	}
	
	public boolean validarFormatoContraseniaUsuario(String clave){
		return clave.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{8,20}$");
	}
	
	/*
	 * True si no esta expirada. Caso contrario, false.
	 * */
	public boolean validarExpiracionContraseniaUsuario(Contrasenia contrasenia){
		long diff = (new Date().getTime() - contrasenia.getFechaCreacion().getTime()) / (1000 * 60 * 60 * 24);
		return diff < 180;
	}

}
