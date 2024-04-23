package principal.views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle.Control;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.controlers.ControladorContrato;
import principal.controlers.DatosDeTabla;
import principal.models.Contrato;

public class PanelTabla extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableContratos;
	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();
	private static PanelTabla instance = null;

	public static PanelTabla getInstance() {
		if (instance == null) {
			instance = new PanelTabla();
		}

		return instance;
	}

	/**
	 * Create the panel.
	 */
	public PanelTabla() {
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		this.dtm = getDefaultTableModelNoEditable();
		tableContratos = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(tableContratos);

		tableContratos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = tableContratos.getSelectedRow();
				Object value = datosEnTabla[indiceFilaSel][0];

				Contrato contSeleccionado = ControladorContrato.getInstance().obtenerContratoPorId((Integer) value);
				ControladorContrato.getInstance().mostrarContrato(contSeleccionado);
				GestionContratos gestionContratos = new GestionContratos(contSeleccionado);
				JScrollPane scrollPane2 = new JScrollPane(gestionContratos);
				splitPane.setRightComponent(scrollPane2);
				splitPane.setResizeWeight(0.2);

			}
		});

		splitPane.setLeftComponent(scrollPane);

	}

	public void actualizarTabla(Contrato c) {
		// 1. Actualizar los datos en la matriz datosEnTabla
		datosEnTabla = DatosDeTabla.getDatosDeTabla(); // Suponiendo que obtienes los nuevos datos de alguna fuente
		int f = tableContratos.getSelectedRow();

		this.datosEnTabla[f][0] = c.getId();
		this.datosEnTabla[f][1] = c.getIdUsuario();
		this.datosEnTabla[f][2] = c.getIdTipoContrato();
		this.datosEnTabla[f][3] = c.getDescripcion();
		this.datosEnTabla[f][4] = c.getSaldo();
		this.datosEnTabla[f][5] = c.getLimite();
		this.datosEnTabla[f][6] = c.getFechaFirma();

		// 3. Notificar a la tabla que los datos han sido actualizados
		dtm.fireTableDataChanged();

	}

	private DefaultTableModel getDefaultTableModelNoEditable() {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {

			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos
			 * que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}

	public Object[][] getDatosEnTabla() {
		return datosEnTabla;
	}

	public void setDatosEnTabla(Object[][] datosEnTabla) {
		this.datosEnTabla = datosEnTabla;
	}

}
