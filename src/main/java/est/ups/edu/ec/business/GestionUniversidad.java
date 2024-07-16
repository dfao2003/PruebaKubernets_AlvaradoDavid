package est.ups.edu.ec.business;

import java.util.List;

import est.ups.edu.ec.dao.UniversidadDAO;
import est.ups.edu.ec.model.Universidad;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUniversidad {
	
	@Inject
	private UniversidadDAO universidadDao;
	
	public void guardarUniversidad(Universidad universidad) {
		Universidad uni = universidadDao.read(universidad.getCodUni());
		if (uni != null){
			universidadDao.update(universidad);
		}else {
			universidadDao.insert(universidad);
		}
	}
	
	public void actualizarUniversidad(Universidad universidad) throws Exception{
		Universidad uni = universidadDao.read(universidad.getCodUni());
		if(uni != null){
			universidadDao.update(universidad);
		}else {
			throw new Exception("La universidad no existe");
		}
	}
	
	public Universidad getporCodigo(String uniCod) throws Exception{
		return universidadDao.getUniversidadporId(uniCod);
	}
	
	public void borrarUniversidad(int codigo){
		universidadDao.remove(codigo);
	}
	
	public List<Universidad> getList(){
		return universidadDao.getAll();
	}

}
