package com.companyPort;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UserLogin implements UserProcess{
	
	ArrayList<UserInfo> users;
	
	//view
	UserView_login login;
	
	UserProcess controller;
	UserProcess [] process;
//	
//	public UserLogin() { //테스트용 정보
//		users.add(new UserInfo("user1", "user1@example.com", "123", "123"));
//		users.add(new UserInfo("user2", "user2@example.com", "pass", "pass"));
//	}

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
	    //사용자 입력 받기
	    String l_id = JOptionPane.showInputDialog("아이디를 입력해주세요");
	    String l_pw = JOptionPane.showInputDialog("비밀번호를 입력해주세요");

	    //null값, 값입력 없을시 메세지뜨게
	    if (l_id == null || l_pw == null || l_id.trim().isEmpty() || l_pw.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "정보를 입력해주세요");
	        return;
	    }


	    l_id = l_id.trim();//공백제거 equalsIgnoreCase 대소문자 무시
	    l_pw = l_pw.trim();

	    //관리자root면 로그인 (비번 상관없이 성공뜨게)
	    if ("root".equalsIgnoreCase(l_id)) { 
	        JOptionPane.showMessageDialog(null, "관리자 로그인");
	        return; // 관리자 로그인 후 일반 사용자 검사는 할 필요 없음
	    }

	    boolean Login_Success = false; //로그인 성공여부 기본값은 실패로

	    //로그인 확인
	    for (UserInfo temp : users) {
	        if (l_id.equals(temp.getId()) && l_pw.equals(temp.getPw())) {
	            JOptionPane.showMessageDialog(null, "로그인 성공");
	            Login_Success = true;
	            break;
	        }
	    }

	    //로그인 실패 시 메시지 출력
	    if (!Login_Success) {
	        JOptionPane.showMessageDialog(null, "로그인 실패");
	    }

//	    
//	    // 유저 리스트 탐색
//	    for (UserInfo temp : users) {
//	        if (l_id.equals(temp.getId()) && l_pw.equals(temp.getPw())) {
//	            if ("root".equals(l_id)) {
//	                JOptionPane.showMessageDialog(null, "관리자 로그인");
//	            } else {
//	                JOptionPane.showMessageDialog(null, "로그인 성공");
//	            }
//	            isLoginSuccess = true;
//	            break;
//	        }
//	    }

		}

	@Override
	public void exec(UserView_crud crud) {
		UserDAO dao = new UserDAO();
		dao.getConnection();
		ArrayList <UserInfo> list = dao.readAll(); //db연동 - 전체 데이터 가져오기
		
		
		
		
		
	}
		

}
