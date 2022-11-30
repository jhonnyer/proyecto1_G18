package com.unab.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.unab.app.dao.IProductoDAO;
import com.unab.app.interfaces.IProductoService;
import com.unab.app.models.Producto;
@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProductoDAO productoDao;
	
	@Override
	public Producto findByNombre(String nombre) {
		return productoDao.findByNombre(nombre);
	}

	@Override
	public Producto findProductoById(Long id) {
		return productoDao.findById(id).orElse(new Producto());
	}

	@Override
	public void save(Producto producto) {
		productoDao.save(producto);
	}

	@Override
	public Page<Producto> findAll(Pageable pageable) {
		return productoDao.findAll(pageable);
	}

}
