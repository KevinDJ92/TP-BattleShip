package views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.GameController;
import enumeration.AIStrategy;
import enumeration.TypeDeJeu;

public class MenuWindow extends JFrame {

	private JTextField textField;
	private JTextField textField2;
	private String username;
	private AIStrategy niveau;
	private GameController BattleShip;
	private boolean start;
	private TypeDeJeu typeDeJeu;
	private String adrIP;

	public MenuWindow() {

		setSize(450, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel titreJeu = new JLabel("BATTLESHIP");
		titreJeu.setHorizontalAlignment(SwingConstants.CENTER);
		titreJeu.setFont(new Font("Serif", Font.PLAIN, 41));
		titreJeu.setBounds(10, 11, 414, 50);
		panel.add(titreJeu);

		JLabel namePlayer = new JLabel("Entrer votre nom");
		namePlayer.setFont(new Font("Serif", Font.PLAIN, 14));
		namePlayer.setHorizontalAlignment(SwingConstants.CENTER);
		namePlayer.setBounds(134, 81, 152, 31);
		panel.add(namePlayer);

		textField = new JTextField();
		textField.setBounds(134, 109, 152, 31);
		textField.setText("Joueur");
		panel.add(textField);
		textField.setColumns(10);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(134, 238, 152, 31);
		comboBox_1.addItem("Niveau : RANDUMB");
		comboBox_1.addItem("Niveau : AI NORMAL");
		comboBox_1.addItem("Niveau : AI ADVANCED");
		panel.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(134, 172, 152, 31);
		comboBox_2.addItem("Joueur vs AI");
		comboBox_2.addItem("Server");
		comboBox_2.addItem("Client");
		panel.add(comboBox_2);
		
		JLabel adresseIP = new JLabel("Entrer adresse IP du server");
		adresseIP.setFont(new Font("Serif", Font.PLAIN, 14));
		adresseIP.setHorizontalAlignment(SwingConstants.CENTER);
		adresseIP.setBounds(4, 268, 414, 50);
		panel.add(adresseIP);
		
		textField2 = new JTextField();
		textField2.setBounds(134, 314, 152, 31);
		textField2.setText("192.168.0.0");
		panel.add(textField2);
		textField2.setColumns(10);
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(134, 370, 152, 50);
		panel.add(btnStart);

		JButton btnQuit = new JButton("QUIT");
		btnQuit.setBounds(134, 436, 152, 50);
		panel.add(btnQuit);

		setContentPane(panel);
		setVisible(true);

		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				username = textField.getText();
				adrIP = textField2.getText();

				String item = comboBox_1.getSelectedItem().toString();
				if (item == "Niveau : RANDUMB") {
					niveau = AIStrategy.RANDUMB;
				} else if (item == "Niveau : AI NORMAL") {
					niveau = AIStrategy.HIT_SEARCH;
				} else if (item == "Niveau : AI ADVANCED") {
					niveau = AIStrategy.HIT_SEARCH2;
				}
				
				String item2 = comboBox_2.getSelectedItem().toString();
				if (item2 == "Joueur vs AI") {
					typeDeJeu = TypeDeJeu.JoueurAI;
				} else if (item2 == "Server") {
					typeDeJeu = TypeDeJeu.Serveur;
				} else if (item2 == "Client") {
					typeDeJeu = TypeDeJeu.Client;
				}
				
				System.out.println(niveau);
				System.out.println(username);

				setVisible(false);
				start = true;

			}
		});

		btnQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AIStrategy getNiveau() {
		return niveau;
	}

	public void setNiveau(AIStrategy niveau) {
		this.niveau = niveau;
	}

	public TypeDeJeu getTypeDeJeu() {
		return typeDeJeu;
	}

	public void setTypeDeJeu(TypeDeJeu typeDeJeu) {
		this.typeDeJeu = typeDeJeu;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public String getAdrIP() {
		return adrIP;
	}
	
}
