package com.examen.trupper.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos_w")
public class Pedidos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PEDIDO")
	private int idPedido;

	@Column(name = "TOTAL")
	private double total;

	@Column(name = "DATE_SALE")
	private String dateSale;
	
    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
    private List<PedidosDetalle> pedidos;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDateSale() {
		return dateSale;
	}

	public void setDateSale(String dateSale) {
		this.dateSale = dateSale;
	}

	public List<PedidosDetalle> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidosDetalle> pedidos) {
		this.pedidos = pedidos;
	}
    
    
}
