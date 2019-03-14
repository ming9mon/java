import java.awt.Color;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MP3 extends JFrame {
	

	JPanel p1;
	JPanel p2;
	JButton play; //���� ��� �Ǵ� �����ϱ� ���� ��ư	
	ImageIcon playImg = new ImageIcon ("./img/play.png");;
	ImageIcon pauseImg = new ImageIcon ("./img/pause.png");;
	
	public MP3(){
		super("MP3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,600);
		setLayout(new FlowLayout());
		//setLayout(null);
		
		//�޴��� �߰�
		createMenu();
		
		//��ư �г�
		bbb();
		buttonPanel();
		
		
		//ȭ�鿡 ���̱�
		setVisible(true);
	}
	
	private void createMenu() {
		//�޴��� ����
		JMenuBar mb = new JMenuBar();
		
		//�޴� ����
		JMenu addMusic = new JMenu("�뷡 �߰�");
		
		mb.add(addMusic);
		
		setJMenuBar(mb);
	}
	
	private void bbb() {
		p1 = new JPanel();
		
		p1.setPreferredSize(new Dimension(600,50));
		
		p1.setBackground(Color.red);
		
		add(p1);
	}
	
	private void buttonPanel() {
		p2 = new JPanel();
		//icon = new ImageIcon ("./img/play.png");
		play = new JButton(playImg);
		JButton previous = new JButton(new ImageIcon ("./img/previous.png"));
		JButton next = new JButton(new ImageIcon ("./img/next.png"));
		
		//��ư ������ �ޱ�
		play.addActionListener(new ButtonActionListener());
		next.addActionListener(new ButtonActionListener());
		previous.addActionListener(new ButtonActionListener());
		
		//play.addActionListener(new testtt());
		
		
		//��ư �ܰ��� ����
		play.setBorderPainted(false);
		previous.setBorderPainted(false);
		next.setBorderPainted(false);
		
		//��ư ���� ä��� ����
		play.setContentAreaFilled(false);
		previous.setContentAreaFilled(false);
		next.setContentAreaFilled(false);
		
		p2.add(previous);
		p2.add(play);
		p2.add(next);
		add(p2);
	}
	
	static File file;
	static AudioInputStream ais ;
	SourceDataLine adl;
	AudioFormat af;

	/*
    public static void abc() {
        File bgm;
        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        
        bgm = new File("D:\\MP3\\test.wav"); // ���ÿ��� ���� ������ ������ ��
        
        Clip clip;
        
        try {
               stream = AudioSystem.getAudioInputStream(bgm);
               format = stream.getFormat();
               info = new DataLine.Info(Clip.class, format);
               clip = (Clip)AudioSystem.getLine(info);
               clip.open(stream);
               clip.start();
               
        } catch (Exception e) {
               System.out.println("err : " + e);
        }
        
    }
    
    static void aa() {
    	
    	
		
		try {
			file = new File("D:\\MP3\\test.mp3");
			ais = AudioSystem.getAudioInputStream(file);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("aa");

        while(true) {
               try {
                     abc();
                     Thread.sleep(3000); // 3�ʿ� �ѹ��� ����ϵ��� ����
               } catch(Exception e) {
                     
               }
        }
	}
    */

    // ��ư �׼� ������ �����
 	class ButtonActionListener implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			if(e.getSource().equals(play)) {	//play��ư ������ ���
 				if(play.getIcon().toString().equals("./img/play.png")) {
 	 				play.setIcon(pauseImg);
 				}else {
 					play.setIcon(playImg);
 				}
 			}
 		}
 	}

 	class testtt implements ActionListener{
 		
 		
 		public void actionPerformed(ActionEvent e) {
 			if(e.getSource().equals(play)) {
 				System.out.println("ss");
 				play.setIcon(new ImageIcon ("./img/pause.png"));
 			}
 		}
 	}
	
	public static void main(String[] args) {
		
		MP3 m = new MP3();
    }

}
