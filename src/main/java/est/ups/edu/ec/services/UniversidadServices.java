package est.ups.edu.ec.services;

import java.util.List;

import est.ups.edu.ec.business.GestionUniversidad;
import est.ups.edu.ec.model.Universidad;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("universidades")
public class UniversidadServices {
	
	@Inject
	private GestionUniversidad gUniversidad;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Universidad universidad) {
		try{
			gUniversidad.guardarUniversidad(universidad);;
			return Response.ok(universidad).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Universidad universidad) {
		try{
			gUniversidad.actualizarUniversidad(universidad);;
			return Response.ok(universidad).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("id") int codigo) {
		try{
			gUniversidad.borrarUniversidad(codigo);;
			return "OK";
		}catch (Exception e) {
			// TODO: handle exception
			return "Error";
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getFutbolistas(){
		List<Universidad> universidades = gUniversidad.getList();
		if(universidades.size()>0)
			return Response.ok(universidades).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran universidades");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}


}
