package com.javalec.MainPackage;

import com.javalec.Search.Login_YJ;
import com.javalec.Search.Search_CH;



public class MainProcess {
	
	Login_YJ login_YJ;
	Search_CH search;  // 실행시킬 클래스를 변수 설정

	
	public static void main(String[] args) {
		System.out.println(1);
		MainProcess main = new MainProcess();
		System.out.println(2);
		main.login_YJ = new Login_YJ();
		System.out.println(3);
		main.login_YJ.setMain(main);		
		System.out.println(4);
		}
	
	public void showSearch_CH() {
		// TODO Auto-generated method stub
		login_YJ.dispose();
		search = new Search_CH();
		
	}



}
