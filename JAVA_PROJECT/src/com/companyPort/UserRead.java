package com.companyPort;

import java.util.ArrayList;
import java.util.Iterator;

public class UserRead implements UserProcess {
	@Override public void exec(ArrayList<UserInfo> users) {
		System.out.println(".....2. read");
		
		Iterator <UserInfo> iter = users.iterator();
		while(iter.hasNext()) { //2. 처리대상 확인(hasNext)
			UserInfo temp = iter.next(); //3. 데이터 가져오기(next)
			System.out.println(temp.getNo()+"\t"+temp.getId()+"\t"+temp.getEmail()+"\t"+temp.getPw()+"\t"+temp.getPwck()+"\t"+temp.getDate());
		}
	}

	@Override
	public void exec(ArrayList<UserInfo> users, UserView_crud crud) {
		
		
	}

}
