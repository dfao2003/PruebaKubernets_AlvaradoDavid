package est.ups.edu.ec.dao;

import java.util.List;

import est.ups.edu.ec.model.Universidad;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UniversidadDAO {
	
	@PersistenceContext
     private EntityManager em;
	
	public void insert(Universidad universidad){
		em.persist(universidad);
	}
	
	public void update(Universidad universidad){
		em.merge(universidad);
	}
	
	public void remove(int codigo){
		Universidad universidad = em.find(Universidad.class, codigo);
		em.remove(universidad);
	}
	
	public Universidad read(int codigo){
		Universidad universidad = em.find(Universidad.class, codigo);
		return universidad;	
	}
	
	public List<Universidad> getAll(){
		String jpql = "SELECT C from Universidad c";
		Query q = em.createQuery(jpql, Universidad.class);
		return q.getResultList();
	}
	
	public Universidad getUniversidadporId(String codUni){
		String jpql = "SELECT c FROM Universidad c WHERE c.codUni = :codUni";
		Query q = em.createQuery(jpql, Universidad.class);
		q.setParameter("codUni", codUni);
		List<Universidad> universidades = q.getResultList();
		if(universidades.size()>0)
			return universidades.get(0);
		return null;
	}

}
