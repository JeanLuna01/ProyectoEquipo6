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
import logico.Factura;
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
import java.awt.Color;

public class ShowSales extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private final JLabel lblListadoDeClientes = new JLabel("Listado de Facturas:");

	private JButton btnDelete;
	private JButton btnCancelar;
	private Factura selected = null;

	public static void main(String[] args) {
		try {
			ShowSales dialog = new ShowSales();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ShowSales() {
		setResizable(false);
		setBounds(100, 100, 822, 479);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 37, 768, 283);
				panel.add(scrollPane);
				{
					String[] headers = {"ID Factura", "Nombre Cliente","Total"};

					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int ind = table.getSelectedRow();
							if (ind >= 0 ) {
								btnDelete.setEnabled(true);
								String codigoFactura = table.getValueAt(ind, 0).toString();
								selected = Tienda.getInstance().getFacturaByCodigo(codigoFactura);
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
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 339, 794, 38);
			panel.add(buttonPane);
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				

				JButton btnCancelar_1 = new JButton("CANCELAR");
				btnCancelar_1.setForeground(new Color(0, 0, 0));
				btnCancelar_1.setBackground(Color.WHITE);
				btnCancelar_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnDelete = new JButton("ELIMINAR");
				btnDelete.setForeground(new Color(0, 0, 0));
				btnDelete.setBackground(Color.WHITE);
				btnDelete.setEnabled(false);
				btnDelete.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        if (selected != null) {
				            Tienda.getInstance().eliminarFactura(selected);
				            JOptionPane.showMessageDialog(null, "Factura Eliminada: " + selected, "Información", JOptionPane.INFORMATION_MESSAGE);
				            loadClientes();
				        }
				    }
				});

					buttonPane.add(btnDelete);
				
					btnCancelar_1.setActionCommand("Cancel");
					buttonPane.add(btnCancelar_1);
			}
		}
		lblListadoDeClientes.setBackground(new Color(255, 255, 255));
		contentPanel.add(lblListadoDeClientes, BorderLayout.NORTH);
		{

			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
			}
		}
		loadClientes();
	}

	public static void loadClientes() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Factura aux : Tienda.getInstance().getMisFacturas()) {
			if(aux != null){
				rows[0] = aux.getCodigo();
				rows[1] = aux.getCliente().getNombre();
				rows[2] = aux.getPrecioTotal();
				model.addRow(rows);
			}
		}
	}
	public static void loadFacturas(String codigoFactura, String cedulaCliente) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];

		for (Factura aux : Tienda.getInstance().getMisFacturas()) {
			if (aux != null) {
				if (codigoFactura.isEmpty() || aux.getCodigo().equals(codigoFactura)) {
					Cliente cliente = aux.getCliente();
					if (cedulaCliente.isEmpty() || cliente.getCedula().equals(cedulaCliente)) {
						rows[0] = aux.getCodigo();
						rows[1] = aux.getCliente().getNombre();
						rows[2] = aux.getPrecioTotal();
						model.addRow(rows);
					}
				}
			}
		}
	}
}
