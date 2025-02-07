package com.companyPort;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
1. 클래스는 부품객체
2. OOP (객체지향프로그램) 클래스 조립해서 프로그램 작성
	     UserView_intro
	   ◆	   ◆	   ◆      
	JFrame  Button[]  JLabel(ImageIcon) 
*/
public class UserView_intro {
	
	//멤버변수
	JFrame frame;
	JLabel label;
	//JButton [] btns;
	RoundedButton_main [] btns;
	ImageIcon icon;
	
	//생성자
	public UserView_intro() {
		frame = new JFrame("@TOGETHER@");
		icon = new ImageIcon("images\\firstpage.png");
		
		
		
		//label = new JLabel(icon);
		btns = new RoundedButton_main[]{ new RoundedButton_main("Login"),new RoundedButton_main("Sign-In") };
		//배경, 폰트색상, 사이즈
		for(int i=0; i<btns.length; i++) {
			btns[i].setBackground(Color.gray); 
			btns[i].setForeground(Color.white);
			btns[i].setFont(new Font(Font.DIALOG, Font.BOLD,15));
			//btns[i].setPreferredSize(new Dimension(100,60));
		}
		//이미지 크기조절
				Image img = icon.getImage();
				Image changeimg = img.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
				ImageIcon changeicon = new ImageIcon(changeimg);
				label = new JLabel(changeicon);
	}
		
	//멤버함수
	public void show() {
		//frame.setLayout(new FlowLayout());
		//frame.setLayout(new GridLayout(3,1));
		frame.setLayout(null);
		frame.setResizable(false); //움직이지마라
		
		label.setBounds(0,0,600,500); //배치
		btns[0].setBounds(250,320,100,50);
		btns[1].setBounds(250,400,100,50);
		
		frame.add(btns[0]); //버튼1 로그인
		frame.add(btns[1]); //버튼2 회원가입
		frame.add(label); //이미지
		
		frame.setVisible(true); //보이게...^^	
		frame.setSize(600,600); //크기
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 버튼
		
		
	}
	public static void main(String[] args) {
		new UserView_intro().show();
	}
}
