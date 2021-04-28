package com.javalec.Join.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.javalec.Join.function.DbAction_Join_JY_;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main_Join_JY {

	private JFrame frame;
	private JLabel lblJoin;
	private JLabel lblId;
	private JLabel lblPw;
	private JLabel lblPwCheck;
	private JLabel lblName;
	private JLabel lblTelno;
	private JLabel lblNick;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfNick;
	private JPasswordField pwtfPw;
	private JPasswordField pwtfPw2;
	private JButton btnId;
	private JButton btnNick;
	private JButton btnOK;
	private JButton btnCancel;
	private JLabel lblPwCheckText;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Join_JY window = new Main_Join_JY();
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
	public Main_Join_JY() {
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
		frame.getContentPane().add(getLblJoin());
		frame.getContentPane().add(getLblId());
		frame.getContentPane().add(getLblPw());
		frame.getContentPane().add(getLblPwCheck());
		frame.getContentPane().add(getLblName());
		frame.getContentPane().add(getLblTelno());
		frame.getContentPane().add(getLblNick());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfTel());
		frame.getContentPane().add(getTfNick());
		frame.getContentPane().add(getPwtfPw());
		frame.getContentPane().add(getPwtfPw2());
		frame.getContentPane().add(getBtnId());
		frame.getContentPane().add(getBtnNick());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getLblPwCheckText());
