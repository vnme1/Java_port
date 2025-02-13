package com.companyPort;

import java.util.ArrayList;

public interface UserProcess {
	public void exec(ArrayList<UserInfo> users);

	public void exec(ArrayList<UserInfo> users, UserView_crud crud);

	//void exec(ArrayList<UserInfo> users, UserView_signin signin);//*
	

}
