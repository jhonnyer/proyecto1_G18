package com.unab.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.app.dao.IDetalleFacturaDAO;
import com.unab.app.interfaces.IDetalleFacturaService;
import com.unab.app.models.DetalleFactura;

@Service
public class DetalleServiceImpl implements IDetalleFacturaService{

	@Autowired
	private IDetalleFacturaDAO detalleFacturaDao;
	
	@Override
	public void save(DetalleFactura detalleFactura) {
		detalleFacturaDao.save(detalleFactura);
	}

	@Override
	public List<DetalleFactura> findDetalleFacturaByIdFacturaByIdProducto(Long id_factura, Long id_producto) {
		return detalleFacturaDao.findDetalleFacturaByIdFacturaByIdProducto(id_factura, id_producto);
	}

}