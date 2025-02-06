package com.companyPort;

import java.util.ArrayList;
import java.util.Scanner;

public class Test002_controller {
	public static void main(String[] args) {
		ArrayList<UserInfo> list = new ArrayList<>();
		list.add(new UserInfo("test1","two@naver.com","pwee","pwee"));
		list.add(new UserInfo("test2","three@naver.com","iuiu","iuiu"));
		list.add(new UserInfo("test3","four@naver.com","aaa","aaa"));
		//System.out.println(list);
		
		Scanner scanner = new Scanner(System.in);
		UserProcess controller = null; //부모 - 인터페이스 - 설계
		UserProcess [] crud = {
				new UserCreate(), new UserRead(), new UserUpdate(), new UserDelete()
		};	
		//무한반복
		
		//번호입력받기
		for(;;) {
			System.out.println("번호를 입력하세요");
			int num = scanner.nextInt();
			if(num == 1) {
				controller = crud[0]; controller.exec(list);
			}else if(num==2) {
				controller = crud[1]; controller.exec(list);
			}else if(num==3) {
				controller = crud[2]; controller.exec(list);
			}else if(num==4) {
				controller = crud[3]; controller.exec(list);
			}else if(num==5) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("다시 입력하세요.");
			}		
		}		
//		switch(num) {
//		case 1:
//			controller = crud[0]; controller.exec(null);
//			break;
//		}		
	}
}
