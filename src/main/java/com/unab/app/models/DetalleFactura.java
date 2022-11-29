package com.unab.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalleFactura")
public class DetalleFactura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detalle_factura")
	private Long id;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@ManyToOne()
	@JoinColumn(name="factura_id_factura", referencedColumnName="id_factura")
	private Factura factura;
	
	@ManyToOne()
	@JoinColumn(name="producto_id_producto", referencedColumnName="id_producto")
	private Producto producto;

	public DetalleFactura() {
	}

	public DetalleFactura(Long id, Integer cantidad) {
		this.id = id;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}