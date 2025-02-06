package com.companyPort;

import java.util.ArrayList;
import java.util.Scanner;

public class UserCreate implements UserProcess {
	@Override public void exec(ArrayList<UserInfo> users) {
		System.out.println(".....1. create");
		
		
		Scanner scanner = new Scanner(System.in);
		
		for(;;) {
			System.out.println("아이디를 입력하세요");
			String c_id = scanner.next();
					
			System.out.println("이메일을 입력하세요");
			String c_email = scanner.next();

			System.out.println("비밀번호를 입력하세요");
			String c_pw = scanner.next();
			
			System.out.println("비밀번호를 다시 입력하세요");
			String c_pwck = scanner.next();
			
			if(c_pw != c_pwck) {
				System.out.println("비밀번호를 다시 확인해주세요");
				continue;
			}else {
				users.add(new UserInfo(c_id,c_email,c_pw,c_pwck));
				break;
			}
		}
		
		
	}

}
