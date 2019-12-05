package com.adanyc.jasper.model;

public class DocumentoDetalle {
	private String codigoItem;
	private String descripcionItem;
	private double precioUnitario;
	private int cantidad;
	private double descuento;

	public DocumentoDetalle() {
	}

	public DocumentoDetalle(String codigoItem, String descripcionItem, double precioUnitario, int cantidad,
			double descuento) {
		super();
		this.codigoItem = codigoItem;
		this.descripcionItem = descripcionItem;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.descuento = descuento;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getDescripcionItem() {
		return descripcionItem;
	}

	public void setDescripcionItem(String descripcionItem) {
		this.descripcionItem = descripcionItem;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

}
