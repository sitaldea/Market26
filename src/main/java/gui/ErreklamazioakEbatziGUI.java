package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import businessLogic.BLFacade;
import domain.Erreklamazioak;
import domain.Erabiltzailea;
import domain.User;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErreklamazioakEbatziGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userMail;

	private List<Erreklamazioak> reclamList;
	private int currentIndex = 0;

	private JLabel lblTitle;
	private JLabel lblDescription;
	private JLabel lblImage;
	private JButton btnPrev;
	private JButton btnNext;
	private JButton btnEbatzi;


	/**
	 * Create the frame.
	 */
	public ErreklamazioakEbatziGUI(String email) {
		this.userMail = email;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle(userMail);

		lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(20, 20, 540, 25);
		contentPane.add(lblTitle);

		lblDescription = new JLabel(" ");
		lblDescription.setBounds(20, 60, 540, 80);
		contentPane.add(lblDescription);

		lblImage = new JLabel();
		lblImage.setBounds(20, 150, 160, 160);
		contentPane.add(lblImage);

		btnPrev = new JButton("<");
		btnPrev.setBounds(200, 220, 60, 30);
		contentPane.add(btnPrev);

		btnNext = new JButton(">");
		btnNext.setBounds(270, 220, 60, 30);
		contentPane.add(btnNext);

		btnEbatzi = new JButton("Ebatzi");
		btnEbatzi.setBounds(360, 220, 100, 30);
		contentPane.add(btnEbatzi);

		BLFacade facade = MainGUI.getBusinessLogic();
		reclamList = new ArrayList<>();
		if (facade != null) {
			java.util.List<Erreklamazioak> all = facade.getErreklamazioakByEgoera("Deuseztatu");
			if (all != null) reclamList.addAll(all);
		}

		if (reclamList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ez dago 'Deuseztatu' egoerako erreklamaziorik.", "Info", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			return;
		}

		updateView();

		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentIndex > 0) {
					currentIndex--;
					updateView();
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentIndex < reclamList.size() - 1) {
					currentIndex++;
					updateView();
				}
			}
		});

		btnEbatzi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Erreklamazioak erre = reclamList.get(currentIndex);
				BLFacade f = MainGUI.getBusinessLogic();
				f.updateEgoeraErreklamazioa(erre, "Ebatzita");
				updateView();
				JOptionPane.showMessageDialog(ErreklamazioakEbatziGUI.this, "Erreklamazioa ebatzita.", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});

	}

	private void updateView() {
		if (reclamList == null || reclamList.isEmpty()) return;
		Erreklamazioak r = reclamList.get(currentIndex);
		lblTitle.setText((currentIndex+1) + "/" + reclamList.size() + " - " + r.getIzenburua());
		lblDescription.setText("<html>" + r.getDeskripzioa() + "</html>");
		lblImage.setIcon(null);
		if (r.getIrudia() != null && !r.getIrudia().isEmpty()) {
			BLFacade f = MainGUI.getBusinessLogic();
			if (f != null) {
				Image img = f.downloadImage(r.getIrudia());
				if (img != null) {
					lblImage.setIcon(new ImageIcon(img.getScaledInstance(160, 160, Image.SCALE_SMOOTH)));
				}
			}
		}
		btnPrev.setEnabled(currentIndex > 0);
		btnNext.setEnabled(currentIndex < reclamList.size() - 1);
	}

}