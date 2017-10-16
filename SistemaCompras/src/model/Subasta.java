package model;

import java.util.List;

public class Subasta extends Operacion {

	private int diasVigencia;
	private float precioInicial;
	private float precioActual;
	private float precioMin;
	private Usuario mayorOfertador;
	private List<Usuario> usuariosInteresados;
	
	@Override
	public void recibirOferta(float monto, Usuario ofertante) {
		// TODO Auto-generated method stub
	}
	
	public void agregarInteresado (Usuario usuario){
		if(!estaRepetido(usuario)){
			this.usuariosInteresados.add(usuario);
		}
	}
	
	private boolean estaRepetido(Usuario usuario){
		boolean estaRepe = false;
		for(Usuario u: usuariosInteresados){
			if(u.sosElUsuario(usuario)){
				estaRepe = true;
			}
		}
		return estaRepe;
	}
	
	public int getDiasVigencia() {
		return diasVigencia;
	}

	public void setDiasVigencia(int diasVigencia) {
		this.diasVigencia = diasVigencia;
	}

	public float getPrecioInicial() {
		return precioInicial;
	}

	public void setPrecioInicial(float precioInicial) {
		this.precioInicial = precioInicial;
	}

	public float getPrecioActual() {
		return precioActual;
	}

	public void setPrecioActual(float precioActual) {
		this.precioActual = precioActual;
	}

	public float getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(float precioMin) {
		this.precioMin = precioMin;
	}

	public Usuario getMayorOfertador() {
		return mayorOfertador;
	}

	public void setMayorOfertador(Usuario mayorOfertador) {
		this.mayorOfertador = mayorOfertador;
	}

	public List<Usuario> getUsuariosInteresados() {
		return usuariosInteresados;
	}

	public void setUsuariosInteresados(List<Usuario> usuariosInteresados) {
		this.usuariosInteresados = usuariosInteresados;
	}

}
