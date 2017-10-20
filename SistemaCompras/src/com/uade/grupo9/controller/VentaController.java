package com.uade.grupo9.controller;

import java.util.ArrayList;
import java.util.List;

import com.uade.grupo9.model.Banco;
import com.uade.grupo9.model.MercadoPago;
import com.uade.grupo9.model.Observer;
import com.uade.grupo9.model.Tarjeta;
import com.uade.grupo9.model.Transferencia;

public class VentaController implements Observer{
	private List<Banco> bancos;
	private MercadoPago mercadoPago;
	
	private VentaController instancia;
	
	private VentaController() {
		bancos = new ArrayList<>();
		mercadoPago = new MercadoPago();
		getBancos();
	}
	
	private void getBancos() {
		bancos.add(new Banco("Itau"));
		bancos.add(new Banco("Galicia"));
		bancos.stream().forEach(b -> b.agregar(this));
	}
	
	public VentaController get() {
		if(instancia==null) {
			instancia = new VentaController();
		}
		return instancia;
	}
	
	public void iniciarTransferencia(Transferencia venta) {
		bancos.stream().forEach(b -> {
			b.iniciarTransaccion(venta.getComprador(), venta.getVendedor(), venta.getMontoVenta());
		});
	}
	
	public void iniciarTransferencia(Tarjeta venta) {
		mercadoPago.iniciarTransaccion(venta.getComprador(), venta.getVendedor(), venta.getMontoVenta());
	}
	
	public void confirmarTransferencia() {
		//TODO: implementar esto
		System.out.println("Te confirmo la venta... implementar");
	}

	@Override
	public void notificar() {
		confirmarTransferencia();
	}
	
	
}
