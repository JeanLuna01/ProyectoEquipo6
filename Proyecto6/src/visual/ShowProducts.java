package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Producto;
import logico.DiscoDuro;
import logico.MemoriaRAM;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ShowProducts extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private static DefaultTableModel model;
    private static Object rows[];
    private JButton btnDelete;
    private JButton btnCancelar;
    private Producto selected = null;

    public static void main(String[] args) {
        try {
        	ShowProducts dialog = new ShowProducts();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ShowProducts() {
        setResizable(false);
        setBounds(100, 100, 852, 345);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(255, 255, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPanel.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));

        JLabel lblcomponentes = new JLabel("Componentes:");
        lblcomponentes.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lblcomponentes);

        table = new JTable(model);
        table.setBackground(new Color(255, 255, 255));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        
        String[] headers = {"ID","MODEL", "STOCK", "PRICE", "KIND OF PRODUCT"};

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int ind = table.getSelectedRow();
				if (ind >= 0 ) {
					btnDelete.setEnabled(true);
					String codigo = table.getValueAt(ind, 0).toString();
					selected = Tienda.getInstance().ComponenteByCodigo(codigo);
				}
			}
		});
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		table.setModel(model);


        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(255, 255, 255));
        buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        btnDelete = new JButton("ELIMINAR");
        btnDelete.setForeground(new Color(0, 0, 0));
        btnDelete.setBackground(Color.WHITE);
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selected != null) {
                    Tienda.getInstance().eliminarProducto(selected);
                    load();
                    JOptionPane.showMessageDialog(null, "Producto eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        buttonPane.add(btnDelete);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(new Color(0, 0, 0));
        btnCancelar.setBackground(Color.WHITE);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setActionCommand("Cancel");
        buttonPane.add(btnCancelar);

        load();
    }

    public static void load() {
        model.setRowCount(0);
        rows = new Object[model.getColumnCount()];
        for (Producto aux : Tienda.getInstance().getMisComponentes()) {
            rows[0] = aux.getId();
            rows[1] = aux.getModelo();
            rows[2] = aux.getCantidadDisp();
            rows[3] = aux.getPrecio();
            if (aux instanceof DiscoDuro) {
                rows[4] = "HardDisk";
            } else if (aux instanceof MemoriaRAM) {
                rows[4] = "RAM";
            } else if (aux instanceof Microprocesador) {
                rows[4] = "Microprocessor";
            } else if (aux instanceof TarjetaMadre) {
                rows[4] = "MotherBoard";
            }
            model.addRow(rows);
        }
    }

}
