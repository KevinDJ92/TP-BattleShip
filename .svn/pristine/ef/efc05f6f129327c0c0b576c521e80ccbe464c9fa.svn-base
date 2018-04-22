package views.principals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import event.PanelEvent;
import listeners.IThreadListener;

public class ChatPanel extends JPanel implements IThreadListener {
	
	private static final long serialVersionUID = 1L;

	JLabel textIn, textOut;
	String msgChat = "msgChat";
	JTextField messageBox;
	JTextArea affichageChat;
	
	JButton sendMessage;
	String username;

	Border blackline = BorderFactory.createLineBorder(Color.black);
	
	public ChatPanel(String username) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// elements du boxChat
		textIn = new JLabel();
		textIn.setText("Entrer votre texte : ");
		textIn.setHorizontalAlignment(SwingConstants.LEFT);
		add(textIn);
		
		messageBox = new JTextField();
		messageBox.setPreferredSize(new Dimension(700, 50));
		messageBox.setFont(new Font("Serif", Font.PLAIN, 15));
		messageBox.setBorder(blackline);
		add(messageBox);

		sendMessage = new JButton("Send Message");
		add(sendMessage);
		sendMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (messageBox.getText().length() < 1) {
					// do nothing
				} 

				else {
					affichageChat.append(username + " : " + messageBox.getText() + "\n");
					messageBox.setText("");
				}
			}
		});

		textOut = new JLabel();
		textOut.setText("Affichage du Chat : ");
		add(textOut);
		
		affichageChat = new JTextArea();
		//affichageChat.setFocusable(false);
		JScrollPane scrollPane = new JScrollPane(affichageChat);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(700, 200));
		scrollPane.setBorder(blackline);
		scrollPane.setFont(new Font("Serif", Font.PLAIN, 15));
		
		add(scrollPane);
		
	}
	
	@Override
	public void ilYAUnMessage(PanelEvent e) {
		System.out.println("Entered IlYAUneMessage!!!");
		System.out.println("message: " + e.getMsg());
		
		String msg = e.getMsg();
		
		msg = msg.substring(msgChat.length());
		
		this.affichageChat.append("" + e.getMsg() + "\n");		
	}
	
	@Override
	public void afficherCoord(PanelEvent e) {
		
	}
	
	public JLabel getTextIn() {
		return textIn;
	}

	public void setTextIn(JLabel textIn) {
		this.textIn = textIn;
	}

	public JLabel getTextOut() {
		return textOut;
	}

	public void setTextOut(JLabel textOut) {
		this.textOut = textOut;
	}

	public JTextField getMessageBox() {
		return messageBox;
	}

	public void setMessageBox(JTextField messageBox) {
		this.messageBox = messageBox;
	}

	public JTextArea getAffichageChat() {
		return affichageChat;
	}

	public void setAffichageChat(JTextArea affichageChat) {
		this.affichageChat = affichageChat;
	}

	public JButton getSendMessage() {
		return sendMessage;
	}

	public void setSendMessage(JButton sendMessage) {
		this.sendMessage = sendMessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
