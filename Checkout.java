import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Checkout extends JFrame {

	private JPanel contentPane;
	private JTextField txtnum;
	JTextPane textPane = new JTextPane();

	public Checkout(ArrayList<Client> liste) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Entrez le numero de chambre: ");
		lblNewLabel.setBounds(10, 50, 214, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Checkout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < liste.size(); i++) {

					Client x = liste.get(i);

					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

					Date startDate = null;
					try {
						startDate = df.parse(x.getArriver());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

					Date endDate = null;
					try {
						endDate = df.parse(x.getDepart());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

					Calendar startCal = Calendar.getInstance();
					startCal.setTime(startDate);

					Calendar endCal = Calendar.getInstance();
					endCal.setTime(endDate);

					int weekdays = 1;
					int weekends = 0;

					do {
						startCal.add(Calendar.DAY_OF_MONTH, 1);

						if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
								&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
							weekdays++;
						} else {
							weekends++;
						}

					} while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

					int tarif = 0;
					int num = Integer.parseInt(x.getNumChambre());

					if (num < 199) {
						tarif = 100;
					} else if (num < 299) {
						tarif = 110;
					} else if (num < 399) {
						tarif = 150;
					} else if (num < 499) {
						tarif = 160;
					}

					int prix = (weekdays * tarif) + ((weekends * tarif) + (weekends * 20));

					double prixfinal = prix + (prix * 0.14);

					if (x.getNumChambre().equals(txtnum.getText())) {

						textPane.setText(weekdays + " weekdays" + "\n" + weekends + " fins de semaines" + "\n"+ "Le prix est " + prixfinal + "$");

					}

				}
				txtnum.setText("");

			}
		});
		btnNewButton.setBounds(311, 46, 116, 23);
		contentPane.add(btnNewButton);

		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnQuitter.setBounds(216, 184, 89, 23);
		contentPane.add(btnQuitter);

		textPane.setEditable(false);
		textPane.setBounds(10, 91, 583, 82);
		contentPane.add(textPane);

		txtnum = new JTextField();
		txtnum.setBounds(185, 47, 116, 20);
		contentPane.add(txtnum);
		txtnum.setColumns(10);

		textPane.setBounds(10, 75, 580, 103);
		contentPane.add(textPane);
	}
}
