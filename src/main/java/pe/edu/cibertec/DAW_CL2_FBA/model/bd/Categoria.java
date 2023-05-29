package pe.edu.cibertec.DAW_CL2_FBA.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_category")
public class Categoria {
	//Sin Identity porque el id no es autogenerado
	@Id
	private Integer category_id;
	@Column(name = "category_name")
	private String category_name;
	
	
	
	
	
	
	

}
