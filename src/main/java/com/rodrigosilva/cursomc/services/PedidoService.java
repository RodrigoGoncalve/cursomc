 package com.rodrigosilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigosilva.cursomc.domain.Pedido;
import com.rodrigosilva.cursomc.repositories.PedidoRepository;
import com.rodrigosilva.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado! id " + id + " , tipo: " + Pedido.class.getName()));
	}
}
