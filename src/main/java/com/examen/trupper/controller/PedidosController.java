package com.examen.trupper.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.trupper.models.PedidoDetallesBean;
import com.examen.trupper.models.Pedidos;
import com.examen.trupper.models.PedidosDetalle;
import com.examen.trupper.service.IPedidosService;

@RestController
@RequestMapping("/api/trupper")
public class PedidosController {

	@Autowired
	private IPedidosService iPedidosService;

	@GetMapping("/pedidos")
	public List<Pedidos> findAll() {
		return iPedidosService.enlista();
	}

	@PostMapping("/pedidos")
	public Pedidos addUser(@RequestBody Map<String, Object> pedidos) {
		Pedidos pedidosObjeto = new Pedidos();
		PedidosDetalle pedidosDetalle = new PedidosDetalle();
		List<PedidosDetalle> pedidosDetalles = new  ArrayList<>();
		
		pedidosObjeto.setIdPedido((int) pedidos.get("id"));
		pedidosObjeto.setDateSale(pedidos.get("dateSale").toString());
		pedidosObjeto.setTotal((double) pedidos.get("total"));
		pedidosDetalle.setId((int) pedidos.get("id_deta"));
		pedidosDetalle.setAmount((double) pedidos.get("amount"));
		pedidosDetalle.setPrice((double) pedidos.get("price"));
		pedidosDetalle.setSku(pedidos.get("sku").toString());
		pedidosDetalles.add(pedidosDetalle);
		pedidosObjeto.setPedidos(pedidosDetalles);
		
		return 	iPedidosService.guardar(pedidosObjeto);

	}
	
	
}
