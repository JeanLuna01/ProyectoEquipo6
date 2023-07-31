package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Producto;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;

public class InsertProducts extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JTextField textid;
	private JTextField txtserie;
	private JSpinner spnPrecio;
	private JSpinner spnCantidad;

	private JRadioButton rdbMicro;
	private JRadioButton rdbDiscoDuro;
	private JRadioButton rdbTarjetaMadre;
	private JRadioButton rdbMemoriaRam;
	private JPanel pnlPrueba;

	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textSocket;


	private JTextField txtGb;
	private JSpinner spnCapacidad;

	private JSpinner spnVelocidad;
	private JTextField txtGhz;

	private JLabel lblTipoDeRam;
	private JLabel lblSocket;
	private JLabel lblConexiones;
	private JLabel lblCapacidad;
	private JLabel lblVelocidad;
	private JTextField textConexiones;
	private JTextField txtram;


	public static void main(String[] args) {
		try {
			InsertProducts dialog = new InsertProducts();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public InsertProducts() {
		setResizable(false);
		setBounds(100, 100, 771, 550);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(5, 13, 750, 197);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Componente:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblcodigo = new JLabel("CODIGO");
			lblcodigo.setBounds(12, 29, 132, 14);
			panel.add(lblcodigo);

			textid = new JTextField();
			textid.setEditable(false);
			textid.setBackground(new Color(255, 255, 255));
			textid.setBounds(84, 26, 200, 20);
			panel.add(textid);
			textid.setColumns(10);

			JLabel lblDescripcion = new JLabel("Numero Serie");
			lblDescripcion.setBounds(12, 120, 90, 14);
			panel.add(lblDescripcion);

			txtserie = new JTextField();
			txtserie.setBounds(139, 117, 200, 20);
			panel.add(txtserie);
			txtserie.setText((String) null);
			txtserie.setColumns(10);

			JLabel lblPrecioBase = new JLabel("Precio");
			lblPrecioBase.setBounds(12, 75, 72, 14);
			panel.add(lblPrecioBase);

			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
			spnPrecio.setBounds(84, 72, 200, 20);
			panel.add(spnPrecio);

			JLabel lblCantidad = new JLabel("CANTIDAD");
			lblCantidad.setBounds(12, 161, 72, 14);
			panel.add(lblCantidad);

			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCantidad.setBounds(84, 155, 200, 20);
			panel.add(spnCantidad);
			
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(349, 56, 391, 97);
					panel.add(panel_1);
					panel_1.setBackground(new Color(255, 255, 255));
					panel_1.setToolTipText("");
					panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Componente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					panel_1.setLayout(null);
					
							rdbTarjetaMadre = new JRadioButton("TarjetaMadre");
							rdbTarjetaMadre.setBackground(new Color(255, 255, 255));
							rdbTarjetaMadre.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									rdbTarjetaMadre.setSelected(true);
									rdbDiscoDuro.setSelected(false);
									rdbMicro.setSelected(false);
									rdbMemoriaRam.setSelected(false);

									lblTipoDeRam.setVisible(true);
									txtram.setVisible(true);

									lblSocket.setVisible(true);
									textSocket.setVisible(true);
									lblSocket.setEnabled(true);
									textSocket.setEnabled(true);

									textConexiones.setVisible(false);
									textConexiones.setVisible(true);
									lblConexiones.setVisible(true);

									lblVelocidad.setVisible(false);
									spnVelocidad.setVisible(false);

									lblCapacidad.setVisible(false);
									spnCapacidad.setVisible(false);

									txtGb.setVisible(false);
									txtGhz.setVisible(false);
									sumarCodigo();
								}
							});
							rdbTarjetaMadre.setSelected(true);
							rdbTarjetaMadre.setBounds(7, 25, 118, 23);
							panel_1.add(rdbTarjetaMadre);
							
									rdbDiscoDuro = new JRadioButton("Disco Duro");
									rdbDiscoDuro.setBackground(new Color(255, 255, 255));
									rdbDiscoDuro.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											rdbMicro.setSelected(false);
											rdbMemoriaRam.setSelected(false);
											rdbTarjetaMadre.setSelected(false);
											rdbDiscoDuro.setSelected(true);

											textConexiones.setVisible(true);
											textConexiones.setVisible(false);
											lblConexiones.setVisible(true);

											lblCapacidad.setBounds(139, 83, 110, 14);
											spnCapacidad.setBounds(139, 102, 128, 20);
											txtGb.setBounds(266, 102, 29, 20);

											lblCapacidad.setVisible(true);
											spnCapacidad.setVisible(true);

											lblTipoDeRam.setVisible(false);
											txtram.setVisible(false);

											lblSocket.setVisible(false);
											textSocket.setVisible(false);

											lblVelocidad.setVisible(false);
											spnVelocidad.setVisible(false);

											txtGb.setVisible(true);
											txtGhz.setVisible(false);

											sumarCodigo();
										}
									});
									rdbDiscoDuro.setBounds(202, 25, 109, 23);
									panel_1.add(rdbDiscoDuro);
									
											rdbMicro = new JRadioButton("Micro-Procesador");
											rdbMicro.setBackground(new Color(255, 255, 255));
											rdbMicro.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													rdbDiscoDuro.setSelected(false);
													rdbMicro.setSelected(true);
													rdbMemoriaRam.setSelected(false);
													rdbTarjetaMadre.setSelected(false);

													lblTipoDeRam.setVisible(false);
													txtram.setVisible(false);

													lblSocket.setVisible(true);
													textSocket.setVisible(true);

													textConexiones.setVisible(false);
													lblConexiones.setVisible(false);
													textConexiones.setVisible(false);

													lblVelocidad.setVisible(true);
													spnVelocidad.setVisible(true);

													lblCapacidad.setVisible(false);
													spnCapacidad.setVisible(false);

													txtGb.setVisible(false);
													txtGhz.setVisible(true);

													sumarCodigo();
												}
											});
											rdbMicro.setBounds(7, 69, 152, 23);
											panel_1.add(rdbMicro);
											
													rdbMemoriaRam = new JRadioButton("Memoria Ram");
													rdbMemoriaRam.setBackground(new Color(255, 255, 255));
													rdbMemoriaRam.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															rdbDiscoDuro.setSelected(false);
															rdbMicro.setSelected(false);
															rdbMemoriaRam.setSelected(true);
															rdbTarjetaMadre.setSelected(false);

															lblTipoDeRam.setVisible(true);
															txtram.setVisible(true);

															lblSocket.setVisible(false);
															textSocket.setVisible(false);

															textConexiones.setVisible(false);
															lblConexiones.setVisible(false);
															textConexiones.setVisible(false);

															lblVelocidad.setVisible(false);
															spnVelocidad.setVisible(false);

															lblCapacidad.setBounds(201, 83, 110, 14);
															spnCapacidad.setBounds(201, 102, 128, 20);
															lblCapacidad.setVisible(true);
															spnCapacidad.setVisible(true);

															txtGb.setBounds(326, 102, 29, 20);
															txtGb.setVisible(true);
															txtGhz.setVisible(false);

															sumarCodigo();
														}
													});
													rdbMemoriaRam.setBounds(202, 69, 127, 23);
													panel_1.add(rdbMemoriaRam);
		}

		pnlPrueba = new JPanel();
		pnlPrueba.setBackground(new Color(255, 255, 255));
		pnlPrueba.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPrueba.setLayout(null);
		pnlPrueba.setToolTipText("");
		pnlPrueba.setBounds(171, 210, 391, 202);
		contentPanel.add(pnlPrueba);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 13, 90, 14);
		pnlPrueba.add(lblMarca);

		textMarca = new JTextField();
		textMarca.setBounds(12, 28, 128, 20);
		pnlPrueba.add(textMarca);
		textMarca.setText((String) null);
		textMarca.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(201, 13, 110, 14);
		pnlPrueba.add(lblModelo);

		textModelo = new JTextField();
		textModelo.setBounds(201, 28, 128, 20);
		pnlPrueba.add(textModelo);
		textModelo.setText((String) null);
		textModelo.setColumns(10);

		lblTipoDeRam = new JLabel("Tipo De Ram:");
		lblTipoDeRam.setBounds(12, 83, 110, 14);
		pnlPrueba.add(lblTipoDeRam);

		lblSocket = new JLabel("Socket:");
		lblSocket.setBounds(201, 83, 110, 14);
		pnlPrueba.add(lblSocket);

		textSocket = new JTextField();
		textSocket.setBounds(201, 102, 128, 20);
		pnlPrueba.add(textSocket);
		textSocket.setText((String) null);
		textSocket.setColumns(10);

		lblConexiones = new JLabel("Conexiones:");
		lblConexiones.setBounds(139, 135, 90, 14);
		pnlPrueba.add(lblConexiones);

		lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(139, 83, 110, 14);
		pnlPrueba.add(lblCapacidad);

		spnCapacidad = new JSpinner();
		spnCapacidad.setBounds(139, 102, 128, 20);
		pnlPrueba.add(spnCapacidad);
		spnCapacidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));

		txtGb = new JTextField();
		txtGb.setBounds(266, 102, 29, 20);
		pnlPrueba.add(txtGb);
		txtGb.setColumns(10);
		txtGb.setEditable(false);
		txtGb.setText("GB");

		lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setBounds(12, 83, 81, 14);
		pnlPrueba.add(lblVelocidad);

		spnVelocidad = new JSpinner();
		spnVelocidad.setBounds(4, 101, 98, 22);
		pnlPrueba.add(spnVelocidad);
		spnVelocidad.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));

		txtGhz = new JTextField();
		txtGhz.setBounds(111, 102, 29, 20);
		pnlPrueba.add(txtGhz);
		txtGhz.setText("Ghz");
		txtGhz.setEditable(false);
		txtGhz.setColumns(10);

		textConexiones = new JTextField();
		textConexiones.setBounds(139, 149, 128, 20);
		pnlPrueba.add(textConexiones);
		textConexiones.setText((String) null);
		textConexiones.setColumns(10);
		
		txtram = new JTextField();
		txtram.setText((String) null);
		txtram.setColumns(10);
		txtram.setBounds(12, 102, 110, 20);
		pnlPrueba.add(txtram);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(22, 423, 582, 38);
			contentPanel.add(buttonPane);
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

			{
				JButton btnregistrar = new JButton("REGISTRAR");
				btnregistrar.setBackground(Color.WHITE);
				btnregistrar.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        Producto aux = null;
				        String modelo = textModelo.getText();
				        String marca = textMarca.getText();
				        Float precio = Float.valueOf(spnPrecio.getValue().toString());
				        int stock = Integer.valueOf((Integer) spnCantidad.getValue());
				        String id = textid.getText();
				        String serial = txtserie.getText();

				        if(rdbTarjetaMadre.isSelected()){
				            String socket = textSocket.getText();
				            String tipo = txtram.getText(); 
				            String conexion = textConexiones.getText(); 
				            aux = new TarjetaMadre(marca,modelo, precio, stock, serial, id, socket, tipo, conexion);
				        }
				        if(rdbDiscoDuro.isSelected()){
				            int capacidad = Integer.valueOf((Integer) spnCapacidad.getValue()); 
				            String conexion = textConexiones.getText();
				            aux = new DiscoDuro(marca,modelo, precio, stock, serial, id,capacidad, conexion);
				        }
				        if(rdbMicro.isSelected()){
				            String socket = textSocket.getText();
				            int velocidad = Integer.valueOf((Integer) spnVelocidad.getValue());
				            aux = new Microprocesador(marca,modelo, precio, stock, serial, id, velocidad, socket);
				        }
				        if(rdbMemoriaRam.isSelected()){
				            String tipo = txtram.getText(); 
				            int capacidad = Integer.valueOf((Integer) spnCapacidad.getValue()); 
				            aux = new MemoriaRAM(marca,modelo, precio, stock, serial, id, capacidad, tipo);
				        }
				        Tienda.getInstance().RegistrarComponente(aux);
				        JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				        clean();
				    }
				});

				btnregistrar.setActionCommand("OK");
				buttonPane.add(btnregistrar);
				getRootPane().setDefaultButton(btnregistrar);
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		if (rdbTarjetaMadre.isSelected()) {
			Reset();
			sumarCodigo();
		}
		sumarCodigo();
	}

	private void sumarCodigo() {
		String pre = "";
		if(rdbTarjetaMadre.isSelected()){
			pre = "MB";
		}
		if(rdbMicro.isSelected()){
			pre = "MP";	
		}
		if(rdbDiscoDuro.isSelected()){
			pre = "DD";	
		}
		if(rdbMemoriaRam.isSelected()) {
			pre = "RM";
		}
		textid.setText(pre+"-"+Tienda.id);
	}

	private void clean() {

		rdbTarjetaMadre.setSelected(true);
		rdbMicro.setSelected(false);
		rdbDiscoDuro.setSelected(false);
		rdbMemoriaRam.setSelected(false);

		textMarca.setText(" ");
		txtserie.setText(" ");
		textModelo.setText(" ");
		textSocket.setText(" ");
		textConexiones.setText(" ");


		spnPrecio.setValue(new Float(0.0));
		spnCapacidad.setValue(new Integer(0));
		spnVelocidad.setValue(new Float(0.0));
		spnCantidad.setValue(new Integer(1));
		Reset();
		sumarCodigo();
	}
	private void Reset() {
		rdbTarjetaMadre.setSelected(true);
		rdbDiscoDuro.setSelected(false);
		rdbMicro.setSelected(false);
		rdbMemoriaRam.setSelected(false);

		lblTipoDeRam.setVisible(true);
		txtram.setVisible(true);

		lblSocket.setVisible(true);
		textSocket.setVisible(true);
		lblSocket.setEnabled(true);
		textSocket.setEnabled(true);

		textConexiones.setVisible(true);
		textConexiones.setVisible(true);
		lblConexiones.setVisible(true);

		lblVelocidad.setVisible(false);
		spnVelocidad.setVisible(false);

		lblCapacidad.setVisible(false);
		spnCapacidad.setVisible(false);

		txtGb.setVisible(false);
		txtGhz.setVisible(false);
	}
}
