package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;

public class MAIN extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  Dimension dim;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN frame = new MAIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MAIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(200, 100, 200, 100));
		menuBar.setFont(new Font("SansSerif", Font.BOLD, 15));
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);


		JMenu mnproducts = new JMenu("PRODUCTS");
		menuBar.add(mnproducts);

		JMenuItem mntinsertproducts = new JMenuItem("Insert Products");
		mntinsertproducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertProducts regC = new InsertProducts();
				regC.setModal(true);
				regC.setVisible(true);
			}
		});
		mnproducts.add(mntinsertproducts);

		JMenuItem mntproducts = new JMenuItem("Products");
		mntproducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowProducts list = new ShowProducts();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnproducts.add(mntproducts);
		JMenu nnsales = new JMenu("SALES");
		menuBar.add(nnsales);

		JMenuItem mntsales = new JMenuItem("Sale");
		mntsales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakeSales factura = new MakeSales();
				factura.setModal(true);
				factura.setVisible(true);
			}
		});
		nnsales.add(mntsales);

		JMenuItem mnsales = new JMenuItem("Sales");
		mnsales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowSales list = new ShowSales();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		nnsales.add(mnsales);

		JMenu menuclients = new JMenu("CLIENTS");
		menuBar.add(menuclients);



		JMenuItem menuClients = new JMenuItem("Clients");
		menuClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowClients list = new ShowClients();
				list.setModal(true);
				list.setVisible(true);

			}
		});
		menuclients.add(menuClients);

		JMenuItem mntinsertclient = new JMenuItem("Insert Clients");
		mntinsertclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertClients reg = new InsertClients(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		menuclients.add(mntinsertclient);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagen = new JLabel("New label");
		lblImagen.setIcon(new ImageIcon("C:\\foto\\desktop-wallpaper-hi-tech-for-and-laptops-1920\u00D71080-technical-technical.jpg"));
		lblImagen.setBounds(57, 13, 856, 620);
		contentPane.add(lblImagen);
		
		JLabel lblasda = new JLabel("New label");
		lblasda.setIcon(new ImageIcon("C:\\foto\\desktop-wallpaper-hi-tech-for-and-laptops-1920\u00D71080-technical-technical.jpg"));
		lblasda.setBounds(901, 35, 848, 576);
		contentPane.add(lblasda);
	}
}

