package com.companyPort;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class UserLogin implements UserProcess{

	@Override
	public void exec(ArrayList<UserInfo> users) {
		System.out.println("...... 로그인");
		
		Iterator <UserInfo> iter = users.iterator();
		while(iter.hasNext()) { //2. 처리대상 확인(hasNext)
			UserInfo temp = iter.next(); //3. 데이터 가져오기(next)
//			System.out.println(temp.getNo()+"\t"+temp.getId()+"\t"+temp.getEmail()+"\t"+temp.getPw()+"\t"+temp.getPwck()+"\t"+temp.getDate());
			
		}
		
		
	}
	@Override
	public void exec(ArrayList<UserInfo> users, UserView_crud crud) {
		//1. user id입력

		String l_id = JOptionPane.showInputDialog("아이디를 입력해주세요");
		String l_pw = JOptionPane.showInputDialog("비밀번호를 입력해주세요");

		Iterator<UserInfo> iter = users.iterator(); //줄을 서시오
		while(iter.hasNext()) {
				if(iter.next().getId() == l_id && iter.next().getPw()==l_pw) {//꺼내와서 비교
					JOptionPane.showMessageDialog(null, "로그인 성공");
					break;
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
					break;
				}
			}
			if(l_id==null||l_pw==null) {
				JOptionPane.showMessageDialog(null, "정보를 입력해주세요");
				return;
			}

	}

}
