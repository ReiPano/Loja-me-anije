package games;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Dialogu extends JPanel{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public Dialogu() {
		setBackground(new Color(204, 204, 204));
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(369,169);
		frame.getContentPane().add(this);
		setLayout(null);
		
		JButton btnOk = new JButton("Po");
		btnOk.setBackground(new Color(51, 204, 51));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Loja1();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnOk.setBounds(46, 83, 89, 23);
		add(btnOk);
		
		JButton btnJo = new JButton("JO");
		btnJo.setForeground(new Color(255, 255, 255));
		btnJo.setBackground(new Color(255, 0, 0));
		btnJo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new MainMenu();
					frame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnJo.setBounds(210, 83, 89, 23);
		add(btnJo);
		
		JLabel lblProvoPerseri = new JLabel("Provo Perseri?");
		lblProvoPerseri.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblProvoPerseri.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvoPerseri.setBounds(46, 11, 253, 31);
		add(lblProvoPerseri);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
