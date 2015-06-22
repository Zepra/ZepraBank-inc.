package de.finnsdevecke.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public abstract class LoginFrame implements ActionListener {

	public static char[] passwd;
	public static String username;

	public static String kontonummer;
	public static char[] pn;

	public static int width = 400;
	public static int height = 300;

	// Erzeugung vom Fenster;
	public static JFrame frame;

	// Erzeugung der Login "seiten";
	public static JPanel userLogin;
	public static JPanel adminLogin;

	// Erzeugung der Buttons;
	public static JButton login_1;
	public static JButton login;

	// Erzeugen der Passwortfelder;
	public static JPasswordField passwdField_1;
	public static JPasswordField passwdField;

	// Erzeugen der "username" felder;
	public static JTextField usernmField_1;
	public static JTextField usernmField;

	// Erzeugung von tabpane;
	public static JTabbedPane tabpane;

	public static void run() {
		// Frame
		frame = new JFrame("Login-Panel");
		frame.setTitle("LoginGUI");
		frame.setSize(width, height);

		// Buttons;
		login_1 = new JButton("Login");
		login = new JButton("Login");

		// Loginfelder;
		usernmField_1 = new JTextField();
		usernmField = new JTextField();
		passwdField_1 = new JPasswordField();
		passwdField = new JPasswordField();

		usernmField.setText("Username");
		passwdField.setText("Passwort");

		usernmField_1.setText("Kontonummer");
		passwdField_1.setText("Passwort");

		// Userlogin;
		userLogin = new JPanel();
		userLogin.setLayout(null);
		login_1.setBounds(150, 190, 70, 30);
		userLogin.add(login_1);
		usernmField_1.setBounds(139, 70, 100, 20);
		passwdField_1.setBounds(139, 106, 100, 20);
		userLogin.add(usernmField_1);
		userLogin.add(passwdField_1);

		// Adminlogin;
		adminLogin = new JPanel();
		adminLogin.setLayout(null);
		login.setBounds(150, 190, 70, 30);
		usernmField.setBounds(139, 70, 100, 20);
		passwdField.setBounds(139, 106, 100, 20);
		adminLogin.add(login);
		adminLogin.add(usernmField);
		adminLogin.add(passwdField);

		// Hinzufügen zum tabpane;
		tabpane = new JTabbedPane();
		tabpane.addTab("User", userLogin);
		tabpane.addTab("Admin", adminLogin);

		// Tabs zum frame hinzufügen;
		frame.add(tabpane);

		// Anzeigen von Fenster;
		frame.setVisible(true);

		// Loginsystem
		login_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == login_1) {
					passwd = passwdField_1.getPassword();
					username = usernmField_1.getText();
					String password = String.valueOf(passwd);
					System.out.println(password + " - " + username);
				}
			}

		});

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == login) {
					pn = passwdField.getPassword();
					kontonummer = usernmField.getText();
					String pin = String.valueOf(pn);
					System.out.println(pin + " - " + kontonummer);
				}

			}

		});
	}
}
