package com.companyPort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UserUpdate implements UserProcess {
	Scanner scanner = new Scanner(System.in);
	
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

	@Override
	public void exec(ArrayList<UserInfo> users, UserView_crud crud) {
		//1. user id입력
		//String id = String.v
		int no = Integer.parseInt(JOptionPane.showInputDialog("수정할 번호를 입력해주세요."));
		//2. 수정할 이메일 입력받기
		String email = JOptionPane.showInputDialog("수정할 이메일을 입력해주세요");
		//3. model(저장수) - 해당번호의 데이터 찾아서 수정
		
		int find=-1; int cnt= 0;
		Iterator<UserInfo> iter = users.iterator(); //줄을 서시오
		while(iter.hasNext()) {
			if(iter.next().getNo() == no) {//꺼내와서 비교
				find=cnt;
				break;
			}
			cnt++; //iterator은 번호체크가 힘들다
		}
		if(find==-1) {
			JOptionPane.showMessageDialog(null, "번호를 확인해주세요");
			return;
		}
		users.get(cnt).setEmail(email);
		//4. view - 수정된 데이터 처리
		crud.model.setValueAt(email, cnt, 2); //어떤값을 몇번쨰줄 몇번째칸
		
		
	}

	@Override
	public void exec(UserView_crud crud) {
		//1.유저번호 / 이메일 입력받기
		int no = Integer.parseInt(JOptionPane.showInputDialog("수정할 번호를 입력해주세요."));
		//2. 수정할 이메일 입력받기
		String email = JOptionPane.showInputDialog("수정할 이메일을 입력해주세요");
		
	    no = scanner.nextInt(); // 정수 입력 받기
		
		if(email == null || email.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "정보를 입력해주세요");
		    return;
		}
		//3. model(저장수) - 해당번호의 데이터 찾아서 수정
				
		//2.db에서 수정

		UserDAO dao   = new UserDAO();  dao.getConnection();
		UserInfo user = new UserInfo();  user.setNo(no);   user.setEmail(email);
		dao.update(user);
		//3. 화면처리
		new UserRead().exec(crud);
		
	
	}
}