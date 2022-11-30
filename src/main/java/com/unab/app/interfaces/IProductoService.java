package com.unab.app.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.unab.app.models.Producto;

public interface IProductoService {
	public Producto findByNombre(String nombre);
	
	public Producto findProductoById(Long id);
	
	public void save(Producto producto);
	
	public Page<Producto> findAll(Pageable pageable);
}
