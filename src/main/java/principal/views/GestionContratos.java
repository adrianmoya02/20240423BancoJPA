package principal.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import principal.controlers.ControladorUsuario;
import principal.models.Contrato;
import principal.models.Usuario;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploPanelDentroDeDialogo.PanelDentroDeDialogo;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class GestionContratos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField JtfFecha;
	private JTextField jtfId;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdbtnCuentaBancaria;
	JRadioButton rdbtnTarjetaCredito;
	JRadioButton rdbtnTarjetaDebito;
	JRadioButton rdbtnPrestamo;
	private JComboBox<Usuario> jcbUsuario;
	GestionUsuario ga = GestionUsuario.getInstance();

	/**
	 * Create the panel.
	 */
	public GestionContratos(Contrato c) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Gestion de Contrato");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_7 = new JLabel("Id :");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 2;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 2;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		rdbtnCuentaBancaria = new JRadioButton("Cuenta Bancaria");
		buttonGroup.add(rdbtnCuentaBancaria);
		GridBagConstraints gbc_rdbtnCuentaBancaria = new GridBagConstraints();
		gbc_rdbtnCuentaBancaria.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCuentaBancaria.gridx = 1;
		gbc_rdbtnCuentaBancaria.gridy = 3;
		add(rdbtnCuentaBancaria, gbc_rdbtnCuentaBancaria);

		rdbtnTarjetaCredito = new JRadioButton("Tarjeta de Credito");
		buttonGroup.add(rdbtnTarjetaCredito);
		GridBagConstraints gbc_rdbtnTarjetaCredito = new GridBagConstraints();
		gbc_rdbtnTarjetaCredito.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnTarjetaCredito.gridx = 2;
		gbc_rdbtnTarjetaCredito.gridy = 3;
		add(rdbtnTarjetaCredito, gbc_rdbtnTarjetaCredito);

		JLabel lblNewLabel_1 = new JLabel("Tipo Contrato : ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		rdbtnTarjetaDebito = new JRadioButton("Tarjeta de Debito");
		buttonGroup.add(rdbtnTarjetaDebito);
		GridBagConstraints gbc_rdbtnTarjetaDebito = new GridBagConstraints();
		gbc_rdbtnTarjetaDebito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTarjetaDebito.gridx = 1;
		gbc_rdbtnTarjetaDebito.gridy = 4;
		add(rdbtnTarjetaDebito, gbc_rdbtnTarjetaDebito);

		rdbtnPrestamo = new JRadioButton("Prestamo");
		buttonGroup.add(rdbtnPrestamo);
		GridBagConstraints gbc_rdbtnPrestamo = new GridBagConstraints();
		gbc_rdbtnPrestamo.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnPrestamo.gridx = 2;
		gbc_rdbtnPrestamo.gridy = 4;
		add(rdbtnPrestamo, gbc_rdbtnPrestamo);

		JLabel lblNewLabel_2 = new JLabel("Descripcion :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 5;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Usuario :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcbUsuario = new JComboBox();
		GridBagConstraints gbc_jcbUsuario = new GridBagConstraints();
		gbc_jcbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuario.gridx = 1;
		gbc_jcbUsuario.gridy = 6;
		add(jcbUsuario, gbc_jcbUsuario);

		JButton btnNewButton_1 = new JButton("Gestionar Usuario");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirNuevoDialogo();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 6;
		add(btnNewButton_1, gbc_btnNewButton_1);

		JLabel lblNewLabel_4 = new JLabel("Saldo (€) :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 7;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 2;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 7;
		add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Limite (€) :");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 8;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfLimite = new JTextField();
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 2;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 8;
		add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Fecha de firma :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 9;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		JtfFecha = new JTextField();
		GridBagConstraints gbc_JtfFecha = new GridBagConstraints();
		gbc_JtfFecha.gridwidth = 2;
		gbc_JtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_JtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_JtfFecha.gridx = 1;
		gbc_JtfFecha.gridy = 9;
		add(JtfFecha, gbc_JtfFecha);
		JtfFecha.setColumns(10);

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 11;
		add(btnNewButton, gbc_btnNewButton);

		cargarDatos(c);
	}

	public GestionContratos() {
	}

	public void cargarDatos(Contrato c) {
		this.jtfId.setText(String.valueOf(c.getId()));
		this.jtfDescripcion.setText(c.getDescripcion());
		this.jtfSaldo.setText(String.valueOf(c.getSaldo()));
		this.jtfLimite.setText(String.valueOf(c.getLimite()));
		selUsuario(c);
	}

	private void selUsuario(Contrato c) {
		for (int i = 0; i < this.jcbUsuario.getItemCount(); i++) {
			if (this.jcbUsuario.getItemAt(i).getId() == c.getIdUsuario()) {
				this.jcbUsuario.setSelectedIndex(i);
			}
		}
	}


	public void abrirNuevoDialogo() {
		JDialog dialogo = new JDialog();
		// El usuario no puede redimensionar el di�logo
		dialogo.setResizable(true);
		// t�tulo del d�alogo
		dialogo.setTitle("Gestión de empresas");
		// Introducimos el panel creado sobre el di�logo
		dialogo.setContentPane(new GestionUsuario());
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que
		// deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - dialogo.getWidth() / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - dialogo.getHeight() / 2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}

	private void cargarUsuarios() {
		List<Usuario> u = ControladorUsuario.findAll();
		for (Usuario usuario : u) {
			this.jcbUsuario.addItem(usuario);
		}

	}

	public void seleccionarUsuario(int idUsuario) {
		for (int i = 0; i < this.jcbUsuario.getItemCount(); i++) {
			if (this.jcbUsuario.getItemAt(i).getId() == idUsuario) {
				this.jcbUsuario.setSelectedIndex(i);
			}
		}
	}
	
}
