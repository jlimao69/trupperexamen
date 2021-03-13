package com.examen.trupper.repository;

import org.springframework.data.repository.Repository;

import com.examen.trupper.models.PedidosDetalle;

public interface IDetalleRepository extends Repository<PedidosDetalle, Integer> {
	
	PedidosDetalle save(PedidosDetalle pedidos);

}
