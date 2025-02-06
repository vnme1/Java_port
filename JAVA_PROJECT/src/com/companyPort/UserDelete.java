package com.companyPort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserDelete implements UserProcess {
	@Override public void exec(ArrayList<UserInfo> users) {
		System.out.println(".....4. delete");
		
		Iterator <UserInfo> iter = users.iterator();
		iter=users.iterator(); //줄을 서시오
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("no > ");
		int no = scanner.nextInt();
		while(iter.hasNext()) {
			UserInfo temp = iter.next();
			if(temp.getNo()==no) {
				iter.remove();
				System.out.println(temp.getId()+"\t"+temp.getEmail()+"\t"+temp.getPw()+"\t"+temp.getPwck());
				break;
			}
		}
	}

}
