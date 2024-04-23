package principal.controlers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import principal.models.Usuario;

public class ControladorUsuario {

	private static EntityManager em = Persistence.createEntityManagerFactory("Papeleria").createEntityManager();

	private static String nombreTabla = "proveedor";

	public static Usuario findArtById(int id) {
		try {
			Usuario entidad = (Usuario) em.find(Usuario.class, id);
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static List<Usuario> findAll() {
		return (List<Usuario>) em.createNativeQuery("SELECT * FROM " + nombreTabla, Usuario.class).getResultList();

	}

	public static void update(Usuario u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
	}

}
