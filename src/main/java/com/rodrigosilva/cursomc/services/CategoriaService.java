package com.rodrigosilva.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rodrigosilva.cursomc.domain.Categoria;
import com.rodrigosilva.cursomc.dto.CategoriaDTO;
import com.rodrigosilva.cursomc.repositories.CategoriaRepository;
import com.rodrigosilva.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado! id "));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
	}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("não é possível excluir, porque tem entidades relacionadas!" );
		}
  }
	public List <Categoria> findAll(){
		return repo.findAll();
	}
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	private void updateData(Categoria newObj, Categoria obj) {
	    newObj.setNome(obj.getNome());
	}
}	
