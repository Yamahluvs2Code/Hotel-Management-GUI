import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Modifier extends JFrame {

	private JPanel contentPane;
	private JTextField txtfnum;
	private JTextField txtfmodification;

	String[] Options = { "", "Last Name", "Name", "Phone", "Arrival date", "Departure date" };
	JComboBox comboBox = new JComboBox(Options);

	int O = 0;

	public Modifier(ArrayList<Client> liste) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter the room number ");
		lblNewLabel.setBounds(20, 37, 214, 14);
		contentPane.add(lblNewLabel);

		txtfnum = new JTextField();
		txtfnum.setBounds(229, 35, 134, 20);
		contentPane.add(txtfnum);
		txtfnum.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("What would you like to change");
		lblNewLabel_1.setBounds(20, 93, 214, 14);
		contentPane.add(lblNewLabel_1);
		comboBox.setBounds(248, 90, 100, 20);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == comboBox) {
					JComboBox c = (JComboBox) e.getSource();
					String Option = (String) comboBox.getSelectedItem();

					if (Option == "Nom") {

						O = 1;

					}

					if (Option == "Prenom") {

						O = 2;

					}

					if (Option == "Telephone") {

						O = 3;

					}

					if (Option == "Date d'arriver") {

						O = 4;

					}

					if (Option == "Date depart") {

						O = 5;

					}
				}
			}
		});
		contentPane.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("Enter the modification");
		lblNewLabel_2.setBounds(20, 147, 145, 14);
		contentPane.add(lblNewLabel_2);

		txtfmodification = new JTextField();
		txtfmodification.setBounds(229, 145, 134, 20);
		contentPane.add(txtfmodification);
		txtfmodification.setColumns(10);

		JButton btnok = new JButton("Modify");
		btnok.setBounds(156, 218, 100, 23);
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < liste.size(); i++) {

					Client x = liste.get(i);

					if (x.getNumChambre().equals(txtfnum.getText())) {

						if (O == 1) {
							x.setNom(txtfmodification.getText());

						}

						if (O == 2) {
							x.setPrenom(txtfmodification.getText());

						}

						if (O == 3) {
							x.setTelephone(txtfmodification.getText());

						}

						if (O == 4) {

							x.setArriver(txtfmodification.getText());

						}
						if (O == 5) {

							x.setDepart(txtfmodification.getText());

						}

					}

				}

				txtfnum.setText("");
				txtfmodification.setText("");
				comboBox.setSelectedItem("");

			}
		});
		contentPane.add(btnok);

		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.setBounds(156, 252, 100, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("(For date : dd/mm/yyyy)");
		lblNewLabel_3.setBounds(20, 169, 158, 14);
		contentPane.add(lblNewLabel_3);
	}

}
