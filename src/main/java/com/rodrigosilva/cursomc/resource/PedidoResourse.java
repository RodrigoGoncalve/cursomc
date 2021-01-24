package com.rodrigosilva.cursomc.resource;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigosilva.cursomc.domain.Categoria;
import com.rodrigosilva.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/Pedido")
public class PedidoResourse {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value = "/{Id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer Id) {
		
		Categoria obj = service.buscar(Id);
		return ResponseEntity.ok().body(obj);
		
	}

}
