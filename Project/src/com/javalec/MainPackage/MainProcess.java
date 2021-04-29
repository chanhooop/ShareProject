package com.javalec.MainPackage;

import com.javalec.Search.Search_CH;

public class MainProcess {
	
	Search_CH search;  // 실행시킬 클래스

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	MainProcess main = new MainProcess();
	main.search = new Search_CH();
	main.search.setMain(main);
		

	}

}
