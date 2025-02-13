package com.companyPort;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

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

	@Override
	public void exec(UserView_crud crud) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		dao.getConnection();
		ArrayList <UserInfo> list = dao.readAll();
		
		//화면테이블 초기화
		DefaultTableModel model = (DefaultTableModel) crud.table.getModel();
		model.setNumRows(0);
		
		//화면데이터 가져오기
		Iterator <UserInfo> iter = list.iterator(); //리스트 줄서기
		while(iter.hasNext()) {
			UserInfo temp = iter.next();
			Object[] data = { temp.getNo(), temp.getId(), temp.getEmail(), temp.getDate()}; //날짜 
			crud.model.addRow(data);
		}
	}

}
