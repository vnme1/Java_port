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
	
	//controller
	UserProcess controller;
	UserProcess [] process;
	
	// 생성자 ->사용할 수 있게 초기화
	public UserMain() { 
		users = new ArrayList<>();
		intro = new UserView_intro(); intro.show();
		crud = new UserView_crud();
		login = new UserView_login();
		process = new UserProcess[] { new UserCreate(), new UserUpdate(), new UserDelete(), new UserRead(),};
	}
	
	// 행위 - 기능 - 멤버함수
	
	public void intro() { 
		intro.btns[0].addActionListener(new ActionListener() { //로그인 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				intro.frame.dispose();//현재창 끄고
				login.show();//로그인 창 열기
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
		
		
	}
	public void member() { 
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
				controller = process[3]; controller.exec(users,crud); //처리하고 / 해당 view
			}});
		
		
	}
	
	public static void main(String[] args) {
		new UserMain().intro();
	}

	

}
