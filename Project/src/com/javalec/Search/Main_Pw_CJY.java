package com.javalec.Search;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.dbaction.DbAction_Pw_CJY;

public class Main_Pw_CJY {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1_1_1_2;
	private JLabel lblNewLabel_1_1_1_3;
	private JTextField tfId;
	private JTextField tfName;
	private JButton btnCancal;
	private JButton btnOK;
	private JLabel lblNewLabel_1_1_1_3_1;
	private JTextField tfTel;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Pw_CJY window = new Main_Pw_CJY();
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
	public Main_Pw_CJY() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("카페행");
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1_1_1_2());
		frame.getContentPane().add(getLblNewLabel_1_1_1_3());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getBtnCancal());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getLblNewLabel_1_1_1_3_1());
		frame.getContentPane().add(getTfTel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("비밀번호 찾기");
			lblNewLabel.setFont(new Font("돋움", Font.BOLD, 20));
			lblNewLabel.setBounds(28, 29, 160, 32);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1_1_1_2() {
		if (lblNewLabel_1_1_1_2 == null) {
			lblNewLabel_1_1_1_2 = new JLabel("아이디");
			lblNewLabel_1_1_1_2.setFont(new Font("돋움", Font.PLAIN, 13));
			lblNewLabel_1_1_1_2.setBounds(49, 71, 56, 32);
		}
		return lblNewLabel_1_1_1_2;
	}
	private JLabel getLblNewLabel_1_1_1_3() {
		if (lblNewLabel_1_1_1_3 == null) {
			lblNewLabel_1_1_1_3 = new JLabel("이름");
			lblNewLabel_1_1_1_3.setFont(new Font("돋움", Font.PLAIN, 13));
			lblNewLabel_1_1_1_3.setBounds(49, 121, 56, 32);
		}
		return lblNewLabel_1_1_1_3;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(147, 72, 237, 32);
		}
		return tfId;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(147, 122, 237, 32);
		}
		return tfName;
	}
	private JButton getBtnCancal() {
		if (btnCancal == null) {
			btnCancal = new JButton("취소");
			btnCancal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cancelAction();
					
				}
			});
			btnCancal.setFont(new Font("돋움", Font.PLAIN, 13));
			btnCancal.setBounds(257, 241, 93, 40);
		}
		return btnCancal;
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
			btnOK.setFont(new Font("돋움", Font.PLAIN, 13));
			btnOK.setBounds(381, 241, 93, 40);
		}
		return btnOK;
	}
	private JLabel getLblNewLabel_1_1_1_3_1() {
		if (lblNewLabel_1_1_1_3_1 == null) {
			lblNewLabel_1_1_1_3_1 = new JLabel("전화번호");
			lblNewLabel_1_1_1_3_1.setFont(new Font("돋움", Font.PLAIN, 13));
			lblNewLabel_1_1_1_3_1.setBounds(49, 173, 68, 32);
		}
		return lblNewLabel_1_1_1_3_1;
	}
	private JTextField getTfTel() {
		if (tfTel == null) {
			tfTel = new JTextField();
			tfTel.setColumns(10);
			tfTel.setBounds(147, 174, 237, 32);
		}
		return tfTel;
	}
	
	
	// Method

	// 완료_btnOK (아이디, 이름, 전화번호)
	private void okAction() {
		
		String userId = tfId.getText().trim();
		String userName = tfName.getText().trim();
		String userTelno = tfTel.getText().trim();		
		
		String findClientPw = "";  // 초기화 선언
			
		DbAction_Pw_CJY dbAction_Pw_CJY = new DbAction_Pw_CJY(userId, userName, userTelno);
		findClientPw = dbAction_Pw_CJY.okAction();
		
		if (findClientPw == "no") {
			JOptionPane.showMessageDialog(null, "입력하신 정보를 확인해주세요!", "비밀번호 찾기", JOptionPane.WARNING_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 비밀번호는 " + findClientPw + " 입니다!");
		}
			
	}
	
	// 완료 버튼 : tf 중에서 빠진 부분이 있을 때
		private int insertFieldCheck() {	// void는 받는 게 없고 여기처럼 return하면 받아오는 값이 있는 것임
				
				int i = 0;
				String message = "";
				
				// tfName.getText().trim()의 길이가 0일때 = 넣은 텍스트가 없을 때 (trim()은 공백 제거)
				if(tfId.getText().trim().length() == 0) {
					i++;					// 넣은 텍스트 없으면 i값 증가
					message = "아이디를 ";		// tfName에 텍스트가 없을 때 나올 메세지의 정보
					tfId.requestFocus();	// .requestFocus() 커서 깜빡이 위치로 해주기
				}
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
					JOptionPane.showMessageDialog(null, message + "입력하세요.", "비밀번호 찾기", JOptionPane.WARNING_MESSAGE);
				}
				
				return i;
			}
		
		// 취소 : 초기화
		private void cancelAction() {
			tfId.setText("");
			tfName.setText("");
			tfTel.setText("");
		}
	
	
} // -------------------------------------------
