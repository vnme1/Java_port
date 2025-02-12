package com.companyPort;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserView_signin {
	
	//멤버변수
	JFrame frame;
	JLabel label;
	RoundedButton [] btns_login; //둥근모서리 버튼
	//JButton [] btns_login; 그냥 버튼
	ImageIcon icon;
	//생성자

	public UserView_signin(){
		frame = new JFrame("@TOGETHER@");
		icon = new ImageIcon("images\\signinpage.png");
		
		//이미지 크기조절
		Image img = icon.getImage();
		Image changeimg = img.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
		ImageIcon changeicon = new ImageIcon(changeimg);
		label = new JLabel(changeicon);
		
		//label = new JLabel(icon);
		btns_login = new RoundedButton[]{ new RoundedButton("Signin"),/*new RoundedButton("API로그인")*/ };
		//배경, 폰트색상, 사이즈
		for(int i=0; i<btns_login.length; i++) {
			btns_login[i].setBackground(Color.gray); 
			btns_login[i].setForeground(Color.white);
			btns_login[i].setFont(new Font(Font.DIALOG, Font.BOLD,15));
			//btns[i].setPreferredSize(new Dimension(100,60));
			
		}	
	}
	public void show() {
		//frame.setLayout(new FlowLayout());
		//frame.setLayout(new GridLayout(3,1));
		frame.setLayout(null);
		frame.setResizable(false); //움직이지마라
		label.setBounds(0,0,600,500); //배치
		JLabel l_id = new JLabel("      아이디 >");
		l_id.setBounds(190,170,100,50);
		JTextField J_id= new JTextField();
		J_id.setBounds(300,180,110,30);
		
		JLabel l_email = new JLabel("      이메일 >");
		l_email.setBounds(190,220,100,50);
		JTextField J_email= new JTextField();
		J_email.setBounds(300,230,110,30);
		
		
		JLabel l_pw = new JLabel("    비밀번호 >");
		l_pw.setBounds(190,270,100,50);
		JTextField J_pw= new JTextField();
		J_pw.setBounds(300,280,110,30);
		
		JLabel l_pwck = new JLabel("비밀번호 확인 >");
		l_pwck.setBounds(190,320,100,50);
		JTextField J_pwck= new JTextField();
		J_pwck.setBounds(300,330,110,30);
		
		
		btns_login[0].setBounds(250,390,110,60);
		//btns_login[1].setBounds(250,410,110,40); //api부분
		
		
		
		frame.add(l_id); frame.add(J_id); //id입력창
		frame.add(l_email); frame.add(J_email); 
		frame.add(l_pw); frame.add(J_pw); 
		frame.add(l_pwck); frame.add(J_pwck);
		
		frame.add(btns_login[0]); //버튼1 로그인
		//frame.add(btns_login[1]); //버튼2 api로그인
		frame.add(label); //이미지
		
		frame.setSize(600,600); //크기
		frame.setVisible(true); //보이게...^^
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 버튼
		
		
	}
	public static void main(String[] args) {
		new UserView_signin().show();

	}

}


