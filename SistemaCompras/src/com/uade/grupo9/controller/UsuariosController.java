package com.uade.grupo9.controller;

import java.util.ArrayList;
import java.util.List;

import com.uade.grupo9.model.Usuario;
import com.uade.grupo9.persistencia.UsuarioDao;

public class UsuariosController {
	private static UsuarioDao dao;
	private static List<Usuario> usuarios;
	private static Usuario currentUser;
	private static UsuariosController instance;

	private UsuariosController(){
		UsuariosController.usuarios = new ArrayList<Usuario>();
		dao = new UsuarioDao();
	}

	public static UsuariosController get(){
		if(instance ==null){
			instance = new UsuariosController();
		}
		return instance;
	}
	
	public List<Usuario> getUsuarios() {
		if(usuarios == null || usuarios.size() == 0){
			usuarios = dao.getTodos();
		}
		return usuarios;
	}
	
	public Usuario getUsuario(String nomUsuario) {
		try{
		return dao.getByNomUsuario(nomUsuario);
		}catch(Exception e){
			return null;
		}
	}
	
	public void altaUsuario(Usuario usuario) throws Exception{
		
		if(!this.usuarios.contains(usuario))
		{
			this.usuarios.add(usuario);
		}else
		{
			throw new Exception("Usuario ya existente.");
		}
		
	}
	
	public void bajaUsuario(Usuario usuario)
	{
		for(Usuario item : this.usuarios)
		{
			if(item.sosElUsuario(usuario)){
				this.usuarios.remove(item);
				break;
			}
		}
	}

	public void modificarUsuario(Usuario usuario)
	{
		for(Usuario item : this.usuarios)
		{
			if(item.sosElUsuario(usuario)){
				item.setDomicilio(usuario.getDomicilio());
				item.setMail(usuario.getMail());
				break;
			}
		}
	}
	
	public void aumentarSaldoCuentaCorrienteDeUsuario(Usuario usuario, float monto){
		float saldoModificado = usuario.getCtaCorriente().getSaldo() + monto;
		usuario.getCtaCorriente().setSaldo(saldoModificado);
	}
	
	public void disminuirSaldoCuentaCorrienteDeUsuario(Usuario usuario, float monto){
		float saldoModificado = usuario.getCtaCorriente().getSaldo() - monto;
		usuario.getCtaCorriente().setSaldo(saldoModificado);
	}
	

	public boolean existeUsuario(String nombreUsuario) {
		currentUser = getUsuario(nombreUsuario);
		
		return currentUser != null;
	}

	public Usuario getCurrentUser() {
		return currentUser;
	}
	
	
	

}
