package com.companyPort;

import java.util.ArrayList;

public class Test004_DB {

	public static void main(String[] args) {
		

	}

}
/* 
0. 기능
일정관리 회원관리
 		사용자측   관리자측
 create	  o			o
 read			  전체, 회원 검색
 update			  회원정보수정
 delete			  회원정보삭제

1. model(저장소)
------------------------
no	 id	 	email       pw  pwck	 date
------------------------
1   test  we@gmail.com  er  er    2025-01-23
 
 1-1. table 명 : userinfo
   no     숫자      0    필수입력         기본키
   id     varchar2(20)  필수입력 
   email  varchar2(20)  필수입력 
   pw     varchar2(20)  필수입력 
   pwck   varchar2(20)  필수입력
   date   timestamp     default currnet_timestamp
   
   create table userinfo (no number not null, id varchar2(20) not null primary key, email varchar2(20) not null, 
   							pw varchar2(20) not null, pwck varchar2(20) not null, 
   							udate timestamp default currnt_timestamp)
   
   sequence 명 : seq_userinfo
    
 1-2. crud(insert, select, delete, update)
   insert into userinfo (no, id, email, pw, pwck) values (seq_userinfo.nextval, 'aaa', 'sf@gmail.com', 'pw', 'pw')
   
   * 유저전체검색
    select * from userinfo;
   * 해당번호가 2번인 유저검색
 	select * from userinfo where no = 2;
   * 해당번호가 2번인 유저 이메일 수정
	update userinfo set email='sfs@gmail.com' where no = 2;
   * 해당유저가 2번인 유저 삭제 
   	delete from userinfo where no = 2; 
 	
 1-3. DTO
 
 1-4. DAO(Data Access Object)
 
2. controller(처리)

3. view(사용자화면)
*/