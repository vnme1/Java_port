package com.companyPort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//클래스는 부품객체이다
//멤버변수 / 멤버함수
//조립(합성) - 생성자 new
/*					UserMain
			◆			◆			◆
		<<model>>   <<View>>  <<Controller>>
		
	List<UserInfo>	UserView_intro	controller
					UserView_crud	[] process
					UserView_login
*/

public class UserMain {
	//model
	ArrayList<UserInfo> users;
	
	//view
	UserView_intro intro;
	UserView_crud crud;
	UserView_login login;
	UserView_signin signin;
	
	//controller
	UserProcess controller;
	UserProcess [] process;
	
	
	
	// 생성자 ->사용할 수 있게 초기화
	public UserMain() { 
		users = new ArrayList<>();
		intro = new UserView_intro(); intro.show();
		crud = new UserView_crud();
		login = new UserView_login();
		signin = new UserView_signin();
		process = new UserProcess[] { new UserCreate(), new UserUpdate(), new UserDelete(), new UserRead(), new UserLogin()};
//		ArrayList<UserInfo> list = new ArrayList<>();
//		Object[] data1 = {list.add(new UserInfo(0, "test1","two@naver.com","","",""))}; //이거 해결해라
//		crud.model.addRow(data1);
		
	}
	
	// 행위 - 기능 - 멤버함수
	public void back() {
		
	}
	
	public void intro() { 
		intro.btns[0].addActionListener(new ActionListener() { //로그인 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				intro.frame.dispose();//현재창 끄고
				login.show();//로그인 창 열기
				login();
			}	
		});
		
		intro.btns[1].addActionListener(new ActionListener() { //회원가입 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				intro.frame.dispose();//현재창 끄고
				crud.show();//crud 창 열기
				member();
			}	
		});
		
//		intro.btns[1].addActionListener(new ActionListener() { //회원가입 버튼
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				intro.frame.dispose();//현재창 끄고
//				signin.show();//crud 창 열기
//				member();
//			}	
//		});
		
		

	}
	public void login() {
		login.btns_login[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  //로그인
				controller = process[4]; controller.exec(users,crud); //처리하고 / 해당 view
		}});
	}
	public void signin() {//*
		signin.btns_login[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  //등록
				controller = process[0]; controller.exec(users,crud); //회원등록
		}});
	}
	
	public void member() { //회원crud
		crud.button[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  //등록
				controller = process[0]; controller.exec(users,crud); //처리하고 / 해당 view
			}});
		crud.button[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  //수정
				controller = process[1]; controller.exec(users,crud); //처리하고 / 해당 view
			}});
		crud.button[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  //삭제
				controller = process[2]; controller.exec(users,crud); //처리하고 / 해당 view
			}});
		crud.button[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  //종료
				crud.frame.dispose();//crud창 끄고
				intro.show();//로그인 창 열기
				//controller = process[3]; controller.exec(users,crud); //처리하고 / 해당 view
			}});
		
		
	}
	
	public static void main(String[] args) {
		
		new UserMain().intro();
	}

	

}
