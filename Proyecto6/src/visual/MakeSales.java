package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import logico.Cliente;
import logico.Combo;
import logico.Producto;
import logico.DiscoDuro;
import logico.Factura;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class MakeSales extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private JButton btnDelete;
	private JButton btnCancelar;
	private JButton btnFacturar;
	private JButton btncambiarCantidad;

	private String tipo;
	private Producto selected = null;
	private Combo selectedC = null;
	private JTextField CedulatextField;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField idtextfield;
	private static JTextField txtTotal;
	private static ArrayList<Producto> productosVenta = new ArrayList<Producto>();
	private static ArrayList<Producto> temporal = copiarPrueba();   
	private static ArrayList<Combo> combosTemp =  copiarCombo();  


	private static ArrayList<Combo> combosFactura = new ArrayList<Combo>();
	private  Producto selected_1 = null;
	private Combo selected_2 = null;
	private JSpinner Agregarspinner = null;
	private boolean control;
	private Cliente auxCliente = null;

	public static void main(String[] args) {
		try {
			MakeSales dialog = new MakeSales();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static ArrayList<Combo> copiarCombo()  {
		ArrayList<Combo> copia = new ArrayList<Combo>(Tienda.getInstance().getMisCombos().size());
		for (Combo comb : Tienda.getInstance().getMisCombos()) {
			try {
				copia.add((Combo) comb.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Tienda.getInstance().getMisCombos().size());
		return copia;
	}

	public MakeSales() {
		System.out.println(Tienda.getInstance().getMisCombos().size());

		inicializar();
		setBounds(100, 100, 1046, 503);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(1, 181, 1023, 197);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					String[] headers = {"ID","Componente","Modelo", "Stock", "Precio", "Subtotal" };

					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int ind = table.getSelectedRow();
							if (ind >= 0 ) {
								btnDelete.setEnabled(true);

								btncambiarCantidad.setEnabled(true);
								String codigo = table.getValueAt(ind, 0).toString();
								selected = buscarComponenteByIdSerieFactura(codigo);
							}
						}
					});
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);

				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(29, 11, 995, 159);
				panel.add(panel_1);
				{
					JLabel lblCdula = new JLabel("CEDULA CLIENTE");
					lblCdula.setBounds(55, 11, 147, 14);
					panel_1.add(lblCdula);
				}
				{
					CedulatextField = new JTextField();
					CedulatextField.setColumns(10);
					CedulatextField.setBounds(10, 36, 216, 23);
					panel_1.add(CedulatextField);
				}
				{
					JButton btninsertar = new JButton("AGREGAR CLIENTE");
					btninsertar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							auxCliente = Tienda.getInstance().ClienteByCedula(CedulatextField.getText());
							if(auxCliente != null){
								txtNombre.setText(auxCliente.getNombre()); 
								txtTelefono.setText(auxCliente.getTelefono());
								control = true;

							}else {
								txtNombre.setEditable(true);
								txtTelefono.setEditable(true);
								control = false;
							}
						}
					});
					btninsertar.setBounds(250, 66, 147, 23);
					panel_1.add(btninsertar);
				}
				{
					JLabel lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(65, 70, 79, 14);
					panel_1.add(lblNombre);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setEditable(false);
					txtNombre.setColumns(10);
					txtNombre.setBounds(10, 88, 216, 23);
					panel_1.add(txtNombre);
				}
				{
					JLabel lblTelfono = new JLabel("CELULAR");
					lblTelfono.setBounds(69, 111, 75, 14);
					panel_1.add(lblTelfono);
				}
				{
					txtTelefono = new JTextField();
					txtTelefono.setEditable(false);
					txtTelefono.setColumns(10);
					txtTelefono.setBounds(41, 127, 115, 23);
					panel_1.add(txtTelefono);
				}
				{
					JLabel lblcodigo = new JLabel("ID PRODUCTO");
					lblcodigo.setBounds(457, 111, 136, 14);
					panel_1.add(lblcodigo);
				}
				{
					idtextfield = new JTextField();
					idtextfield.setColumns(10);
					idtextfield.setBounds(443, 127, 178, 23);
					panel_1.add(idtextfield);
				}
				{
					JButton btnAnadir = new JButton("AGREGAR PRODUCTO");
					btnAnadir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String id = idtextfield.getText().toString();
							System.out.println(id);
							Producto producto = buscarComponenteByIdSerie(id);

							Boolean controlador = false;
					
							
							if(producto != null && producto.getCantidadDisp()>0) {

								int diferencia = 1;
								try {
									selected_1 = Tienda.getInstance().copiarComp(producto);
								} catch (CloneNotSupportedException e1) {
									e1.printStackTrace();
									System.out.println("PROBLEMAS");
								}

								selected_1.setCantidadDisp(diferencia);
								producto.setCantidadDisp(producto.getCantidadDisp()-diferencia);
								reescribirProducto(producto);
								productosVenta.add(selected_1);

								controlador = true;
							} 
							if(controlador == false) {
								JOptionPane.showMessageDialog(null, "No hay", "Error", JOptionPane.INFORMATION_MESSAGE);
							}

							load();
						}

					});
					btnAnadir.setBounds(641, 127, 171, 23);
					panel_1.add(btnAnadir);
				}
				{
					JLabel lblNuemroDeSerie = new JLabel("Cantidad por articulo:");
					lblNuemroDeSerie.setBounds(457, 70, 115, 14);
					panel_1.add(lblNuemroDeSerie);
				}
				
							Agregarspinner = new JSpinner();
							Agregarspinner.setBounds(600, 67, 46, 20);
							panel_1.add(Agregarspinner);
							Agregarspinner.setValue(1);
							{
								btncambiarCantidad = new JButton("+ Cantidad");
								btncambiarCantidad.setBounds(711, 65, 101, 25);
								panel_1.add(btncambiarCantidad);
								btncambiarCantidad.setEnabled(false);
								btncambiarCantidad.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										if(selected != null) {
											Producto nuevo = null;
											try {
												nuevo = (Producto) selected.clone();
											} catch (CloneNotSupportedException e1) {
												e1.printStackTrace();
											} 

											Producto comp = buscarComponenteByIdSerieFactura(nuevo.getId());
											comp.setCantidadDisp((Integer) Agregarspinner.getValue());

											Agregarspinner.setValue(0);
										}
										load();
									}


								});
							}
			}
			{
				JLabel lblTotal = new JLabel("Total:");
				lblTotal.setBounds(762, 394, 46, 14);
				panel.add(lblTotal);
			}
			{
				txtTotal = new JTextField();
				txtTotal.setEditable(false);
				txtTotal.setColumns(10);
				txtTotal.setBounds(855, 390, 115, 23);
				panel.add(txtTotal);
			}

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();
			String fechaActual = formatter.format(now);

		}
		{

			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				btnDelete = new JButton("ELIMINAR");
				btnDelete.setEnabled(false);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected != null) {
							int option = JOptionPane.showConfirmDialog(null,
									"¿Estás seguro de querer eliminarlo?",
									"Eliminar Producto", JOptionPane.OK_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION) {

								int diferencia = selected.getCantidadDisp();
								Producto producto = buscarComponenteByIdSerie(selected.getId());
								producto.setCantidadDisp(producto.getCantidadDisp()+diferencia);
								reescribirProducto(producto);
								productosVenta.remove(selected);

							}
							load();
						}

					}
				});

				{


					{
						btnFacturar = new JButton("FACTURAR");
						btnFacturar.addActionListener(new ActionListener() {
						    public void actionPerformed(ActionEvent e) {
						        ArrayList<Producto> faccomp = copiarArraytemp();


						        if (!control) {
						            auxCliente = new Cliente(txtNombre.getText(), CedulatextField.getText(), null, txtTelefono.getText());
						            Tienda.getInstance().registrarCliente(auxCliente);
						        }
						        JOptionPane.showMessageDialog(null, "EFECTIVA", "Informacion", JOptionPane.INFORMATION_MESSAGE);

						        String codigo = "Venta-" + Tienda.getInstance().getMisFacturas().size();

						        Factura nuevaFactura = new Factura(codigo, txtTotal.getText(), auxCliente, faccomp, null );
						        Tienda.getInstance().setMisComponentes(temporal);
						        Tienda.getInstance().agregarFactura(nuevaFactura);

						        clean();
						        load();
						    }
						});

						buttonPane.add(btnFacturar);
					}
				}
				buttonPane.add(btnDelete);
			}

			{
				btnCancelar = new JButton("CANCELAR");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}

		load();
	}

	public static void load() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		float total = 0;
		int[] cont;
		for (Producto aux : productosVenta) {

			rows[0] = aux.getId();
			rows[2] = aux.getModelo();
			rows[3] = aux.getCantidadDisp();
			rows[4] = aux.getPrecio();
			rows[5] = aux.getPrecio()*aux.getCantidadDisp();
			if(aux instanceof DiscoDuro ){
				rows[1] = "HardDIsk";	
			}
			if(aux instanceof MemoriaRAM){
				rows[1] = "RAM";	
			}
			if(aux instanceof Microprocesador ){
				rows[1] = "MicroProccesor";
			}
			if(aux instanceof TarjetaMadre ){
				rows[1] = "MotherBoard";
			}
			model.addRow(rows);
			total += aux.getPrecio()*aux.getCantidadDisp();
		}
		String txt = Float.toString(total);
		txtTotal.setText(txt);
	}

	public Producto buscarComponenteByIdSerie(String id) {
		Producto aux = null;
		for(Producto componentes : temporal) {
			if(componentes.getId().equalsIgnoreCase(id)) {
				aux = componentes;
			}
		}
		return aux;
	}

	public Producto buscarComponenteByIdSerieFactura(String id) {
		Producto aux = null;
		for(Producto componentes : productosVenta) {
			if(componentes.getId().equalsIgnoreCase(id)) {
				aux = componentes;
			}
		}
		return aux;
	}


	public static ArrayList<Producto> copiarPrueba() {
		try {
			temporal = Tienda.getInstance().copiarArray();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return temporal;
	}
	
	public void reescribirProducto(Producto producto) {

		ArrayList<Producto> copia = new ArrayList<Producto>();
		for (Producto c : temporal) {
			try {
				copia.add((Producto) c.clone());
			} catch (CloneNotSupportedException e2) {
				e2.printStackTrace();
			}
		}
		for(Producto productos: copia) {
			if(productos == productos) {
				temporal.remove(productos);
				temporal.add(productos);
			}
		}

	}


	public void reescribirFacturaComp(Producto producto) {
		ArrayList<Producto> copia = new ArrayList<Producto>();
		for (Producto c : temporal) {
			try {
				copia.add((Producto) c.clone());
			} catch (CloneNotSupportedException e2) {
				e2.printStackTrace();
			}
		}

		for(Producto productos: copia) {
			if(productos == productos) {
				System.out.println(productos.getCantidadDisp());
				productosVenta.remove(productos);
				productosVenta.add(productos);
			}
		}

	}


	public void inicializar() {
		ArrayList<Producto> copiaFactura = new ArrayList<Producto>();
		for (Producto c : productosVenta) {
			try {
				copiaFactura.add((Producto) c.clone());
			} catch (CloneNotSupportedException e2) {
				e2.printStackTrace();
			}
		}
		for (Producto selected : copiaFactura) {
			int cantidad = selected.getCantidadDisp();
			Producto producto = buscarComponenteByIdSerie(selected.getId());
			producto.setCantidadDisp(producto.getCantidadDisp() + cantidad);
			reescribirProducto(producto);
			productosVenta.remove(selected);
		}

		productosVenta.clear();

	}

	public void clean(){
		productosVenta.clear();
		combosFactura.clear();
		CedulatextField.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		idtextfield.setText("");
		txtNombre.setEditable(false);;
		txtTelefono.setEditable(false);
	}
	



	public ArrayList<Producto> copiarArraytemp (){

		ArrayList<Producto> copia = new ArrayList<Producto>(productosVenta.size());
		for (Producto produc : productosVenta) {
			try {
				copia.add((Producto) produc.clone());
			}catch (CloneNotSupportedException e) {
			}
		}

		return copia;
	}
	
	
}
