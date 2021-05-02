package com.javalec.Search;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.javalec.bean.Bean_Client_FirstView_YJ;
import com.javalec.dbaction.DbAction_Client_FirstView_YJ;

public class Client_FirstView_YJ {

	private JFrame frame;
	private JLabel lbBackGround;
	private JButton btnSerch;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	String adminLogin = "", adminOnOff = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_FirstView_YJ window = new Client_FirstView_YJ();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client_FirstView_YJ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				adminLoginInfo();
			}
		});
		frame.setBounds(100, 100, 545, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnSerch());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
	}

	private JButton getBtnSerch() {
		if (btnSerch == null) {
			btnSerch = new JButton("검색하러가기");
			btnSerch.setForeground(Color.BLACK);
			btnSerch.setBounds(160, 394, 218, 39);
		}
		return btnSerch;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("로그아웃");
			lblNewLabel.setBounds(478, 16, 61, 16);
			lblNewLabel.setForeground(Color.white);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("카페행");
			lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 43));
			lblNewLabel_1.setBounds(215, 77, 116, 79);
			lblNewLabel_1.setForeground(Color.white);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("강한 이끌림, 현대인의 필수품");
			lblNewLabel_2.setBounds(199, 148, 148, 15);
			lblNewLabel_2.setForeground(Color.white);
		}
		return lblNewLabel_2;
	}

	private void adminLoginInfo() {
		DbAction_Client_FirstView_YJ dbAction = new DbAction_Client_FirstView_YJ();
		Bean_Client_FirstView_YJ bean = dbAction.login(); // 엑션실행 해서 빈에다 로그인정보 저장
		adminLogin = bean.getAdminLogin(); // 저장되어있는 로그인정보를 필드변수에 저장
		adminOnOff = bean.getAdminOnoff();
		System.out.println(adminLogin + adminOnOff);

	}
}
