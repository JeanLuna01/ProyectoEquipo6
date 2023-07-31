package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Tienda;

public class InsertClients extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtcel;
    private JTextField txtdireccion;
    private Cliente selected;

    public static void main(String[] args) {
        try {
            InsertClients dialog = new InsertClients(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InsertClients(Cliente cliente) {
        setBounds(100, 100, 467, 293);
        setLocationRelativeTo(null);
        setResizable(false);

        selected = cliente;

        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPanel.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(15, 19, 69, 20);
        panel.add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(81, 14, 146, 30);
        panel.add(txtCedula);
        txtCedula.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(15, 69, 69, 20);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(81, 64, 330, 30);
        panel.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblcel = new JLabel("Celular:");
        lblcel.setBounds(15, 111, 112, 20);
        panel.add(lblcel);

        txtcel = new JTextField();
        txtcel.setBounds(81, 106, 330, 30);
        panel.add(txtcel);
        txtcel.setColumns(10);

        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(15, 157, 112, 20);
        panel.add(lblDireccion);

        txtdireccion = new JTextField();
        txtdireccion.setColumns(10);
        txtdireccion.setBounds(81, 152, 330, 30);
        panel.add(txtdireccion);

        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnregistrar = new JButton("REGISTRAR");
        btnregistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selected == null) {
                    if (!cedulaExistente()) {
                        Cliente c = new Cliente(txtNombre.getText(), txtCedula.getText(), txtdireccion.getText(), txtcel.getText());
                        Tienda.getInstance().registrarCliente(c);
                        JOptionPane.showMessageDialog(null, "Registrado", "Registro de cliente", JOptionPane.INFORMATION_MESSAGE);
                        clean();
                    }
                } else {
                    selected.setNombre(txtNombre.getText());
                    selected.setCedula(txtCedula.getText());
                    selected.setTelefono(txtcel.getText());
                    selected.setDireccion(txtdireccion.getText());
                    ShowClients.loadClientes(0);
                }
              
            }
        });
        btnregistrar.setActionCommand("OK");
        buttonPane.add(btnregistrar);
        getRootPane().setDefaultButton(btnregistrar);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        loadCliente();
    }

    private boolean cedulaExistente() {
        Cliente clienteExistente = Tienda.getInstance().ClienteByCedula(txtCedula.getText());
        if (clienteExistente != null) {
            JOptionPane.showMessageDialog(null, "Cedula registrada", "Registro de cliente", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        return false;
    }

    private void loadCliente() {
        if (selected != null) {
            txtCedula.setText(selected.getCedula());
            txtCedula.setEnabled(false);
            txtNombre.setText(selected.getNombre());
            txtcel.setText(selected.getTelefono());
            txtdireccion.setText(selected.getDireccion());
        }
    }

    protected void clean() {
        txtCedula.setEnabled(true);
        txtCedula.setText("");
        txtNombre.setText("");
        txtcel.setText("");
        txtdireccion.setText("");
    }
}
