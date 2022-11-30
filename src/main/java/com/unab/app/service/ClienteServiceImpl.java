package com.unab.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.unab.app.dao.IClienteDAO;
import com.unab.app.interfaces.IClienteService;
import com.unab.app.models.Cliente;
@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteDAO clienteDao;

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(new Cliente());
	}

	@Override
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

}
