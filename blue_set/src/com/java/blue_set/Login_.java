package com.java.blue_set;

class Login_ {

	boolean login_(String User, String Pass) {
		String User_ = "fluke", Pass_ = "1234";
		boolean User_check = User.equals(User_);
		boolean Pass_check = Pass.equals(Pass_);

		if (User_check & Pass_check) {
			System.out.print("Login_OK");
			return true;
		} else {
			System.out.print("Login fail");
			return false;
		}
	}
}
