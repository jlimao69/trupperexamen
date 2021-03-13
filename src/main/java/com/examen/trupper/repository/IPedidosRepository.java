package com.examen.trupper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.examen.trupper.models.Pedidos;
import com.examen.trupper.models.PedidosDetalle;

public interface IPedidosRepository extends Repository<Pedidos, Integer> {

	List<Pedidos> findAll();
	Pedidos save(Pedidos pedidos);
}