//		frame.getContentPane().add(getLblpw());
	}

	private JLabel getLblJoin() {
		if (lblJoin == null) {
			lblJoin = new JLabel("회원가입");
			lblJoin.setFont(new Font("돋움", Font.BOLD, 35));
			lblJoin.setBounds(12, 10, 161, 66);
		}
		return lblJoin;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("아이디");
			lblId.setFont(new Font("돋움", Font.PLAIN, 23));
			lblId.setBounds(12, 83, 78, 47);
		}
		return lblId;
	}

	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("비밀번호");
			lblPw.setFont(new Font("돋움", Font.PLAIN, 23));
			lblPw.setBounds(12, 148, 93, 47);
		}
		return lblPw;
	}

	private JLabel getLblPwCheck() {
		if (lblPwCheck == null) {
			lblPwCheck = new JLabel("비밀번호확인");
			lblPwCheck.setFont(new Font("돋움", Font.PLAIN, 23));
			lblPwCheck.setBounds(12, 215, 140, 47);
		}
		return lblPwCheck;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름");
			lblName.setFont(new Font("돋움", Font.PLAIN, 23));
			lblName.setBounds(12, 280, 93, 47);
		}
		return lblName;
	}

	private JLabel getLblTelno() {
		if (lblTelno == null) {
			lblTelno = new JLabel("전화번호");
			lblTelno.setFont(new Font("돋움", Font.PLAIN, 23));
			lblTelno.setBounds(12, 347, 93, 47);
		}
		return lblTelno;
	}

	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("닉네임");
			lblNick.setFont(new Font("돋움", Font.PLAIN, 23));
			lblNick.setBounds(12, 414, 93, 47);
		}
		return lblNick;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(164, 86, 237, 32);
		}
		return tfId;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(164, 280, 237, 32);
		}
		return tfName;
	}

	private JTextField getTfTel() {
		if (tfTel == null) {
			tfTel = new JTextField();
			tfTel.setColumns(10);
			tfTel.setBounds(164, 347, 237, 32);
		}
		return tfTel;
	}

	private JTextField getTfNick() {
		if (tfNick == null) {
			tfNick = new JTextField();
			tfNick.setColumns(10);
			tfNick.setBounds(164, 414, 237, 32);
		}
		return tfNick;
	}

	private JPasswordField getPwtfPw() {
		if (pwtfPw == null) {
			pwtfPw = new JPasswordField();
			pwtfPw.setBounds(164, 148, 237, 32);
		}
		return pwtfPw;
	}

	private JPasswordField getPwtfPw2() {
		if (pwtfPw2 == null) {
			pwtfPw2 = new JPasswordField();
			pwtfPw2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					pwCheckAction();
					
				}
			});
			pwtfPw2.setBounds(164, 215, 237, 32);
		}
		return pwtfPw2;
	}

	private JButton getBtnId() {
		if (btnId == null) {
			btnId = new JButton("중복확인");
			btnId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					checkIdAction();
					
				}
			});
			btnId.setFont(new Font("돋움", Font.PLAIN, 15));
			btnId.setBounds(413, 83, 121, 40);
		}
		return btnId;
	}

	private JButton getBtnNick() {
		if (btnNick == null) {
			btnNick = new JButton("중복확인");
			btnNick.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					checkNickAction();
					
				}
			});
			btnNick.setFont(new Font("돋움", Font.PLAIN, 15));
			btnNick.setBounds(413, 406, 121, 40);
		}
		return btnNick;
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
			btnOK.setBounds(433, 491, 93, 40);
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
			btnCancel.setBounds(308, 491, 93, 40);
		}
		return btnCancel;
	}
	
	private JLabel getLblPwCheckText() {
		if (lblPwCheckText == null) {
			lblPwCheckText = new JLabel("");
			lblPwCheckText.setBounds(164, 257, 237, 15);
		}
		return lblPwCheckText;
	}


	// -----------------------------
	// Method
	// -----------------------------
	
	// 완료 버튼(회원가입)
	private void okAction() {
		
		String id = tfId.getText().trim();
//		String pw = pwtfPw.getPassword().toString();
		char[] str = pwtfPw.getPassword();
		String pw = new String(str);
		char[] str2 = pwtfPw2.getPassword();
		String pw2 = new String(str2);
//		String pw2= pwtfPw2.getPassword().toString();
		String name = tfName.getText().trim();
		String telno = tfTel.getText().trim();
		String nick = tfNick.getText().trim();		
//		System.out.println(pw2);
				
		if(pw.equals(pw2)) {
			
			DbAction_Join_JY_ dbAction_Join_JY_ = new DbAction_Join_JY_(id, pw, name, telno, nick);
			boolean msg = dbAction_Join_JY_.okAction();
			
			if(msg == true) {
				JOptionPane.showMessageDialog(null, tfName.getText() + "님의 회원가입이 완료되었습니다!");
			} 
		} 
	}
	
	// 완료 버튼 : tf 중에서 빠진 부분이 있을 때
		private int insertFieldCheck() {	
			
				int i = 0;
				String message = "";

				if(tfId.getText().trim().length() == 0) {
					i++;					// 넣은 텍스트 없으면 i값 증가
					message = "아이디를 ";		// tfName에 텍스트가 없을 때 나올 메세지의 정보
					tfId.requestFocus();	// .requestFocus() 커서 깜빡이 위치로 해주기
				}
				if(pwtfPw.getPassword().toString().length() == 0) {  //.length() : 글자의 개수 /를 말하는 건데 여기서는 글자의 개수가 0일 때를 말하니깐
					i++;
					message = "비밀번호를 ";
					pwtfPw.requestFocus();
				}
				if(pwtfPw2.getPassword().toString().length() == 0) {
					i++;
					message = "비밀번호 확인을 ";
					pwtfPw2.requestFocus();
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
				if(tfNick.getText().trim().length() == 0) {
					i++;
					message = "닉네임을 ";
					tfNick.requestFocus();
				}
				
				// i값이 0보다 클 때 = i값이 증가했을 때 = getText()가 없었을 때
				if(i > 0) {
					JOptionPane.showMessageDialog(null, message + "입력하세요.");
				}
				
				return i;
			}
		
		// 비밀번호 동일 or 아님
		
		private void pwCheckAction() {
			
			// pw
			char[] str = pwtfPw.getPassword();
			String pw = new String(str);
			
			// pw2
			char[] str2 = pwtfPw2.getPassword();
			String pw2 = new String(str2);

			
			if(pw.equals(pw2)) {
				lblPwCheckText.setText("비밀번호와 동일합니다.");
			}else {
				lblPwCheckText.setText("비밀번호와 동일하지 않습니다.");
			}
				
		}
		
		
		// 아이디 중복 확인
		private void checkIdAction() {
			String wkId = tfId.getText().trim();
			
			DbAction_Join_JY_ dbAction_Join_JY_ = new DbAction_Join_JY_();
			boolean checkIdAction = dbAction_Join_JY_.checkIdAction(wkId);
			// boolean : 무조건 true 아니면 false이니깐 if문 사용시 if-else만 써도 가능
			
			if (checkIdAction == true) {
				JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다!");
			} else  {
				JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다!");	
			}			
		}
		
		// 닉네임 중복 확인
		private void checkNickAction() {
			String wkNick = tfNick.getText().trim();
			
			DbAction_Join_JY_ dbAction_Join_JY_ = new DbAction_Join_JY_();
			boolean checkNickAction = dbAction_Join_JY_.checkNickAction(wkNick);
			
			if (checkNickAction == true) {
				JOptionPane.showMessageDialog(null, "사용 가능한 닉네임입니다!");
			} else  {
				JOptionPane.showMessageDialog(null, "이미 사용중인 닉네임입니다!");	
			}
		}
		
		
		// 취소 : 초기화
		private void cancelAction() {
			tfId.setText("");
			pwtfPw.setText("");
			pwtfPw2.setText("");
			tfName.setText("");
			tfTel.setText("");
			tfNick.setText("");
		}
		

	
} // ----------------
