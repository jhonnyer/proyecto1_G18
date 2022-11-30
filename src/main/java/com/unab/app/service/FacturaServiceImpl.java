package com.unab.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.app.dao.FacturaDAO;
import com.unab.app.interfaces.IDetalleFacturaService;
import com.unab.app.interfaces.IFacturaService;
import com.unab.app.interfaces.IProductoService;
import com.unab.app.models.DetalleFactura;
import com.unab.app.models.Factura;
import com.unab.app.models.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private FacturaDAO facturaDao;
	
	@Autowired
	private IProductoService productoDao;
	
	@Autowired
	private IDetalleFacturaService detalleFacturaService;
	
	@Override
	public void save(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	public Factura findFacturById(Long id) {
		return facturaDao.findById(id).orElse(new Factura());
	}

	@Override
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id);
	}

	@Override
	public List<Factura> fetchFacturaByIDCliente(Long id) {
		return facturaDao.fetchFacturaByIDCliente(id);
	}

	@Override
	public void updateFactura(String nombreProducto, Long id_factura) {
		Producto producto=productoDao.findByNombre(nombreProducto);
		
		List<DetalleFactura> listDetalleFactura=detalleFacturaService.findDetalleFacturaByIdFacturaByIdProducto(id_factura, producto.getId());
		
		Factura factura=this.findFacturById(id_factura);
		
		factura.setValorTotal(2_500_000L);
		facturaDao.save(factura);
		
		//Utilizacion Bucle For
		
		for(int x=0; x<listDetalleFactura.size();x++) {
			System.out.println("Lista con for tradicional: "+listDetalleFactura.get(x));
		}
		
		listDetalleFactura.forEach(t->{
			System.out.println("Lista con funcion flecha: "+t);
		});
		
	}

}
