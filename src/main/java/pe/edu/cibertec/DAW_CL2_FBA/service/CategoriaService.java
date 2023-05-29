package pe.edu.cibertec.DAW_CL2_FBA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.DAW_CL2_FBA.model.bd.Categoria;
import pe.edu.cibertec.DAW_CL2_FBA.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	//Metodo Listar
	public List<Categoria>listarCategoria(){
		return categoriaRepository.findAll();
	}
	//Metodo Registrar
	public void registrarCategoria(Categoria categoria){
		categoriaRepository.save(categoria);
	}
	//Metodo Eliminar
	public void eliminarCategoria(Integer category_id){
		categoriaRepository.deleteById(category_id);
	}
	
	
	
	

}
