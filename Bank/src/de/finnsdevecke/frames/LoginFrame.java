package de.finnsdevecke.frames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import de.finnsdevecke.mainclasses.DBConnect;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private String username;

	private String kontonummer;
	private char[] pn;

	private int width = 400;
	private int height = 300;

	// Erzeugung der Login "seiten";
	private JPanel userLogin;
	private JPanel adminLogin;

	// Erzeugung der Buttons;
	private JButton login_1;
	private JButton login;

	// Erzeugen der Passwortfelder;
	private JPasswordField passwdField_1;
	private JPasswordField passwdField;

	// Erzeugen der "username" felder;
	private JTextField usernmField_1;
	private JTextField usernmField;

	// Erzeugung von tabpane;
	private JTabbedPane tabpane;
	private DBConnect connection;

	UserPanel usrPanel = new UserPanel();

	public LoginFrame() {
		this.connection = new DBConnect();
		this.setTitle("LoginGUI");
		this.setSize(width, height);

		tabpane = new JTabbedPane();
		getContentPane().add(tabpane);

		adminLogin = new JPanel();
		tabpane.addTab("Admin", adminLogin);

		userLogin = new JPanel();
		tabpane.addTab("User", userLogin);

		login_1 = new JButton("Login");
		login_1.setBounds(150, 190, 70, 30);
		// Login 1
		login_1.addActionListener(e -> {
			pn = passwdField_1.getPassword();
			kontonummer = usernmField_1.getText();
			String pin = new String(pn);
			System.out.println(pin + " - " + kontonummer);
			String sql = "SELECT * FROM kontodaten WHERE Kontonummer=? AND Pinnummer=?";
			PreparedStatement ps;
			ResultSet rs = null;
			Connection connect = null;
			try {
				connect = connection.connect();
				connect.setAutoCommit(false);
				ps = connect.prepareStatement(sql);
				ps.setString(1, kontonummer);
				ps.setString(2, pin);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("Success");
					this.setVisible(false);
					usrPanel.setVisible(true);
					// Aktionen...

				} else {
					System.out.println("Fail.");
				}
			} catch (Exception ex) {
				System.out.println("Error");
				ex.printStackTrace();
			} finally {
				if (connect != null) {
					try {
						if (rs != null) {
							rs.close();
						}
						connect.setAutoCommit(true);
						connect.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		// ENDE
		userLogin.setLayout(null);
		userLogin.add(login_1);

		login = new JButton("Login");
		login.setMnemonic('l');
		login.setBounds(150, 190, 70, 30);
		// login 2
		login.addActionListener(e -> {
			char[] passwd = passwdField.getPassword();
			username = usernmField.getText();
			String password = new String(passwd);
			System.out.println(password + " " + username);
			String sql = "SELECT * FROM admin WHERE Nutzername=? AND Passwort=?";
			PreparedStatement ps;
			ResultSet rs = null;
			Connection connect = null;
			try {
				connect = connection.connect();
				connect.setAutoCommit(false);
				ps = connect.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("Success");
					// Aktionen...
				} else {
					System.out.println("Fail.");
				}
			} catch (Exception ex) {
				System.out.println("Error");
				ex.printStackTrace();
			} finally {
				if (connect != null) {
					try {
						if (rs != null) {
							rs.close();
						}
						connect.setAutoCommit(true);
						connect.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		// Ende
		adminLogin.setLayout(null);

		usernmField = new JTextField("Username");
		adminLogin.add(usernmField);
		usernmField.setBounds(150, 80, 70, 20);

		passwdField = new JPasswordField("Passwort");
		adminLogin.add(passwdField);
		passwdField.setBounds(150, 120, 70, 20);
		adminLogin.add(login);

		usernmField_1 = new JTextField("Kontonummer");
		usernmField_1.setBounds(150, 80, 70, 20);
		userLogin.add(usernmField_1);

		passwdField_1 = new JPasswordField("Passwort");
		passwdField_1.setBounds(150, 120, 70, 20);
		userLogin.add(passwdField_1);
	}
}
