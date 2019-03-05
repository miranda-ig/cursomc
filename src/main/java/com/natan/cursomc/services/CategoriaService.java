/**
 * 
 */
package com.natan.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natan.cursomc.domain.Categoria;
import com.natan.cursomc.repositories.CategoriaRepository;
import com.natan.cursomc.services.exception.ObjectNotFoundException;


/**
 * @author natancardosodev
 *
 */
@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository rep;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		// null para que o save() não entenda como update
		obj.setId(null);
		return rep.save(obj);
	}
}
