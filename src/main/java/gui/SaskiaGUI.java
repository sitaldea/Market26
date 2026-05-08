package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import businessLogic.BLFacade;
import domain.Sale;
import domain.Saskia;
import domain.User;

public class SaskiaGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userMail;
	int i;

	private JList<String> listProducts;
	private DefaultListModel<String> listModel;
	private JLabel lblTotal;
	private Saskia s;


	/**
	 * Create the frame.
	 */
	public SaskiaGUI(String mail, int i) {
		this.userMail = mail;
		this.i = i;
		BLFacade facade = MainGUI.getBusinessLogic();
		User user = facade.getUserAccounts(userMail);
		s = user.getSaskiak().get(i);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 502, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle(userMail + " - Saskia " + i);

		listModel = new DefaultListModel<>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 300, 225);
		contentPane.add(scrollPane);
		listProducts = new JList<>(listModel);
		scrollPane.setViewportView(listProducts);

		lblTotal = new JLabel("Total: 0.00");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(12, 259, 300, 30);
		contentPane.add(lblTotal);

		JButton btnItxi = new JButton(ResourceBundle.getBundle("Etiquetas").getString("OfertaSortuGUI.btnClose"));
		btnItxi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnItxi.setBounds(374, 261, 102, 30);
		btnItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaskiaGUI.this.dispose();
			}
		});
		contentPane.add(btnItxi);

		JButton btnAplicarDesc = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SaskiaGUI.btnAplicarDesc"));
		btnAplicarDesc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAplicarDesc.setBounds(330, 22, 139, 40);
		btnAplicarDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				double prezioTotalaDeskontua = facade.deskontuaAplikatu(s.getPrezioTotala(), s.getPruduktuak().size());
				lblTotal.setText(ResourceBundle.getBundle("Etiquetas").getString("SaskiaGUI.prezioTotala") + "" + prezioTotalaDeskontua + "€");
			}
		});
		contentPane.add(btnAplicarDesc);

		JButton btnComprar = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SaskiaGUI.btnComprar"));
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnComprar.setBounds(330, 77, 139, 40);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				try {
					for (Sale sale : s.getPruduktuak()) {
						facade.buyProduct(sale, userMail);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(SaskiaGUI.this, "Error al cambiar de cesta: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		contentPane.add(btnComprar);
		
		JButton btnSaleGehiago = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SaskiaGUI.btnSaleGehiago"));
		btnSaleGehiago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSaleGehiago.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaleGehiago.setBounds(330, 134, 139, 40);
		contentPane.add(btnSaleGehiago);
		
		JButton btnDelete = new JButton(ResourceBundle.getBundle("Etiquetas").getString("SaskiaGUI.delete")); 
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedIndex = listProducts.getSelectedIndex();
				if (selectedIndex != -1) {
					BLFacade facade = MainGUI.getBusinessLogic();
					Sale selectedSale = s.getPruduktuak().get(selectedIndex);
					facade.removeProduktuaSaskitik(selectedSale, i, userMail);
					loadSaskiaContents();
				} else {
					JOptionPane.showMessageDialog(SaskiaGUI.this, "Mesedez produktu bat hautatu");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(330, 186, 139, 40);
		contentPane.add(btnDelete);

		loadSaskiaContents();
	}

	private void loadSaskiaContents() {
		BLFacade facade = MainGUI.getBusinessLogic();
		User user = facade.getUserAccounts(userMail);
		Saskia saskia = null;
		listModel.clear();
		double total = 0.0;
		if (user != null && user.getSaskiak() != null && user.getSaskiak().size() > i) {
			saskia = user.getSaskiak().get(i);
			if (saskia != null && saskia.getPruduktuak() != null) {
				List<Sale> products = saskia.getPruduktuak();
				for (Sale s : products) {
					String name = s.getTitle();
					listModel.addElement(name);
					total += s.getPrice();
				}
			}
		}
		lblTotal.setText(ResourceBundle.getBundle("Etiquetas").getString("SaskiaGUI.prezioTotala") + "" + saskia.getPrezioTotala() + "€");
	}
}