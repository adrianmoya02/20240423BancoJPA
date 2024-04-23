package principal.controlers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import principal.models.Entidad;

public class SuperControlador {

	private String nombreTabla = "";
	private Class tipoEntidad;
	private static EntityManager em = null;

	public SuperControlador(String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}

	public void update(Entidad e) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}

	public List<? extends Entidad> findAll() {
		return (List<Entidad>) getEntityManager().createNativeQuery("SELECT * FROM " + nombreTabla, this.tipoEntidad)
				.getResultList();

	}

	protected EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory("Banco").createEntityManager();
		}
		return em;
	}
}
