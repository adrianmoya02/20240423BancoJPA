package principal.controlers;

import principal.models.Contrato;

public class ControladorContrato extends SuperControlador {

	private static ControladorContrato instance = null;

	public ControladorContrato() {
		super("contrato", Contrato.class);
	}

	public static ControladorContrato getInstance() {
		if (instance == null) {
			instance = new ControladorContrato();
		}
		return instance;
	}

	public Contrato obtenerContratoPorId(int idContrato) {
		return (Contrato) getEntityManager()
				.createNativeQuery("SELECT * FROM contrato where id = " + idContrato, Contrato.class).getSingleResult();

	}

	public void mostrarContrato(Contrato e) {

	}

}
