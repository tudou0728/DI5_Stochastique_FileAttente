package interfaceFA;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.KeyEvent;

import calcul.MM1;
import calcul.MM1K;
import calcul.MMS;

public class FAInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textClients;
	private JTextField textService;
	private JTextField textServeurs;
	private JTextField textClientLimit;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	        }
	    }
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FAInterface frame = new FAInterface();
						frame.setTitle(" Processus Stochastique - File d'attente");
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}

	/**
	 * Create the frame.
	 */
	public FAInterface() {
		setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCalculer = new JButton("Calculer");
		btnCalculer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		btnCalculer.setBounds(540, 298, 103, 36);
		contentPane.add(btnCalculer);
		
		JButton btnNettoyer = new JButton("Nettoyer");
		btnNettoyer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		btnNettoyer.setBounds(759, 298, 103, 36);
		contentPane.add(btnNettoyer);
		
		JLabel lblNBClients = new JLabel("Nombre de clients:");
		lblNBClients.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblNBClients.setBounds(25, 89, 197, 42);
		contentPane.add(lblNBClients);
		
		JLabel lblNBService = new JLabel("Nombre de services:");
		lblNBService.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblNBService.setBounds(28, 158, 175, 38);
		contentPane.add(lblNBService);
		
		JLabel lblNBServeurs = new JLabel("Nombre de serveurs:");
		lblNBServeurs.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblNBServeurs.setBounds(25, 230, 197, 44);
		contentPane.add(lblNBServeurs);
		
		JLabel lblNBClientLimit = new JLabel("Nombre de clients limites:");
		lblNBClientLimit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblNBClientLimit.setBounds(25, 289, 222, 42);
		contentPane.add(lblNBClientLimit);
		
		JComboBox comboBoxMode = new JComboBox();
		comboBoxMode.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		comboBoxMode.setBounds(244, 37, 154, 42);
		comboBoxMode.addItem("M/M/1");
		comboBoxMode.addItem("M/M/S");
		comboBoxMode.addItem("M/M/1/K");
		contentPane.add(comboBoxMode);
		
		textClients = new JTextField();
		textClients.setFont(new Font("Arial", Font.BOLD, 15));
		textClients.setBounds(244, 91, 154, 42);
		contentPane.add(textClients);
		textClients.setColumns(10);

		
		textService = new JTextField();
		textService.setFont(new Font("Arial", Font.BOLD, 15));
		textService.setBounds(244, 157, 154, 44);
		contentPane.add(textService);
		textService.setColumns(10);
		
		textServeurs = new JTextField();
		textServeurs.setFont(new Font("Arial", Font.BOLD, 15));
		textServeurs.setBounds(244, 232, 154, 44);
		contentPane.add(textServeurs);
		textServeurs.setColumns(10);
		
		textClientLimit = new JTextField();
		textClientLimit.setFont(new Font("Arial", Font.BOLD, 15));
		textClientLimit.setBounds(244, 296, 154, 44);
		contentPane.add(textClientLimit);
		textClientLimit.setColumns(10);
		
		JLabel lblKendall = new JLabel("Choisissez Kendall:");
		lblKendall.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblKendall.setBounds(25, 40, 197, 36);
		contentPane.add(lblKendall);
		
		JTextArea textAreaResultat = new JTextArea();
		textAreaResultat.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		textAreaResultat.setBounds(494, 48, 400, 215);
		contentPane.add(textAreaResultat);
		textAreaResultat.setEditable(false);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 782, 27);
		contentPane.add(menuBar);
		
		JMenu mnMenuFichier = new JMenu("Fichier");
		mnMenuFichier.setFont(new Font("Times New Roman", Font.BOLD, 15));
		menuBar.add(mnMenuFichier);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmQuitter.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_ESCAPE));
		mntmQuitter.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnMenuFichier.add(mntmQuitter);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Times New Roman", Font.BOLD, 15));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About...");
		mntmAbout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnHelp.add(mntmAbout);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(14, 347, 880, 263);
		ImageIcon imageIcon1=new ImageIcon("src\\1.jpg");
		imageIcon1.setImage(imageIcon1.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT));
		ImageIcon imageIcon2=new ImageIcon("src\\2.gif");
		imageIcon2.setImage(imageIcon2.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT));
		ImageIcon imageIcon3=new ImageIcon("src\\3.gif");
		imageIcon3.setImage(imageIcon3.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_DEFAULT));
		lblImage.setIcon(imageIcon3);
		contentPane.add(lblImage);
		
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel labelInformation=new JLabel("<html><body>Développeur :<br> &nbsp; ABULIMII Alafate (Polytech Tours, DI5) - Backend<br> &nbsp; LI Yuanyuan (Polytech Tours, DI5) - Frontend <br><br> Images Sources:<br> &nbsp; Google Image</body></html>");
				labelInformation.setFont(new Font("Times New Roman", Font.BOLD, 15));
				ImageIcon imageIcon4=new ImageIcon("src\\4.png");
				imageIcon4.setImage(imageIcon4.getImage().getScaledInstance(400, 120, Image.SCALE_DEFAULT));
				labelInformation.setIcon(imageIcon4);
				JOptionPane.showConfirmDialog(null, labelInformation,"Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		comboBoxMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxMode.getSelectedIndex()==0) {
					textServeurs.setText("1");
					textServeurs.setEditable(false);
					textClientLimit.setText("∞");
					textClientLimit.setEditable(false);
					lblImage.setIcon(imageIcon3);
				}
				else if (comboBoxMode.getSelectedIndex()==1) {
					textClientLimit.setText("∞");
					textClientLimit.setEditable(false);
					textServeurs.setEditable(true);
					lblImage.setIcon(imageIcon2);
				}
				else {
					textServeurs.setText("1");
					textServeurs.setEditable(false);
					textClientLimit.setEditable(true);
					lblImage.setIcon(imageIcon1);
				}
			}
		});
		comboBoxMode.setSelectedIndex(0);
		
		btnNettoyer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaResultat.setText("");
				textClients.setText("");
				textService.setText("");
				if(textServeurs.isEditable()) {
					textServeurs.setText("");
				}
				if(textClientLimit.isEditable()) {
					textClientLimit.setText("");
				}
			}
		});
		
		btnCalculer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					textAreaResultat.setText("");
					if(comboBoxMode.getSelectedIndex()==0) {
						if((Double.valueOf(textClients.getText())<=0) || (Double.valueOf(textService.getText())<=0) ) {
							JOptionPane.showConfirmDialog(null, "Tous les entrées doivent > 0 !", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR);
						}
						else if ((Double.valueOf(textClients.getText()) / Double.valueOf(textService.getText()))>1) {
							JOptionPane.showConfirmDialog(null, "File d'attente sera bloquée", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						}else {
							List<String> result=resultatMM1(Double.valueOf(textClients.getText()), Double.valueOf(textService.getText()));
							String message="Nombre de clients moyen dans la file: \n"+" "+result.get(1)+"\n"
							+"Nombre de clients moyen dans le système: \n"+" "+result.get(0)+"\n"
									+"Temps moyen dans la file:\n"+" "+result.get(3)+"\n"
							+"Temps moyen dans le système: \n"+" "+result.get(2)+"\n";
							textAreaResultat.setText(message);
						}
					}
					else if (comboBoxMode.getSelectedIndex()==1) {
						if((Double.valueOf(textClients.getText())<=0) || (Double.valueOf(textService.getText())<=0) || (Double.valueOf(textServeurs.getText())<=0)) {
							JOptionPane.showConfirmDialog(null, "Tous les entrées doivent > 0 !", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR);
						}
						else if((Double.valueOf(textClients.getText()) / (Double.valueOf(textService.getText()) * Double.valueOf(textServeurs.getText()))) >1) {
							JOptionPane.showConfirmDialog(null, "File d'attente sera bloquée", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						}else {
						List<String> result=resultatMMS(Double.valueOf(textClients.getText()), Double.valueOf(textService.getText()),Double.valueOf(textServeurs.getText()));
						String message="Nombre de clients moyen dans la file: \n"+""+result.get(1)+"\n"
						+"Nombre de clients moyen dans le système: \n"+" "+result.get(0)+"\n"
								+"Temps moyen dans la file: \n"+" "+result.get(3)+"\n"
						+"Temps moyen dans le système: \n"+" "+result.get(2)+"\n";
						textAreaResultat.setText(message);
						}
					}else {
						if((Double.valueOf(textClients.getText())<=0) || (Double.valueOf(textService.getText())<=0) || (Double.valueOf(textClientLimit.getText())<=0)) {
							JOptionPane.showConfirmDialog(null, "Tous les entrées doivent > 0 !", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR);
						}
						else if((Double.valueOf(textClients.getText()) / Double.valueOf(textService.getText()))>1) {
							JOptionPane.showConfirmDialog(null, "File d'attente sera bloquée", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						}else {
							List<String> result=resultatMM1K(Double.valueOf(textClients.getText()), Double.valueOf(textService.getText()),Double.valueOf(textClientLimit.getText()));
						String message="Nombre de clients moyen dans la file: \n"+" "+result.get(0)+"\n"
						+"Nombre de clients moyen dans le système: \n"+" "+result.get(1)+"\n"
								+"Temps moyen dans la file: \n"+" "+result.get(2)+"\n"
						+"Temps moyen dans le système: \n"+" "+result.get(3)+"\n";
						textAreaResultat.setText(message);
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showConfirmDialog(null, "Tous les entrées doivent être numérique !", "Error Warning", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	private List<String> resultatMM1(double client, double service){
		MM1 calculate=new MM1(service, client);
		double l=calculate.calculerL();
		double lq=calculate.calculerLq();
		double w=calculate.calculerW();
		double wq=calculate.calculerWq();
		List<String> result=new ArrayList<>();
		result.add(Double.toString(l));
		result.add(Double.toString(lq));
		result.add(Double.toString(w));
		result.add(Double.toString(wq));
		return result;
		
	}
	
	private List<String> resultatMM1K(double client,double service,double clientLimit){
		MM1K calculate=new MM1K(service, client, clientLimit);
		double l=calculate.calculerL();
		double lq=calculate.calculerLq();
		double w=calculate.calculerW();
		double wq=calculate.calculerWq();
		List<String> result=new ArrayList<>();
		result.add(Double.toString(l));
		result.add(Double.toString(lq));
		result.add(Double.toString(w));
		result.add(Double.toString(wq));
		return result;
		
	}
	
	private List<String> resultatMMS(double client,double service,double serveur){
		MMS calculate=new MMS(service, client, serveur);
		double l=calculate.calculerL();
		double lq=calculate.calculerLq();
		double w=calculate.calculerW();
		double wq=calculate.calculerWq();
		List<String> result=new ArrayList<>();
		result.add(Double.toString(l));
		result.add(Double.toString(lq));
		result.add(Double.toString(w));
		result.add(Double.toString(wq));
		return result;
		
	}
}
