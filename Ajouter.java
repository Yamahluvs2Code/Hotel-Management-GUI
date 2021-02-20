import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ajouter extends JFrame {

	private JPanel contentPane;
	private JTextField txtfnom;
	private JTextField txtfprenom;
	private JTextField txtftele;
	private JTextField txtfarriver;
	private JTextField txtfdepart;
	private JTextField txtftype;

	public Ajouter(ArrayList<Client> liste, ArrayList<Chambre> liste1) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNom = new JLabel("Last Name");
		lblNom.setBounds(5, 50, 112, 14);
		contentPane.add(lblNom);

		txtfnom = new JTextField();
		txtfnom.setBounds(127, 47, 87, 20);
		contentPane.add(txtfnom);
		txtfnom.setColumns(10);

		JLabel lblPrenom = new JLabel("Name");
		lblPrenom.setBounds(5, 105, 63, 14);
		contentPane.add(lblPrenom);

		txtfprenom = new JTextField();
		txtfprenom.setBounds(127, 102, 87, 20);
		contentPane.add(txtfprenom);
		txtfprenom.setColumns(10);

		JLabel lblTelephone = new JLabel("Phone");
		lblTelephone.setBounds(5, 161, 70, 14);
		contentPane.add(lblTelephone);

		txtftele = new JTextField();
		txtftele.setBounds(127, 158, 87, 20);
		contentPane.add(txtftele);
		txtftele.setColumns(10);

		JButton btnAjouter = new JButton("Add");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String a = "";

				for (int i = 0; i < liste1.size(); i++) {

					Chambre x = liste1.get(i);

					if (x.getType().equals(txtftype.getText()) && x.isDisponible()) {

						a = Integer.toString(x.getnum());

						x.setDisponible(false);

						i = i + 1000;
					}

				}

				if (a != "") {

					if (txtfnom.isEditable() && txtfprenom.isEditable() && txtftele.isEditable()&& txtfarriver.isEditable() && txtfdepart.isEditable() && txtftype.isEditable()) {
						liste.add(new Client(txtfnom.getText(), txtfprenom.getText(), txtftele.getText(), a, txtfarriver.getText(), txtfdepart.getText()));
					}

				} else {
					JOptionPane.showMessageDialog(null, "this room type is full. plz choose another ","", JOptionPane.INFORMATION_MESSAGE);

				}

				txtfnom.setText("");
				txtfprenom.setText("");
				txtftele.setText("");
				txtfarriver.setText("");
				txtfdepart.setText("");
				txtftype.setText("");

			}
		});
		btnAjouter.setBounds(334, 157, 87, 23);
		contentPane.add(btnAjouter);

		JLabel lblDateDarriver = new JLabel("Arrival date");
		lblDateDarriver.setBounds(5, 218, 112, 14);
		contentPane.add(lblDateDarriver);

		txtfarriver = new JTextField();
		txtfarriver.setBounds(127, 215, 87, 20);
		contentPane.add(txtfarriver);
		txtfarriver.setColumns(10);

		JLabel lblDateDepart = new JLabel("Departure date");
		lblDateDepart.setBounds(5, 274, 112, 14);
		contentPane.add(lblDateDepart);

		txtfdepart = new JTextField();
		txtfdepart.setBounds(127, 271, 87, 20);
		contentPane.add(txtfdepart);
		txtfdepart.setColumns(10);

		JButton btnquitter = new JButton("Quit");
		btnquitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnquitter.setBounds(335, 270, 86, 23);
		contentPane.add(btnquitter);

		JLabel lblTypeDeChambre = new JLabel("Room type");
		lblTypeDeChambre.setBounds(5, 322, 112, 14);
		contentPane.add(lblTypeDeChambre);

		txtftype = new JTextField();
		txtftype.setBounds(127, 319, 87, 20);
		contentPane.add(txtftype);
		txtftype.setColumns(10);

		JLabel lblNewLabel = new JLabel("dd/mm/yyyy");
		lblNewLabel.setBounds(237, 218, 100, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("dd/mm/yyyy");
		lblNewLabel_1.setBounds(237, 274, 88, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("1, 2, 3, 4");
		lblNewLabel_2.setBounds(5, 339, 136, 14);
		contentPane.add(lblNewLabel_2);
	}
}
