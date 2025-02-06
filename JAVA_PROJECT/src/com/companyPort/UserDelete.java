package com.companyPort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

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

	@Override
	public void exec(ArrayList<UserInfo> users, UserView_crud crud) {
		//1. user id입력
		//String id = String.v
		int no = Integer.parseInt(JOptionPane.showInputDialog("삭제할 번호를 입력해주세요."));
		//String c_id = JOptionPane.showInputDialog("삭제할 아이디를 입력해주세요");

		//2. model(저장수) - 해당번호의 데이터 찾아서 삭제
				
		int find=-1; int cnt= 0;
		Iterator<UserInfo> iter = users.iterator(); //줄을 서시오
		while(iter.hasNext()) { //해당 데이터 있는지 확인
			if(iter.next().getNo() == no) {
				find=cnt;
				iter.remove();
				break;
			}//꺼내와서 비교
				cnt++; //iterator은 index카운트가 힘들다
		}
		if(find==-1) {
			JOptionPane.showMessageDialog(null, "번호를 확인해주세요");
			return;
		}
		//4. view - 수정된 데이터 처리
		crud.model.removeRow(cnt);; //어떤값을 몇번쨰줄 몇번째칸				
		
	}
}
