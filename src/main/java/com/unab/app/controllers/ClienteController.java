package com.unab.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unab.app.interfaces.IClienteService;
import com.unab.app.models.Cliente;

@CrossOrigin(origins = "")
@RestController
@SessionAttributes("cliente")
@RequestMapping(value="/cliente")
public class ClienteController {
	@Autowired
	private IClienteService clienteService;
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/listar")
	public List<Cliente> getClientes(){
		return clienteService.findAll();
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/listarPageable")
	public Page<Cliente> findAll(){
		Pageable pageable=Pageable.ofSize(10);
		return clienteService.findAll(pageable);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/save")
	public Cliente save(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
		return cliente;
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/getCliente/{id}")
	public Cliente findOne(@PathVariable("id") Long id) {
		return clienteService.findOne(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable("id") Long id){
		return clienteService.delete(id);
	}
}
