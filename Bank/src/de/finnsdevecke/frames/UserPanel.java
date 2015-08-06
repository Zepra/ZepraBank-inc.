package de.finnsdevecke.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class UserPanel extends JFrame {
	private static final long serialVersionUID = 4637141754914534495L;
	private JFrame frame1;

	private JTabbedPane tabpane;

	private JPanel ktoInfo;
	private JPanel auszahlen;
	private JPanel einzahlen;
	private JPanel pinaendern;

	private JLabel kontostand;

	public UserPanel() {

		this.setTitle("UserPanel:.:.");
		this.setSize(700, 500);

		tabpane = new JTabbedPane();
		getContentPane().add(tabpane);

		ktoInfo = new JPanel();
		tabpane.addTab("Info", ktoInfo);
		auszahlen = new JPanel();
		tabpane.addTab("auszahlen", auszahlen);
		einzahlen = new JPanel();
		tabpane.addTab("einzahlen", einzahlen);
		pinaendern = new JPanel();
		tabpane.addTab("Pin ändern", pinaendern);

		kontostand = new JLabel();
		kontostand.setText("Ihr momentaner Kontostand: " + "N/A");

		ktoInfo.add(kontostand);

	}
}
