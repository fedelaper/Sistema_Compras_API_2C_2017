package controller;

import java.util.List;

import model.Usuario;

public class UsuariosController {

	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void altaUsuario(Usuario usuario) throws Exception{
		for(Usuario item : this.usuarios)
		{
			if(item.sosElUsuario(usuario)){
				throw new Exception("Usuario ya existente.");
			}
		}
		this.usuarios.add(usuario);
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



}
