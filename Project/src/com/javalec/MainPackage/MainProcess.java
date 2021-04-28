package com.javalec.MainPackage;

import com.javalec.Search.Search;

public class MainProcess {
	
	Search search;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	MainProcess main = new MainProcess();
	main.search = new Search();
	main.search.setMain(main);
		

	}

}
