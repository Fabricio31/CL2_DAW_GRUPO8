package pe.edu.cibertec.DAW_CL2_FBA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.DAW_CL2_FBA.model.bd.Categoria;
import pe.edu.cibertec.DAW_CL2_FBA.model.request.CategoriaRequest;
import pe.edu.cibertec.DAW_CL2_FBA.model.response.ResultadoResponse;
import pe.edu.cibertec.DAW_CL2_FBA.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	//Metodo Listar Categorias
	@GetMapping("/frmcategoria")
	public String frmcategoria(Model model) {
		model.addAttribute("lstCategorias", categoriaService.listarCategoria());
		return "categoria/frmcategoria";
	}
	
	//Metodo Registrar Categoria
	@PostMapping("/registrarCategoria")
	@ResponseBody
	public ResultadoResponse registrarCategoria(@RequestBody CategoriaRequest categoriaRequest) 
	{
		String mensaje ="Categoria registrada correctamente";
		Boolean respuesta = true;
		try 
		{
			Categoria objCategoria = new Categoria();
			if(categoriaRequest.getCategory_id() > 0) {objCategoria.setCategory_id(categoriaRequest.getCategory_id());}
			//Se registrar el id porque no es autogenerado
			objCategoria.setCategory_id(categoriaRequest.getCategory_id());
			objCategoria.setCategory_name(categoriaRequest.getCategory_name());
			categoriaService.registrarCategoria(objCategoria);
		}
		catch(Exception ex)
		{
			mensaje = "No se pudo registrar la categoria";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	//Metodo Eliminar Categoria
	@DeleteMapping("/eliminarCategoria")
	@ResponseBody
	public ResultadoResponse eliminarCategoria(@RequestBody CategoriaRequest categoriaRequest)
	{
		String mensaje = "Categoria eliminada correctamente";
		Boolean respuesta = true;
		try 
		{
			categoriaService.eliminarCategoria(categoriaRequest.getCategory_id());
		}
		catch(Exception e) 
		{
			mensaje = "Categoria no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarCategorias")
	@ResponseBody
	public List<Categoria>listarCategorias(){
		return categoriaService.listarCategoria();
	}
	
	
	
	
	
	
	
	
}
