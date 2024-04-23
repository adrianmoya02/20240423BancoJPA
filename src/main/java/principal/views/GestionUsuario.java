package principal.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;

import principal.controlers.ControladorUsuario;
import principal.models.Usuario;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class GestionUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private static GestionUsuario instance = null;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JPasswordField passwordField;
	private JTextField jtfEmail;
	private JComboBox<String> jcbColor;

	/**
	 * Create the panel.
	 */
	public GestionUsuario(Usuario u) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblTitulo = new JLabel("Título del componente");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 0;
		add(lblTitulo, gbc_lblTitulo);

		JLabel lblId = new JLabel("Id :");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 2;
		add(lblId, gbc_lblId);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 2;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 3;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Contraseña :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);

		JLabel lblNewLabel_2 = new JLabel("Email :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 5;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Color preferido :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcbColor = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		add(jcbColor, gbc_comboBox);

		JButton btnNewButton = new JButton("Guardar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 8;
		add(btnNewButton, gbc_btnNewButton);

		cargarDatos(u);
		cargarColores();
	}

	public GestionUsuario() {
	}

	public void cargarDatos(Usuario u) {
		this.jtfId.setText(String.valueOf(u.getId()));
		this.jtfNombre.setText(u.getNombreUsuario());
		this.jtfEmail.setText(u.getEmail());
		this.passwordField.setText(u.getPassword());
		seleccionarColor(u);
	}

	public void seleccionarColor(Usuario u) {

		for (int i = 0; i < 2; i++) {
			String colorItem = (String) this.jcbColor.getItemAt(i);
			if (u.getColorPreferido().equals(colorItem)) {
				this.jcbColor.setSelectedIndex(i);
				break; 
			}
		}
	}

	private void cargarColores() {

		this.jcbColor.addItem("#FF00FF");
		this.jcbColor.addItem("#9890A5");
		this.jcbColor.addItem("#765456");
		this.jcbColor.addItem("#879876");
	}

	private void guardar() {

		Usuario u = ControladorUsuario.findArtById(Integer.parseInt(this.jtfId.getText()));
		u.setNombreUsuario(this.jtfNombre.getSelectedText());
		u.setEmail(this.jtfEmail.getSelectedText());
		u.setPassword(this.passwordField.getSelectedText());
		u.setColorPreferido(String.valueOf(this.jcbColor.getSelectedItem()));

		ControladorUsuario.update(u);
		JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
	}

	public static GestionUsuario getInstance() {
		return null;
	}
private void setGestionUsarios() {
		
	}
}
