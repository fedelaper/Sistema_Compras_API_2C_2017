package model;

public class CtaCorriente {

	private String cbu;
	private Usuario titular;
	private float saldo;
	
	public String getCbu() {
		return cbu;
	}
	public void setCbu(String cbu) {
		this.cbu = cbu;
	}
	public Usuario getTitular() {
		return titular;
	}
	public void setTitular(Usuario titular) {
		this.titular = titular;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public CtaCorriente(String cbu, Usuario titular, float saldo) {
		super();
		this.cbu = cbu;
		this.titular = titular;
		this.saldo = saldo;
	}
	public CtaCorriente() {
		super();
	}
	
	
}
