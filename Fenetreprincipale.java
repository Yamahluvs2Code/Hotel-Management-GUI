import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Fenetreprincipale extends JFrame {

	private JPanel contentPane;
	ArrayList<Client> Liste = new ArrayList<Client>();
	ArrayList<Chambre> Liste1 = new ArrayList<Chambre>();

	int numero = 100;

	public Fenetreprincipale() {

		for (int i = 0; i < 2; i++) {

			Liste1.add(new Chambre(numero      , "1", true));
			Liste1.add(new Chambre(numero + 100, "2", true));
			Liste1.add(new Chambre(numero + 200, "3", true));
			Liste1.add(new Chambre(numero + 300, "4", true));

			numero = numero + 1;

		}

		ImageIcon image = new ImageIcon(getClass().getResource("/Image/hotel.jpg"));

		setTitle("JW Marriot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelpic = new JLabel(image);
		labelpic.setBounds(10, 11, 574, 477);
		contentPane.add(labelpic);

		JMenuBar menuBar = new JMenuBar();
		JMenu submenu1, mnMenu;

		mnMenu = new JMenu("Menu");

		JMenuItem i1, i2, i3, i4, i5, i6;

		i5 = new JMenuItem("Checkout");
		i5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Checkout I = new Checkout(Liste);
				I.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				I.setResizable(true);
				I.setLocationRelativeTo(null);
				I.setVisible(true);

			}
		});

		submenu1 = new JMenu("Reservation");

		i1 = new JMenuItem("Add");
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Ajouter I = new Ajouter(Liste, Liste1);
				I.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				I.setResizable(true);
				I.setLocationRelativeTo(null);
				I.setVisible(true);

			}
		});
		i2 = new JMenuItem("Modify");
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Modifier I = new Modifier(Liste);
				I.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				I.setResizable(true);
				I.setLocationRelativeTo(null);
				I.setVisible(true);

			}
		});
		i3 = new JMenuItem("Cancel");
		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Annuler I = new Annuler(Liste, Liste1);
				I.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				I.setResizable(true);
				I.setLocationRelativeTo(null);
				I.setVisible(true);

			}
		});

		submenu1.add(i1);
		submenu1.add(i2);
		submenu1.add(i3);

		mnMenu.add(submenu1);

		i4 = new JMenuItem("Availability");
		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disponibilite I = new Disponibilite(Liste1);
				I.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				I.setResizable(true);
				I.setLocationRelativeTo(null);
				I.setVisible(true);
			}
		});
		mnMenu.add(i4);

		i6 = new JMenuItem("Clients info");
		i6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Infoclient I = new Infoclient(Liste);
				I.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				I.setResizable(true);
				I.setLocationRelativeTo(null);
				I.setVisible(true);

			}
		});
		mnMenu.add(i6);
		mnMenu.add(i5);

		menuBar.add(mnMenu);
		setJMenuBar(menuBar);

	}
}
