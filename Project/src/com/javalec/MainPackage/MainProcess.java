package com.javalec.MainPackage;

import com.javalec.Search.Search_ch;

public class MainProcess {
	
	Search_ch search;  // 실행시킬 클래스

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	MainProcess main = new MainProcess();
	main.search = new Search_ch();
	main.search.setMain(main);
		

	}

}
