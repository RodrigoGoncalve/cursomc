package com.rodrigosilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rodrigosilva.cursomc.domain.Categoria;
import com.rodrigosilva.cursomc.repositories.CategoriaRepository;
import com.rodrigosilva.cursomc.services.exception.DateIntegrityException;
import com.rodrigosilva.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado! id " + id + " , tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
	}
		catch(DateIntegrityException e) {
			throw new DateIntegrityException("não é possível excluir uma categoria que possui produto");
		}
  }
}	
