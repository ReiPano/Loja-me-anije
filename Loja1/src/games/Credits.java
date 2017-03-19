package games;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

public class Credits extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Credits() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPunoi = new JLabel("Punoi : Rei Pano");
		lblPunoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblPunoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPunoi.setBounds(127, 24, 143, 27);
		contentPane.add(lblPunoi);
		
		JLabel lblProjektiIPare = new JLabel("Projekti i Pare");
		lblProjektiIPare.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjektiIPare.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProjektiIPare.setBounds(127, 62, 143, 27);
		contentPane.add(lblProjektiIPare);
		
		JLabel lblLevizMousinPer = new JLabel("Leviz Mous-in per te levizur topin.\r\n\r\n");
		lblLevizMousinPer.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevizMousinPer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLevizMousinPer.setBounds(10, 100, 414, 36);
		contentPane.add(lblLevizMousinPer);
		
		JLabel lblMundohuTeFutesh = new JLabel("Mundohu te futesh ne hapsirat boshe.");
		lblMundohuTeFutesh.setHorizontalAlignment(SwingConstants.CENTER);
		lblMundohuTeFutesh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMundohuTeFutesh.setBounds(10, 147, 414, 31);
		contentPane.add(lblMundohuTeFutesh);
		
		JLabel lblPerdorSuperfuqitePer = new JLabel("Perdor Superfuqite per ta ber lojen me interesante");
		lblPerdorSuperfuqitePer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerdorSuperfuqitePer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerdorSuperfuqitePer.setBounds(10, 189, 414, 25);
		contentPane.add(lblPerdorSuperfuqitePer);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		setVisible(true);
	}
}
