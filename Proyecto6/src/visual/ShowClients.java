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
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowClients extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private final JLabel lblListadoDeClientes = new JLabel("Listado Clientes:");
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnsalir;
	private Cliente selected = null;

	public static void main(String[] args) {
		try {
			ShowClients dialog = new ShowClients();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ShowClients() {
		setBounds(100, 100, 581, 345);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String[] headers = {"CEDULA","NOMBRE", "DIRECCION", "CELULAR"};

					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int ind = table.getSelectedRow();
							if (ind >= 0 ) {
								btnDelete.setEnabled(true);
								String cedula = table.getValueAt(ind, 0).toString();
								selected = Tienda.getInstance().ClienteByCedula(cedula);
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);

					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table.setModel(model);
				}
			}
		}
		contentPanel.add(lblListadoDeClientes, BorderLayout.NORTH);
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
				            Tienda.getInstance().eliminarCliente(selected);
				            loadClientes(0);
				            JOptionPane.showMessageDialog(null, "Cliente eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
				        }
				    }
				});
				buttonPane.add(btnDelete);
			}

			{
				btnsalir = new JButton("SALIR");
				btnsalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				btnsalir.setActionCommand("Cancel");
				buttonPane.add(btnsalir);
			}
		}
		loadClientes(0);
	}

	public static void loadClientes(int index) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		if(index == 0){
			for (Cliente aux : Tienda.getInstance().getMisClientes()) {
				if(aux != null){	
					rows[0] = aux.getCedula();
					rows[1] = aux.getNombre();
					rows[2] = aux.getDireccion();
					rows[3] = aux.getTelefono();
					model.addRow(rows);
				}
			}
		}


	}

}