package principal.controlers;

import java.util.List;

import principal.models.Contrato;

public class DatosDeTabla {

	private static Object[][] datos = null;

	public static String[] getTitulosColumnas() {
		return new String[] { "Id", "idUsuario", "idTipoContrato", "descripcion", "saldo", "limite", "fechaFirma" };
	}

	public static Object[][] getDatosDeTabla() {
		if (datos == null) {
			List<Contrato> contrato = (List<Contrato>) ControladorContrato.getInstance().findAll();
			datos = new Object[contrato.size()][11];
			for (int i = 0; i < contrato.size(); i++) {
				Contrato c = contrato.get(i);
				datos[i][0] = c.getId();
				datos[i][1] = c.getIdUsuario();
				datos[i][2] = c.getIdTipoContrato();
				datos[i][3] = c.getDescripcion();
				datos[i][4] = c.getSaldo();
				datos[i][5] = c.getLimite();
				datos[i][6] = c.getFechaFirma();

			}
		}

		return datos;
	}

}
