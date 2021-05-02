package com.javalec.Search;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
// test
public class Admin_FirstView_YJ {

	private JFrame frame;
	private JLabel lbBackGround;
	private JButton btnMenu;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnBrand;
	private JButton btnClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_FirstView_YJ window = new Admin_FirstView_YJ();
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
	public Admin_FirstView_YJ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnMenu());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtnBrand());
		frame.getContentPane().add(getBtnClient());
	}
	private JButton getBtnMenu() {
		if (btnMenu == null) {
			btnMenu = new JButton("메뉴관리");
			btnMenu.setForeground(Color.BLACK);
			btnMenu.setBounds(160, 394, 218, 39);
		}
		return btnMenu;
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
	private JButton getBtnBrand() {
		if (btnBrand == null) {
			btnBrand = new JButton("브랜드관리");
			btnBrand.setForeground(Color.BLACK);
			btnBrand.setBounds(160, 336, 218, 39);
		}
		return btnBrand;
	}
	private JButton getBtnClient() {
		if (btnClient == null) {
			btnClient = new JButton("고객관리");
			btnClient.setForeground(Color.BLACK);
			btnClient.setBounds(160, 274, 218, 39);
		}
		return btnClient;
	}
}
