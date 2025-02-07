package com.companyPort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;


public class Test001_model {
	public static void main(String[] args) {
		UserInfo user = new UserInfo("First@gmail.com","hi","pwpw","pwpw"); //이메일 비번 비번체크
		//System.out.println(user);
		
		
		//1.ArrayList Test
		//기차 index 0 중복허용가능 add/get/size/remove/contains
		ArrayList<UserInfo> list = new ArrayList<>();
		list.add(new UserInfo("two@naver.com","test1","pwee","pwee"));
		list.add(new UserInfo("three@naver.com","test2","iuiu","iuiu"));
		list.add(new UserInfo("four@naver.com","test3","aaa","aaa"));
		//System.out.println(list);
		
		//iterator이용해서 전체 데이터 출력  read
		Iterator <UserInfo> iter = list.iterator();
		while(iter.hasNext()) { //2. 처리대상 확인(hasNext)
			UserInfo temp = iter.next(); //3. 데이터 가져오기(next)
			//System.out.println(temp.getEmail()+"\t"+temp.getPw()+"\t"+temp.getPwck());
		}
		
		//no가 2이라면 tets@naver.com으로 데이터 변경  update
		iter=list.iterator(); //줄을 서시오
		while(iter.hasNext()) {
			UserInfo temp = iter.next();
			if(temp.getNo()==2) {
				temp.setEmail("tets@naver.com");
				break;
			}
		}System.out.println(list);
		
		//no가 2인 데이터 삭제  delete
		iter=list.iterator(); //줄을 서시오
		while(iter.hasNext()) {
			UserInfo temp = iter.next();
			if(temp.getNo()==2) {
				iter.remove();
				break;
			}
		}System.out.println(list);
	}
}
