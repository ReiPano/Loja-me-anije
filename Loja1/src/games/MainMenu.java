package games;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class MainMenu extends JPanel {
	
	String vendi=System.getProperty("user.home");
	private static final long serialVersionUID = 1L;
	private JFrame frmLoja;
	String g , emri="Muzika";
	int veshtirsia=0,mzk;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmLoja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenu() throws IOException {
		setBackground(new Color(255, 235, 205));
		initialize();
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() throws IOException {
		File save= new File(vendi+"\\Desktop\\media\\save1.txt");
		if(!save.exists()){
			save.createNewFile();
		}
		File savemuzika= new File(vendi+"\\Desktop\\media\\saveMuzika.txt");
		saveMuzika(0);
		if(!savemuzika.exists()){
			savemuzika.createNewFile();
		}
		frmLoja = new JFrame();
		
		frmLoja.setResizable(false);
		frmLoja.setTitle("Loja1");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmLoja.setSize(570,351);
		frmLoja.getContentPane().add(this);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(102, 102, 255));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				g= (String) comboBox.getSelectedItem();
				Veshtiresia v= new Veshtiresia(g);
				veshtirsia=v.numri();
				System.out.println(veshtirsia);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Zgjidh", "Easy", "Medium", "Hard"}));
		comboBox.setBounds(438, 143, 106, 20);
		add(comboBox);
		
		JLabel lblLoja = new JLabel("Loja 1");
		lblLoja.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblLoja.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoja.setBounds(74, 68, 264, 43);
		add(lblLoja);
		JButton btnFillo = new JButton("Fillo");
		btnFillo.setBackground(Color.GREEN);
		btnFillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(veshtirsia!=0){
				save(veshtirsia);
				try {
					new Loja1();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					frmLoja.setVisible(false);
					frmLoja.dispose();
			}}
		});
		btnFillo.setBounds(74, 143, 127, 43);
		add(btnFillo);
		
		JButton btnNewButton = new JButton("Mbyll");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(211, 143, 127, 43);
		add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 564, 21);
		add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExti = new JMenuItem("Exti");
		mntmExti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExti);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmCredits = new JMenuItem("Credits");
		mntmCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Credits();
			}
		});
		mnHelp.add(mntmCredits);
		JLabel label = new JLabel("Off");
		label.setBounds(10, 263, 81, 14);
		add(label);
		
		JButton btnMusicOn = new JButton(emri);
		btnMusicOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mzk==0){
					mzk=1;
					System.out.println(mzk);
					label.setText("On");
					saveMuzika(mzk);
				}
				else{
					mzk=0;
					System.out.println(mzk);
					label.setText("Off");
					saveMuzika(mzk);
				}
				repaint();
			}
		});
		
		
		btnMusicOn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnMusicOn.setBounds(10, 288, 81, 23);
		add(btnMusicOn);
		frmLoja.setLocation(dim.width/2-frmLoja.getSize().width/2, dim.height/2-frmLoja.getSize().height/2);
		frmLoja.setVisible(true);
		frmLoja.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public void save (int a){
		String g = "";
		String vendi = System.getProperty("user.home");
		g = Integer.toString(a);
		try {
			FileWriter fw = new FileWriter(vendi+"\\Desktop\\media\\save1.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(g);
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void saveMuzika (int a){
		String g = Integer.toString(a);
		String vendi = System.getProperty("user.home");
		try {
			FileWriter fw = new FileWriter(vendi+"\\Desktop\\media\\saveMuzika.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(g);
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
