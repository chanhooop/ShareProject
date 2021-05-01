package com.javalec.MainPackage;

import com.javalec.Search.Login_YJ;
import com.javalec.Search.Search_CH;



public class MainProcess {
	
	Login_YJ login_YJ;
	Search_CH search;  // 실행시킬 클래스를 변수 설정

	
	public static void main(String[] args) {
		MainProcess main = new MainProcess();
		main.login_YJ = new Login_YJ();
		main.login_YJ.setMain(main);		
		}
	
	public void showSearch_CH() {
		// TODO Auto-generated method stub
		login_YJ.dispose();
		search = new Search_CH();
		
	}



}
