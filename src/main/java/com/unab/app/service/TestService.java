package com.unab.app.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	public String getPrueba() {
		System.out.println("Prueba Servicio");
		return "Test Service";
	}
}
