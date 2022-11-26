package com.unab.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.unab.app.models.Factura;

public interface FacturaDao extends CrudRepository<Factura, Integer> {

}
