package com.examen.trupper.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.examen.trupper.models.Pedidos;
import com.examen.trupper.models.PedidosDetalle;
import com.examen.trupper.repository.IDetalleRepository;
import com.examen.trupper.repository.IPedidosRepository;

@Service
public class PedidosServiceImpl implements IPedidosService{

	@Autowired
	private IPedidosRepository iPedidosRepository;
	
	@Autowired
	IDetalleRepository iDetalleRepository;
	
    @PersistenceContext
    private EntityManager entityManager;
	
	public List<Pedidos> enlista(){
		List<Pedidos> lista = new  ArrayList<>();
		List<Pedidos> listaMod = new  ArrayList<>();
		 PedidosDetalle pedidosDetalle = new PedidosDetalle();
		 List<PedidosDetalle> pedidosDetalles = new  ArrayList<>();
		
		lista = iPedidosRepository.findAll();

		 
		 for (int j = 0; j < lista.size(); j++) {
			 
			 Pedidos pedidos = new Pedidos();
			 pedidos.setIdPedido(lista.get(j).getIdPedido());
			 pedidos.setDateSale(lista.get(j).getDateSale());
			 pedidos.setTotal(lista.get(j).getTotal());
			 pedidosDetalles = new  ArrayList<>();
			 for (int i = 0; i < lista.get(j).getPedidos().size(); i++) {
				 pedidosDetalle = new PedidosDetalle();
				 
				 pedidosDetalle.setId(lista.get(j).getPedidos().get(i).getId());
				 pedidosDetalle.setAmount(lista.get(j).getPedidos().get(i).getAmount());
				 pedidosDetalle.setSku(lista.get(j).getPedidos().get(i).getSku());
				 pedidosDetalle.setPrice(lista.get(j).getPedidos().get(i).getPrice());
				 
				 pedidosDetalles.add(pedidosDetalle);
			  }
			
			 pedidos.setPedidos(pedidosDetalles);
			 listaMod.add(pedidos);
		}
		 
		 return listaMod;
	}
	
	public Pedidos guardar (Pedidos pedidos) {
		
		Pedidos pedidoNew = new Pedidos();
		 PedidosDetalle pedidosDetalle = new PedidosDetalle();
		pedidoNew.setIdPedido(pedidos.getIdPedido());
		pedidoNew.setTotal(pedidos.getTotal());
		pedidoNew.setDateSale(pedidos.getDateSale());
		Pedidos pedido = iPedidosRepository.save(pedidoNew);
		
		 pedidosDetalle.setId(pedidos.getPedidos().get(0).getId());
		 pedidosDetalle.setAmount(pedidos.getPedidos().get(0).getAmount());
		 pedidosDetalle.setSku(pedidos.getPedidos().get(0).getSku());
		 pedidosDetalle.setPrice(pedidos.getPedidos().get(0).getPrice());
		 pedidosDetalle.setPedidos(pedido);
		 
		 iDetalleRepository.save(pedidosDetalle);
		return pedido;
		
	}
	
	
	@Modifying
    @Transactional
	public void insertWithQuery(PedidosDetalle detalles, int idPedido) {
	    entityManager.createNativeQuery("INSERT INTO pedidos_detalle_w (ID, ID_PEDIDO, SKU,AMOUT,PRICE) VALUES (?,?,?,?,?)")
	      .setParameter(1, detalles.getId())
	      .setParameter(2, idPedido)
	      .setParameter(3, detalles.getSku().toString())
	      .setParameter(4, detalles.getAmount())
	      .setParameter(5, detalles.getPrice())
	      .executeUpdate();
	}

}
