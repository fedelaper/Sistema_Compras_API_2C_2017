package com.uade.grupo9.model;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	private List<Observer> observers = new ArrayList<>();

	public void notificar() {
		for (Observer observer : observers) {
			observer.notificar();
		}
	}

	public void agregar(Observer observer) {
		observers.add(observer);
	};
}
