package com.javalec.Search;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.javalec.dbaction.DbAction_Join_CJY;

public class Main_Join_CJY extends JFrame{

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
					Main_Join_CJY window = new Main_Join_CJY();
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
	public Main_Join_CJY() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("카페행");
		frame.setBounds(100, 100, 545, 478);
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
			lblJoin.setFont(new Font("돋움", Font.BOLD, 20));
			lblJoin.setBounds(12, 10, 93, 40);
		}
		return lblJoin;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("아이디");
			lblId.setFont(new Font("돋움", Font.PLAIN, 13));
			lblId.setBounds(63, 59, 59, 26);
		}
		return lblId;
	}

	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("비밀번호");
			lblPw.setFont(new Font("돋움", Font.PLAIN, 13));
			lblPw.setBounds(63, 111, 66, 26);
		}
		return lblPw;
	}

	private JLabel getLblPwCheck() {
		if (lblPwCheck == null) {
			lblPwCheck = new JLabel("비밀번호확인");
			lblPwCheck.setFont(new Font("돋움", Font.PLAIN, 13));
			lblPwCheck.setBounds(53, 164, 93, 26);
		}
		return lblPwCheck;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름");
			lblName.setFont(new Font("돋움", Font.PLAIN, 13));
			lblName.setBounds(63, 215, 59, 26);
		}
		return lblName;
	}

	private JLabel getLblTelno() {
		if (lblTelno == null) {
			lblTelno = new JLabel("전화번호");
			lblTelno.setFont(new Font("돋움", Font.PLAIN, 13));
			lblTelno.setBounds(63, 265, 66, 26);
		}
		return lblTelno;
	}

	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("닉네임");
			lblNick.setFont(new Font("돋움", Font.PLAIN, 13));
			lblNick.setBounds(63, 317, 69, 26);
		}
		return lblNick;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(141, 60, 225, 26);
		}
		return tfId;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(141, 215, 225, 26);
		}
		return tfName;
	}

	private JTextField getTfTel() {
		if (tfTel == null) {
			tfTel = new JTextField();
			tfTel.setColumns(10);
			tfTel.setBounds(141, 266, 225, 26);
		}
		return tfTel;
	}

	private JTextField getTfNick() {
		if (tfNick == null) {
			tfNick = new JTextField();
			tfNick.setColumns(10);
			tfNick.setBounds(141, 318, 225, 26);
		}
		return tfNick;
	}

	private JPasswordField getPwtfPw() {
		if (pwtfPw == null) {
			pwtfPw = new JPasswordField();
			pwtfPw.setBounds(141, 112, 225, 26);
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
			pwtfPw2.setBounds(141, 165, 225, 26);
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
			btnId.setFont(new Font("돋움", Font.PLAIN, 13));
			btnId.setBounds(378, 60, 97, 26);
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
			btnNick.setFont(new Font("돋움", Font.PLAIN, 13));
			btnNick.setBounds(378, 318, 97, 25);
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
			btnOK.setFont(new Font("돋움", Font.PLAIN, 13));
			btnOK.setBounds(394, 372, 81, 32);
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
			btnCancel.setFont(new Font("돋움", Font.PLAIN, 13));
			btnCancel.setBounds(285, 372, 81, 32);
		}
		return btnCancel;
	}
	
	private JLabel getLblPwCheckText() {
		if (lblPwCheckText == null) {
			lblPwCheckText = new JLabel("");
			lblPwCheckText.setBounds(141, 190, 237, 15);
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
			
			DbAction_Join_CJY dbAction_Join_CJY = new DbAction_Join_CJY(id, pw, name, telno, nick);
			boolean msg = dbAction_Join_CJY.okAction();
			
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
					JOptionPane.showMessageDialog(null, message + "입력하세요.", "회원가입", JOptionPane.WARNING_MESSAGE);
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
			
			DbAction_Join_CJY dbAction_Join_CJY = new DbAction_Join_CJY();
			boolean checkIdAction = dbAction_Join_CJY.checkIdAction(wkId);
			// boolean : 무조건 true 아니면 false이니깐 if문 사용시 if-else만 써도 가능
			
			if (checkIdAction == true) {
				JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다!");
			} else  {
				JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다!", "아이디 중복 확인", JOptionPane.WARNING_MESSAGE);	
			}			
		}
		
		// 닉네임 중복 확인
		private void checkNickAction() {
			String wkNick = tfNick.getText().trim();
			
			DbAction_Join_CJY dbAction_Join_CJY = new DbAction_Join_CJY();
			boolean checkNickAction = dbAction_Join_CJY.checkNickAction(wkNick);
			
			if (checkNickAction == true) {
				JOptionPane.showMessageDialog(null, "사용 가능한 닉네임입니다!");
			} else  {
				JOptionPane.showMessageDialog(null, "이미 사용중인 닉네임입니다!", "닉네임 중복 확인", JOptionPane.WARNING_MESSAGE);	
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
