package com.unab.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.app.interfaces.IClienteService;
import com.unab.app.models.Cliente;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public List<Cliente> getClientes(){
		return clienteService.findAll();
	}
}
