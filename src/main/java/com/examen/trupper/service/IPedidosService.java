package com.examen.trupper.service;

import java.util.ArrayList;
import java.util.List;

import com.examen.trupper.models.Pedidos;
import com.examen.trupper.models.PedidosDetalle;

public interface IPedidosService {

	public List<Pedidos> enlista();
	public Pedidos guardar (Pedidos pedidos);
}
