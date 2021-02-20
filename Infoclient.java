import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

public class Infoclient extends JFrame {

	private JPanel contentPane;
	private JTextField txtnum;
	JTextPane textPane = new JTextPane();
	String s = "";

	public Infoclient(ArrayList<Client> liste) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter the room number");
		lblNewLabel.setBounds(10, 49, 214, 14);
		contentPane.add(lblNewLabel);

		txtnum = new JTextField();
		txtnum.setBounds(155, 47, 113, 20);
		contentPane.add(txtnum);
		txtnum.setColumns(10);

		JButton btnNewButton = new JButton("Show info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < liste.size(); i++) {

					Client x = liste.get(i);

					if (x.getNumChambre().equals(txtnum.getText())) {

						textPane.setText(x.toString());

					}

				}
				txtnum.setText("");
			}
		});
		btnNewButton.setBounds(280, 45, 139, 23);
		contentPane.add(btnNewButton);

		JButton btnQuitter = new JButton("Quit");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnQuitter.setBounds(216, 184, 89, 23);
		contentPane.add(btnQuitter);

		textPane.setEditable(false);
		textPane.setBounds(10, 75, 580, 103);
		contentPane.add(textPane);
	}
}
