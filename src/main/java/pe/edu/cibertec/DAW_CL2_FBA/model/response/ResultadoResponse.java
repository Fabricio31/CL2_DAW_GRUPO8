package pe.edu.cibertec.DAW_CL2_FBA.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
	
	private Boolean respuesta;
	private String mensaje; 

}
