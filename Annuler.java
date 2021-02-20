import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Annuler extends JFrame {

	private JPanel contentPane;
	private JTextField txtnum;

	int tarif = 0;
	int numchambre = 0;
	int prix = 0;
	double prixfinal = 0;
	DateFormat df;
	long daysbetween;

	public Annuler(ArrayList<Client> liste, ArrayList<Chambre> liste1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter the room number");
		lblNewLabel.setBounds(33, 50, 147, 14);
		contentPane.add(lblNewLabel);

		txtnum = new JTextField();
		txtnum.setBounds(207, 48, 86, 20);
		contentPane.add(txtnum);
		txtnum.setColumns(10);

		JButton btnNewButton = new JButton("Cancel reservation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < liste.size(); i++) {

					Client x = liste.get(i);

					if (x.getNumChambre().equals(txtnum.getText())) {

						for (int d = 0; d < liste1.size(); d++) {

							Chambre a = liste1.get(d);

							String z = Integer.toString(a.getnum());

							if (x.getNumChambre().equals(z)) {
								a.setDisponible(true);
							}

						}

						tarif = 0;
						numchambre = Integer.parseInt(x.getNumChambre());

						if (numchambre < 199) {
							tarif = 100;
						} else if (numchambre < 299) {
							tarif = 110;
						} else if (numchambre < 399) {
							tarif = 150;
						} else if (numchambre < 499) {
							tarif = 160;
						}

						liste.remove(i);
						txtnum.setText("");

						prix = tarif;

						prixfinal = prix + (prix * 0.14);

						df = new SimpleDateFormat("dd/MM/yyyy");

						Date today = new Date();

						Date startDate = null;
						try {
							startDate = df.parse(x.getArriver());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}

						Calendar startCal = Calendar.getInstance();
						startCal.setTime(today);

						Calendar endCal = Calendar.getInstance();
						endCal.setTime(startDate);

						daysbetween = Duration.between(startCal.toInstant(), endCal.toInstant()).toDays();

						if (daysbetween < 1) {
							JOptionPane.showMessageDialog(null,"Cet reservation est annuler SVP payez pour une journee : " + prixfinal + "$", "",JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Cet reservation est annuler", "",JOptionPane.INFORMATION_MESSAGE);
						}

					}

				}

			}
		});
		btnNewButton.setBounds(115, 110, 159, 23);
		contentPane.add(btnNewButton);

		JButton btnQuitter = new JButton("Quit");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnQuitter.setBounds(151, 160, 89, 23);
		contentPane.add(btnQuitter);
	}
}
