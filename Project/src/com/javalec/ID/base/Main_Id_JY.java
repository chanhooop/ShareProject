package com.javalec.ID.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.javalec.ID.function.DbAction_ID_JY;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Main_Id_JY {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1_1_1_2;
	private JLabel lblNewLabel_1_1_1_3;
	private JTextField tfTel;
	private JTextField tfName;
	private JButton btnOK;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Id_JY window = new Main_Id_JY();
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
	public Main_Id_JY() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("카페행");
		frame.setBounds(100, 100, 560, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1_1_1_2());
		frame.getContentPane().add(getLblNewLabel_1_1_1_3());
		frame.getContentPane().add(getTfTel());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnCancel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디 찾기");
			lblNewLabel.setFont(new Font("돋움", Font.BOLD, 35));
			lblNewLabel.setBounds(12, 10, 223, 66);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1_1_1_2() {
		if (lblNewLabel_1_1_1_2 == null) {
			lblNewLabel_1_1_1_2 = new JLabel("이름");
			lblNewLabel_1_1_1_2.setFont(new Font("돋움", Font.PLAIN, 23));
			lblNewLabel_1_1_1_2.setBounds(12, 89, 93, 47);
		}
		return lblNewLabel_1_1_1_2;
	}
	private JLabel getLblNewLabel_1_1_1_3() {
		if (lblNewLabel_1_1_1_3 == null) {
			lblNewLabel_1_1_1_3 = new JLabel("전화번호");
			lblNewLabel_1_1_1_3.setFont(new Font("돋움", Font.PLAIN, 23));
			lblNewLabel_1_1_1_3.setBounds(12, 146, 93, 47);
		}
		return lblNewLabel_1_1_1_3;
	}
	private JTextField getTfTel() {
		if (tfTel == null) {
			tfTel = new JTextField();
			tfTel.setColumns(10);
			tfTel.setBounds(147, 146, 237, 32);
		}
		return tfTel;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(147, 86, 237, 32);
		}
		return tfName;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("완료");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int chk = insertFieldCheck();
					
					if(chk == 0) {
						okAction();
					}

				}
			});
			btnOK.setFont(new Font("돋움", Font.PLAIN, 15));
			btnOK.setBounds(441, 476, 93, 40);
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cancelAction();
					
				}
			});
			btnCancel.setFont(new Font("돋움", Font.PLAIN, 15));
			btnCancel.setBounds(316, 476, 93, 40);
		}
		return btnCancel;
	}
	
	
	
	
	// Method
	
	// OK_btnOK
	private void okAction() {

		String userName = tfName.getText().trim();
		String userTelno = tfTel.getText().trim();		

		String findClientId = "";  // 초기화 선언

		DbAction_ID_JY dbAction_ID_JY = new DbAction_ID_JY(userName, userTelno);
		findClientId = dbAction_ID_JY.okAction();
		
		if (findClientId == "no") {
			JOptionPane.showMessageDialog(null, "입력하신 정보를 확인해주세요!");
		}else {
			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 아이디는 " + findClientId + " 입니다!");
		}

	}
	
	
	
	// 완료 버튼 : tf 중에서 빠진 부분이 있을 때
		private int insertFieldCheck() {	// void는 받는 게 없고 여기처럼 return하면 받아오는 값이 있는 것임
				
				int i = 0;
				String message = "";
				
				
				// tfName.getText().trim()의 길이가 0일때 = 넣은 텍스트가 없을 때 (trim()은 공백 제거)
				
				if(tfName.getText().trim().length() == 0) {
					i++;
					message = "이름을 ";
					tfName.requestFocus();
				}
				if(tfTel.getText().trim().length() == 0) {
					i++;
					message = "전화번호를 ";
					tfTel.requestFocus();
				}

				// i값이 0보다 클 때 = i값이 증가했을 때 = getText()가 없었을 때
				if(i > 0) {
					JOptionPane.showMessageDialog(null, message + "입력하세요.");
				}
				
				return i;
			}
	
	
	// 취소 : 초기화
		private void cancelAction() {
			tfName.setText("");
			tfTel.setText("");
		}

	
} // --------------------------------------
