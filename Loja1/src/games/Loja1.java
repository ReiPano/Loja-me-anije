package games;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Loja1 extends JPanel implements ActionListener,MouseMotionListener, KeyListener{

	String vendi=System.getProperty("user.home");
	private static final long serialVersionUID = 1L;
	List<Integer> b= new ArrayList<Integer>();
    int x=40,muzika=Load(vendi+"\\Desktop\\media\\saveMuzika.txt"),numerusi =0,shfaqe=0,fillimi=0, y=40, shtesx=0, shtesy=0, fundi=0, a=(int)(Math.random()*20), vendix =250,vendiy=350, jeta=5,kohezgjatja=-1, piket=0, veshtiresia= Load(vendi+"\\Desktop\\media\\save1.txt"), highScore;
    Rectangle katror1,katror2,rrethi;
    int kape = 0;
    int kordx=4000,kordy=4000;
    Timer tm =new Timer(10,this);
    Timer tm2 =new Timer(1000,this);
	private JFrame frame;
	String emrifiles="";

	File soundFile = new File(vendi+"/Desktop/media/My_Song_1_.wav");
	AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	Clip clip = AudioSystem.getClip();
	
	public Loja1() throws IOException, Exception {
		initialize();
	}
	
	private void initialize() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		System.out.println("Muzkika "+muzika);
		if(muzika==1){
			clip.open(audioIn);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		if(veshtiresia== 3)
			emrifiles="_easy";
		else if(veshtiresia== 4)
			emrifiles="_medium";
		else if(veshtiresia== 7)
			emrifiles="_hard";
		File file1= new File("C:\\Users\\rei\\Desktop\\media\\save"+emrifiles+".txt");
		if(!file1.exists()){
			try {
				File s1= new File("C:\\Users\\rei\\Desktop\\media\\save"+"_easy"+".txt");
				File s2= new File("C:\\Users\\rei\\Desktop\\media\\save"+"_medium"+".txt");
				File s3= new File("C:\\Users\\rei\\Desktop\\media\\save"+"_hard"+".txt");
				s1.createNewFile();
				s2.createNewFile();
				s3.createNewFile();
				save(0,"_easy");
				save(0,"_medium");
				save(0,"_hard");
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		highScore= Load("C:\\Users\\rei\\Desktop\\media\\save"+emrifiles+".txt");
		tm.start();
		
		frame = new JFrame();
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(600,600);
		frame.getContentPane().add(this);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.getContentPane().setCursor(blankCursor);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		addMouseMotionListener(this);
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu mnFile = new JMenu("Veshtiresia");
        menuBar.add(mnFile);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Easy");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		veshtiresia=3;
        		save1(3);
        		tm.restart();
        	}
        });
        mnFile.add(mntmNewMenuItem);
        
        JMenuItem mntmMedium = new JMenuItem("Medium");
        mntmMedium.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		veshtiresia=4;
        		save1(4);
        		tm.restart();
        	}
        });
        mnFile.add(mntmMedium);
        
        JMenuItem mntmHard = new JMenuItem("Hard");
        mntmHard.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		veshtiresia=6;
        		save1(6);
        		tm.restart();
        	}
        });
        mnFile.add(mntmHard);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println(kape);
		Font NewFont =new Font("Serif",Font.BOLD,20);
		g.setFont(NewFont);
		
		g.setColor(Color.green);
		g.fillRect(0, 0, 600, 600);
		
		g.setColor(Color.GRAY);
		g.fillRect(40, 40, 500, 500);
		
		g.setColor(Color.yellow);
		if(fillimi<400){
			g.drawString("Gati", 250, 350);
		}
		
		if(kape==0){
			g.setColor(Color.red);
			g.drawRect(40, 300, 499, 225);
			g.fillRect(40, y, a, 20);
			g.fillRect(a+80, y, fundi, 20);
			g.setColor(Color.BLACK);
			
			g.drawString("Jetet: "+ jeta, 400, 20);
			g.drawString("Piket: "+ piket, 0, 20);
			g.drawString("HighScore: "+ highScore, 200, 20);
			fundi=460-a;
			
			BufferedImage img = null;
		    try {
		        img = ImageIO.read(new File(vendi+"/Desktop/media/a.png"));
		    } catch (IOException e) {
		    }
		    g.drawImage(img, vendix, vendiy, 25, 25, null);
			
			rrethi = new Rectangle(vendix, vendiy, 25, 25);
		    katror1 = new Rectangle(40, y, a, 20);
		    katror2 = new Rectangle(a+80, y, fundi, 20);
		    
		    g.setColor(Color.yellow);
			g.fillOval(kordx-5, kordy-5, 20, 20);
		    g.setColor(Color.BLACK);
		    g.fillRect(kordx, kordy, 10, 10);
			
			
		    Rectangle katrori = new Rectangle(kordx, kordy, 10, 10);
		
		    Area kat = new Area(katrori);
		    kat.intersect(new Area(rrethi));
		    Area area = new Area(katror1);
		    Area area1 = new Area(katror2);
            area.intersect(new Area(rrethi));
            area1.intersect(new Area(rrethi));
        
            if(!kat.isEmpty()){
        	   System.out.println("joooo");
        	   do{
        	      kape=(int)(Math.random()*5);
        	      System.out.println(kape);
        	   }while(kape==0);
        	   kohezgjatja=5;
        	   kordx=4000;
        	   kordy=4000;
            }
            if(!area1.isEmpty()){
        	   tm.stop();
               jeta=jeta-1;
               x=40;
               y=40;
               a=(int)(Math.random()*20);
               if(jeta<0){
            	  if(piket>highScore){
            		 save(piket,emrifiles);
            	  }
            	  if(piket<highScore){
            		 save(highScore,emrifiles);
            	  }
            	  clip.close();
            	  new Dialogu();
            	  frame.dispose();
              }
              else{
            	  tm.start();
              }
            }
            if(!area.isEmpty()){
        	   tm.stop();
               jeta=jeta-1;
               x=40;
               y=40;
               a=(int)(Math.random()*20);
                  if(jeta<0){
            	     if(piket>highScore){
            		     save(piket,emrifiles);
            	     }
            	     if(piket<highScore){
            		    save(highScore,emrifiles);
            	     }
            	     clip.close();
            	new Dialogu();
            	frame.dispose();
            }
            else{
            	tm.start();
            	}
            }
        }
		else if(kape==1){
			g.setColor(Color.red);
			g.drawRect(40, 300, 499, 225);
			g.drawRect(40, y, a, 20);
			g.drawRect(a+80, y, fundi, 20);
			g.setColor(Color.BLACK);
			

			BufferedImage img = null;
		    try {
		        img = ImageIO.read(new File(vendi+"/Desktop/media/a.png"));
		    } catch (IOException e) {
		    }
		    g.drawImage(img, vendix, vendiy, 25, 25, null);
			
			g.drawString("Jetet: "+ jeta, 400, 20);
			g.drawString("Piket: "+ piket, 0, 20);
			g.drawString("HighScore: "+ highScore, 200, 20);
			fundi=460-a;
	    }
		else if(kape==2){
			g.setColor(Color.red);
			g.drawRect(40, 300, 499, 225);
			g.fillRect(40, y, a, 20);
			g.fillRect(a+80, y, fundi, 20);
			g.setColor(Color.BLACK);
			

			BufferedImage img = null;
		    try {
		        img = ImageIO.read(new File(vendi+"/Desktop/media/a.png"));
		    } catch (IOException e) {
		    }
		    g.drawImage(img, vendix, vendiy, 10, 10, null);
			
			g.drawString("Jetet: "+ jeta, 400, 20);
			g.drawString("Piket: "+ piket, 0, 20);
			g.drawString("HighScore: "+ highScore, 200, 20);
			fundi=460-a;
			
			rrethi = new Rectangle(vendix, vendiy, 10, 10);
		    katror1 = new Rectangle(40, y, a, 20);
		    katror2 = new Rectangle(a+80, y, fundi, 20);
		    
		    Area area = new Area(katror1);
		    Area area1 = new Area(katror2);
            area.intersect(new Area(rrethi));
            area1.intersect(new Area(rrethi));
            
             if(!area1.isEmpty()){
         	   tm.stop();
                jeta=jeta-1;
                x=40;
                y=40;
                a=(int)(Math.random()*20);
                if(jeta<0){
             	  if(piket>highScore){
             		 save(piket,emrifiles);
             	  }
             	  if(piket<highScore){
             		 save(highScore,emrifiles);
             	  }
             	  clip.close();
             	  new Dialogu();
             	  frame.dispose();
               }
               else{
             	  tm.start();
               }
             }
             if(!area.isEmpty()){
         	   tm.stop();
                jeta=jeta-1;
                x=40;
                y=40;
                a=(int)(Math.random()*20);
                   if(jeta<0){
             	     if(piket>highScore){
             		     save(piket,emrifiles);
             	     }
             	     if(piket<highScore){
             		    save(highScore,emrifiles);
             	     }
             	     clip.close();
             	new Dialogu();
             	frame.dispose();
             }
             else{
             	tm.start();
             	}
             }
		}
		else if(kape==3){
			fundi=460-a;
			g.setColor(Color.red);
			g.drawRect(40, 300, 499, 225);
			g.fillRect(40, y, a, 20);
			g.fillRect(a+80, y, fundi, 20);
			g.setColor(Color.BLACK);
			

			BufferedImage img = null;
		    try {
		        img = ImageIO.read(new File(vendi+"/Desktop/media/a.png"));
		    } catch (IOException e) {
		    }
		    g.drawImage(img, vendix, vendiy, 25, 25, null);
			
			g.drawString("Jetet: "+ jeta, 400, 20);
			g.drawString("Piket: "+ piket, 0, 20);
			g.drawString("HighScore: "+ highScore, 200, 20);
			veshtiresia=2;
			
			rrethi = new Rectangle(vendix, vendiy, 25, 25);
		    katror1 = new Rectangle(40, y, a, 20);
		    katror2 = new Rectangle(a+80, y, fundi, 20);
		    
		    Area area = new Area(katror1);
		    Area area1 = new Area(katror2);
            area.intersect(new Area(rrethi));
            area1.intersect(new Area(rrethi));
            
             if(!area1.isEmpty()){
         	   tm.stop();
                jeta=jeta-1;
                x=40;
                y=40;
                a=(int)(Math.random()*20);
                if(jeta<0){
             	  if(piket>highScore){
             		 save(piket,emrifiles);
             	  }
             	  if(piket<highScore){
             		 save(highScore,emrifiles);
             	  }
             	  clip.close();
             	  new Dialogu();
             	  frame.dispose();
               }
               else{
             	  tm.start();
               }
             }
             if(!area.isEmpty()){
         	   tm.stop();
                jeta=jeta-1;
                x=40;
                y=40;
                a=(int)(Math.random()*20);
                   if(jeta<0){
             	     if(piket>highScore){
             		     save(piket,emrifiles);
             	     }
             	     if(piket<highScore){
             		    save(highScore,emrifiles);
             	     }
             	     clip.close();
             	new Dialogu();
             	frame.dispose();
             }
             else{
             	tm.start();
             	}
             }
		}
		else if(kape==4){
			fundi=440-a;
			g.setColor(Color.red);
			g.drawRect(40, 300, 499, 225);
			g.fillRect(40, y, a, 20);
			g.fillRect(a+100, y, fundi, 20);
			g.setColor(Color.BLACK);
			

			BufferedImage img = null;
		    try {
		        img = ImageIO.read(new File(vendi+"/Desktop/media/a.png"));
		    } catch (IOException e) {
		    }
		    g.drawImage(img, vendix, vendiy, 25, 25, null);
			
			g.drawString("Jetet: "+ jeta, 400, 20);
			g.drawString("Piket: "+ piket, 0, 20);
			
			g.drawString("HighScore: "+ highScore, 200, 20);
			
			rrethi = new Rectangle(vendix, vendiy, 25, 25);
		    katror1 = new Rectangle(40, y, a, 20);
		    katror2 = new Rectangle(a+100, y, fundi, 20);
		    
		    Area area = new Area(katror1);
		    Area area1 = new Area(katror2);
            area.intersect(new Area(rrethi));
            area1.intersect(new Area(rrethi));
            
             if(!area1.isEmpty()){
         	   tm.stop();
                jeta=jeta-1;
                x=40;
                y=40;
                a=(int)(Math.random()*20);
                if(jeta<0){
             	  if(piket>highScore){
             		 save(piket,emrifiles);
             	  }
             	  if(piket<highScore){
             		 save(highScore,emrifiles);
             	  }
             	  clip.close();
             	  new Dialogu();
             	  frame.dispose();
               }
               else{
             	  tm.start();
               }
             }
             if(!area.isEmpty()){
         	   tm.stop();
                jeta=jeta-1;
                x=40;
                y=40;
                a=(int)(Math.random()*20);
                   if(jeta<0){
             	     if(piket>highScore){
             		     save(piket,emrifiles);
             	     }
             	     if(piket<highScore){
             		    save(highScore,emrifiles);
             	     }
             	     clip.close();
             	new Dialogu();
             	frame.dispose();
             }
             else{
             	tm.start();
             	}
             }
		}
		
	}
	public void actionPerformed(ActionEvent e){
		fillimi++;
		if(fillimi>300){
			if(kohezgjatja==0){
				numerusi=piket;
				kape=0;
				kordx=4000;
				kordy=4000;
				veshtiresia= Load("C:\\Users\\rei\\Desktop\\media\\save1.txt");
				kohezgjatja--;
		    }
			
			else if(piket>10+numerusi && piket<numerusi+15){
			    if(kordx==4000 || kordy==4000){
			       int [] mundesitx ={50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270,280,290,300,310,320,330,340,350,360,370,380,390,400,410,420,430,440,450,460};
			       int [] mundesity ={310,320,330,340,350,360,370,380,390,400,410,420,430,440,450,460,470,480,490,500};
			       int xx= (int)(Math.random()*41);
			       int yy= (int)(Math.random()*19);
			       kordx=mundesitx[xx];
			       kordy=mundesity[yy];}
		    }
		    y=y+veshtiresia;
		    if(y>520){
			   a=(int) (Math.random()*300);
			   System.out.println(a);
			   y=40;
			   piket++;
			   shfaqe++;
			   if(kohezgjatja>0){
					kohezgjatja--;
				}
			}
		}
		repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		
		   vendix= e.getX();
		   vendiy=e.getY();
		    if(vendix<40)
			   vendix=40;
		    if(vendix>460)
			   vendix=515;
		    if(vendiy>500)
			   vendiy=500;
		    if(vendiy<300)
			   vendiy=300;
		
	}
	public void mouseMoved(MouseEvent e) {
		
		   vendix= e.getX();
		   vendiy=e.getY();
		   if(vendix<40)
		   	  vendix=40;
		   if(vendix>515)
			  vendix=515;
		   if(vendiy>500)
			  vendiy=500;
		   if(vendiy<300)
			  vendiy=300;
		
	}
	
	public void save (int a,String b){
		String g = "";
		String vendi = System.getProperty("user.home");
		g = Integer.toString(a);
		try {
			FileWriter fw = new FileWriter(vendi+"\\Desktop\\media\\save"+b+".txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(g);
			bw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void save1 (int a){
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
	public int Load (String a){
		try {
			FileReader fr=new FileReader(a);
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(fr);
			String c = br.readLine();
			int d = new Integer(c).intValue();
			return d;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int a= e.getKeyCode();
		if(a==KeyEvent.VK_ESCAPE){
			if(tm.isRunning())
				tm.stop();
			else
				tm.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
