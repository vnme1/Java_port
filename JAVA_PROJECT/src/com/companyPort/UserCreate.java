package com.companyPort;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

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

	@Override
	public void exec(ArrayList<UserInfo> users, UserView_crud crud) {
		
		
		// 알림창으로 입력받기
//		String c_id = JOptionPane.showInputDialog("아이디를 입력해주세요");
//		String c_email = JOptionPane.showInputDialog("이메일을 입력해주세요");
//		String c_pw = JOptionPane.showInputDialog("비밀번호를 입력해주세요");
//		String c_pwck = JOptionPane.showInputDialog("비밀번호를 다시 입력해주세요");
		// model 데이터 저장 - ArrayList에 데이터 채우기
		String result ="";
//		System.out.println(c_pw);
//		System.out.println(c_pwck);
//		result = (c_pw.equals(c_pwck)? "성공":"실패");
//		System.out.println(result);
		

		
		for(;;) {
			String c_id = JOptionPane.showInputDialog("아이디를 입력해주세요");
	        if (c_id == null || c_id.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
	            continue;
	        }

	        boolean isDuplicate = false;
	        for (UserInfo temp : users) {
	            if (c_id.equals(temp.getId())) {
	                JOptionPane.showMessageDialog(null, "아이디가 이미 존재합니다. 다시 입력해주세요.");
	                isDuplicate = true;
	                break;
	            }
	        }
	        if (isDuplicate) continue;  // 중복된 경우 다시 입력

			String c_email = JOptionPane.showInputDialog("이메일을 입력해주세요");
			String c_pw = JOptionPane.showInputDialog("비밀번호를 입력해주세요");
			String c_pwck = JOptionPane.showInputDialog("비밀번호를 다시 입력해주세요");
			if(c_pw.equals(c_pwck)) {
					JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다.");
					users.add(new UserInfo(c_id,c_email,c_pw,c_pwck));
					// view 화면갱신 - crud
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
					Object[] data = {UserInfo.cnt,c_id,c_email,sdf.format(System.currentTimeMillis())}; //날짜 추가
					crud.model.addRow(data);
					break;
			}else {
				JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인해주세요.");
				continue;
					}
			
		}
		
//		if(c_pw.equals(c_pwck)) {
//			JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다.");
//			users.add(new UserInfo(c_id,c_email,c_pw,c_pwck));
//			// view 화면갱신 - crud
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//			Object[] data = {UserInfo.cnt,c_id,c_email,sdf.format(System.currentTimeMillis())}; //날짜 추가
//			crud.model.addRow(data);
//		}else {
//			JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다..");
//		}
////		
		
		
		//전체 데이터 불러오기 도전!
	}

}
