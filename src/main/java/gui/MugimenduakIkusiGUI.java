package gui;

import java.awt.Font;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLogic.BLFacade;
import domain.DiruKontua;
import domain.Mugimenduak;
import domain.User;

public class MugimenduakIkusiGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userMail;
	private JComboBox<String> comboBoxKontuak;
	private JTable table;
	private DefaultTableModel tableModel;



	/**
	 * Create the frame.
	 */
	public MugimenduakIkusiGUI(String email) {
		this.userMail = email;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle(userMail);

		JLabel lblKontuak = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("BuyProductGUI.kontu"));
		lblKontuak.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKontuak.setBounds(10, 20, 120, 20);
		contentPane.add(lblKontuak);

		comboBoxKontuak = new JComboBox<String>();
		comboBoxKontuak.setBounds(140, 20, 280, 22);
		contentPane.add(comboBoxKontuak);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 410, 180);
		contentPane.add(scrollPane);

		tableModel = new DefaultTableModel(new Object[] { "Date", "Amount", "Product", "Type" }, 0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);

		JButton btnClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));
		btnClose.setBounds(160, 250, 120, 33);
		btnClose.addActionListener(e -> dispose());
		contentPane.add(btnClose);

		BLFacade facade = MainGUI.getBusinessLogic();
		if (facade == null) {
			return;
		}

		User user = facade.getUserAccounts(userMail);
		if (user != null && user.getKontuak() != null) {
			for (DiruKontua k : user.getKontuak()) {
				comboBoxKontuak.addItem(k.getKontuZenb());
			}
		}

		comboBoxKontuak.addActionListener(e -> loadMovementsForSelected(facade, user));

		if (comboBoxKontuak.getItemCount() > 0) {
			comboBoxKontuak.setSelectedIndex(0);
			loadMovementsForSelected(facade, user);
		}
		setVisible(true);
	}

	private void loadMovementsForSelected(BLFacade facade, User user) {
		if (user == null) return;
		String selected = (String) comboBoxKontuak.getSelectedItem();
		if (selected == null) return;

		DiruKontua selectedK = null;
		for (DiruKontua k : user.getKontuak()) {
			if (k.getKontuZenb().equals(selected)) {
				selectedK = k;
				break;
			}
		}		tableModel.setRowCount(0);
		if (selectedK == null) return;

		List<Mugimenduak> mugimenduak = selectedK.getMugimenduak();
		if (mugimenduak == null || mugimenduak.isEmpty()) return;

		for (Mugimenduak m : mugimenduak) {
			tableModel.addRow(new Object[] { m.getData(), m.getDiruKop(), m.getProductName(), m.getMota() });
		}
	}

}