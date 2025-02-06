package com.companyPort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserUpdate implements UserProcess {
	@Override public void exec(ArrayList<UserInfo> users) {
		System.out.println(".....3. update");
		
		//사용자에게 수정할 번호 입력받기
		//사용자 수정할 이메일 입력받기
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디를 입력하세요 > ");
		String ck_id = scanner.next();
		System.out.println("비밀번호를 입력하세요 > ");
		String ck_pw = scanner.next();
		
		
		
		Iterator <UserInfo> iter = users.iterator();
		iter=users.iterator(); //줄을 서시오
		while(iter.hasNext()) {
			UserInfo temp = iter.next();
			if(!(temp.getId().equals(ck_id))) {
				System.out.println("아이디가 틀렸습니다. 다시 입력하세요");
				break;
			}else if(!(temp.getPw().equals(ck_pw))){
				System.out.println("비밀번호가 틀렸습니다. 다시 입력하세요");
				break;
			}
			else {
				System.out.println("수정할 이메일을 입력하세요 > ");
				String ck_email = scanner.next();
				temp.setEmail(ck_email);
				System.out.println(temp.getId()+"\t"+temp.getEmail()+"\t"+temp.getPw()+"\t"+temp.getPwck());
				break;
			}
		}
	}
}