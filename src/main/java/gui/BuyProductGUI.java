package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Sale;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ResourceBundle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyProductGUI extends JFrame {

	private static final long serialVersionUID = 1L;
    File targetFile;
    BufferedImage targetImg;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
    private static final int baseSize = 160;
	private static final String basePath="src/main/resources/images/";

	/**
	 * Create the frame.
	 * @param userMail 
	 * @param sale 
	 */
	public BuyProductGUI(Sale sale, String userMail) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(216, 49, 182, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIzKontuZenb = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("BuyProductGUI.kontu"));
		lblIzKontuZenb.setBounds(120, 52, 86, 14);
		contentPane.add(lblIzKontuZenb);
		
		JButton btnErosi = new JButton(ResourceBundle.getBundle("Etiquetas").getString("ShowSaleGUI.Erosi"));
		btnErosi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BLFacade facade = MainGUI.getBusinessLogic();
			}
		});
		btnErosi.setBounds(199, 166, 119, 40);
		contentPane.add(btnErosi);
		
		JPanel panelImage = new JPanel();
		panelImage.setBounds(388, 111, 141, 121);
		contentPane.add(panelImage);
		
		BLFacade facade = MainGUI.getBusinessLogic();
		String file=sale.getFile();
		if (file!=null) {
			Image img=facade.downloadImage(file);
			targetImg = rescale((BufferedImage)img);
			panelImage.setLayout(new BorderLayout(0, 0));
			panelImage.add(new JLabel(new ImageIcon(targetImg))); 
		}
		
		JLabel jLabelPrice = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("QuerySalesGUI.Price"));
		jLabelPrice.setBounds(new Rectangle(6, 166, 101, 20));
		jLabelPrice.setBounds(120, 100, 101, 20);
		contentPane.add(jLabelPrice);
		
		textField_1 = new JTextField();
		textField_1.setText("0.0");
		textField_1.setEditable(false);
		textField_1.setBounds(new Rectangle(137, 166, 60, 20));
		textField_1.setBounds(251, 100, 60, 20);
		contentPane.add(textField_1);
		
		

	}
	
	public BufferedImage rescale(BufferedImage originalImage)
    {
        BufferedImage resizedImage = new BufferedImage(baseSize, baseSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, baseSize, baseSize, null);
        g.dispose();
        return resizedImage;
    }
}
