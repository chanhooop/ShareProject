package com.javalec.MainPackage;

import com.javalec.Search.Client_Mypage_YJ;
import com.javalec.Search.Search_CH;


public class MainProcess {
	
	Search_CH search;  // 실행시킬 클래스를 변수 설정
	Client_Mypage_YJ client_Mypage_YJ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	MainProcess main = new MainProcess();
	main.search = new Search_CH(); 
	main.search.setMain(main);
		
	}
	
	public void MypageOpen() {
	 	
//		search.dispose();
		this.client_Mypage_YJ = new Client_Mypage_YJ();


		
	}

}
