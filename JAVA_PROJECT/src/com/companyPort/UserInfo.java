package com.companyPort;

import java.util.Calendar;

public class UserInfo {
	
	public static int cnt=0;
	private int no=0;
	private String id;
	private String email;
	
	
	private String pw;
	private String pwck;
	private String date;	
	public UserInfo() { super(); }
	
	public UserInfo(int no, String id, String email, String pw, String pwck,String date) {
		super();
		this.cnt = cnt;
		this.no = no;
		this.id = id;
		this.email = email;
		
		this.pw = pw;
		this.pwck = pwck;
		this.date = date;
	}//여기 수정
	public UserInfo(String id, String email,  String pw, String pwck) {
//		this.no=++cnt;  //sequence 때문에 필요없 주석처리
		this.id = id;
		this.email = email;
		
		this.pw = pw;
		this.pwck = pwck;
		Calendar today = Calendar.getInstance();
		this.date = today.get(1) + "-" + today.get(2) + "-" + today.get(5);
		/*
		 Calendar today = Calendar.getInstance();
		 this.date = today.get(1) + "-" + today.get(2) + "-" + today.get(5);
		 				년						월					일
		 */
	}//사용자가 넣을 값들만

	@Override
	public String toString() {
		return "UserInfo [cnt=" + cnt + ", no=" + no + ",id=" + id+", email=" + email + ", pw=" + pw + ", pwck=" + pwck + ", date=" + date + "]";
	}
	public int getCnt() { return cnt; }
	public void setCnt(int cnt) { this.cnt = cnt; }
	public int getNo() { return no; }
	public void setNo(int no) { this.no = no; }
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getPw() { return pw; }
	public void setPw(String pw) { this.pw = pw; }
	public String getPwck() { return pwck; }
	public void setPwck(String pwck) { this.pwck = pwck; }
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	

}

/*
crud
회원등록
회원확인
회원수정
회원삭제

일정등록
일정수정
일정삭제
일정등록한 회원확인



 */