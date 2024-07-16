package est.ups.edu.ec.business;

import est.ups.edu.ec.dao.UniversidadDAO;
import est.ups.edu.ec.model.Universidad;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private UniversidadDAO universidadDao;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Universidad uni1 = new Universidad();
		uni1.setCodUni(1);
		uni1.setNombre("UPS");
		uni1.setPais("Ecuador");
		uni1.setCiudad("Cuenca");
		
		universidadDao.insert(uni1);
		
		Universidad uni2 = new Universidad();
		uni2.setCodUni(2);
		uni2.setNombre("UCuenca");
		uni2.setPais("Ecuador");
		uni2.setCiudad("Cuenca");
		
		universidadDao.insert(uni2);
		
		System.out.print(universidadDao.getAll());
	}
	
}
