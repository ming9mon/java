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
	JButton play; //음악 재생 또는 정지하기 위한 버튼	
	ImageIcon playImg = new ImageIcon ("./img/play.png");;
	ImageIcon pauseImg = new ImageIcon ("./img/pause.png");;
	
	public MP3(){
		super("MP3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,600);
		setLayout(new FlowLayout());
		//setLayout(null);
		
		//메뉴바 추가
		createMenu();
		
		//버튼 패널
		bbb();
		buttonPanel();
		
		
		//화면에 보이기
		setVisible(true);
	}
	
	private void createMenu() {
		//메뉴바 생성
		JMenuBar mb = new JMenuBar();
		
		//메뉴 생성
		JMenu addMusic = new JMenu("노래 추가");
		
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
		
		//버튼 리스너 달기
		play.addActionListener(new ButtonActionListener());
		next.addActionListener(new ButtonActionListener());
		previous.addActionListener(new ButtonActionListener());
		
		//play.addActionListener(new testtt());
		
		
		//버튼 외각선 제거
		play.setBorderPainted(false);
		previous.setBorderPainted(false);
		next.setBorderPainted(false);
		
		//버튼 내용 채우기 안함
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
        
        bgm = new File("D:\\MP3\\test.wav"); // 사용시에는 개별 폴더로 변경할 것
        
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
                     Thread.sleep(3000); // 3초에 한번씩 재생하도록 설정
               } catch(Exception e) {
                     
               }
        }
	}
    */

    // 버튼 액션 리스터 만들기
 	class ButtonActionListener implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			if(e.getSource().equals(play)) {	//play버튼 눌렀을 경우
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
