import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Disponibilite extends JFrame{

	private JPanel contentPane;

	String f = "";
	
	
	public Disponibilite(ArrayList<Chambre> liste1) {

		
		for (Object Chambre : liste1) {
			f += Chambre + "\n";
		}
		
	
		
		setBounds(100, 100, 508, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane textClient = new JTextPane();
		textClient.setBounds(10, 11, 464, 279);
		contentPane.add(textClient);
		textClient.setText("Type                 Number              Availability" + "\n" + f);
		textClient.setEditable(false);

		JButton btnQuitter = new JButton("Quit");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnQuitter.setBounds(181, 312, 85, 25);
		contentPane.add(btnQuitter);

		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

	}

}