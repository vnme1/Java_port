package com.companyPort;

import java.util.ArrayList;

//클래스는 부품객체이다
//멤버변수 / 멤버함수
//조립(합성) - 생성자 new
/*					UserMain
			◆			◆			◆
		<<model>>   <<View>>  <<Controller>>
		
	List<UserInfo>	UserView_intro	controller
					UserView_crud	[] process
*/

public class UserMain {
	//model
	ArrayList<UserInfo> users;
	
	//view
	UserView_intro intro;
	UserView_crud crud;
	
	//controller
	UserProcess controller;
	UserProcess [] process;
	
	// 생성자 ->사용할 수 있게 초기화
	public UserMain() { 
		users = new ArrayList<>();
		intro = new UserView_intro(); intro.show();
		process = new UserProcess[] { new UserCreate(), new UserRead(), new UserUpdate(), new UserDelete()};
	}
	
	// 행위 - 기능 - 멤버함수
	public void intro() {  }
	public void member() {  }
	
	public static void main(String[] args) {
		new UserMain().intro();
	}

	

}
