package com.javalec.Search;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.javalec.MainPackage.MainProcess;
import com.javalec.bean.Bean_Mypage_YJ;
import com.javalec.dbaction.DbAction_Mypage_YJ;

public class Client_Mypage_YJ extends JFrame {

	private MainProcess main;
	
	
	private JFrame frame;
	private JLabel lbAdminLogo;
	private JLabel lbMainSlogan;
	private JRadioButton rdbtnClient;
	private JRadioButton rdbtnAdmin;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lbId;
	private JTextField tfId;
	private JLabel lbPw;
	private JPasswordField pfPW;
	private JButton btnRogin;
	private JLabel lbMainLogo;

	// Table 환경 정의
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lbTest;
	private JLabel lbMainImg;
	private JLabel lbMypage;
	private JLabel lbMypageId;
	private JTextField tfMypageId;
	private JLabel lbMypagePw;
	private JPasswordField pwfMypagePw;
	private JLabel lbMypagePwCheck;
	private JPasswordField pwfMypagePwCheck;
	private JLabel lbMypageName;
	private JTextField tfMypageName;
	private JLabel lbMypageTelno;
	private JTextField tfMypageTelno;
	private JLabel lbMypageNick;
	private JTextField tfMypageNick;
	private JButton btnOverlap;
	private String userId;
	private JLabel lbPwCheckStr;
	private JButton btnMypageReset;
	private JButton btnMypageCancel;
	private JButton btnMypageResetOk;
	private String wkId = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Mypage_YJ window = new Client_Mypage_YJ();
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
	public Client_Mypage_YJ() {
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
//				getMypage();
			}
		});
		frame.setTitle("카페행");
		frame.setBounds(100, 100, 545, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLbAdminLogo());
		frame.getContentPane().add(getLbMainSlogan());
		frame.getContentPane().add(getRdbtnClient());
		frame.getContentPane().add(getRdbtnAdmin());
		frame.getContentPane().add(getLbId());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getLbPw());
		frame.getContentPane().add(getPfPW());
		frame.getContentPane().add(getBtnRogin());
		frame.getContentPane().add(getLbMainLogo());
		frame.getContentPane().add(getLbMainImg());
		frame.getContentPane().add(getLbMypage());
		frame.getContentPane().add(getLbMypageId());
		frame.getContentPane().add(getTfMypageId());
		frame.getContentPane().add(getLbMypagePw());
		frame.getContentPane().add(getPwfMypagePw());
		frame.getContentPane().add(getLbMypagePwCheck());
		frame.getContentPane().add(getPwfMypagePwCheck());
		frame.getContentPane().add(getLbMypageName());
		frame.getContentPane().add(getTfMypageName());
		frame.getContentPane().add(getLbMypageTelno());
		frame.getContentPane().add(getTfMypageTelno());
		frame.getContentPane().add(getLbMypageNick());
		frame.getContentPane().add(getTfMypageNick());
		frame.getContentPane().add(getBtnOverlap());
		frame.getContentPane().add(getLbPwCheckStr());
		frame.getContentPane().add(getBtnMypageReset());
		frame.getContentPane().add(getBtnMypageCancel());
		frame.getContentPane().add(getBtnMypageResetOk());
//		frame.getContentPane().add(getLbTest());
	}

	private JLabel getLbAdminLogo() {
		if (lbAdminLogo == null) {
			lbAdminLogo = new JLabel("카페행");
			lbAdminLogo.setFont(new Font("Dialog", Font.PLAIN, 35));
			lbAdminLogo.setBounds(227, 0, 96, 59);
			lbAdminLogo.setVisible(false);
		}
		return lbAdminLogo;
	}

	private JLabel getLbMainSlogan() {
		if (lbMainSlogan == null) {
			lbMainSlogan = new JLabel("강한 이끌림, 현대인의 필수품");
			lbMainSlogan.setBounds(199, 148, 148, 15);
			lbMainSlogan.setForeground(Color.white);
		}
		return lbMainSlogan;
	}

	private JRadioButton getRdbtnClient() {
		if (rdbtnClient == null) {
			rdbtnClient = new JRadioButton("고객");
			rdbtnClient.setSelected(true);
			buttonGroup.add(rdbtnClient);
			rdbtnClient.setBounds(198, 169, 63, 23);
		}
		return rdbtnClient;
	}

	private JRadioButton getRdbtnAdmin() {
		if (rdbtnAdmin == null) {
			rdbtnAdmin = new JRadioButton("관리자");
			buttonGroup.add(rdbtnAdmin);
			rdbtnAdmin.setBounds(281, 169, 96, 23);
		}
		return rdbtnAdmin;
	}

	private JLabel getLbId() {
		if (lbId == null) {
			lbId = new JLabel("아이디");
			lbId.setBounds(188, 200, 57, 15);
		}
		return lbId;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(242, 197, 116, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}

	private JLabel getLbPw() {
		if (lbPw == null) {
			lbPw = new JLabel("비밀번호");
			lbPw.setBounds(188, 236, 57, 15);
		}
		return lbPw;
	}

	private JPasswordField getPfPW() {
		if (pfPW == null) {
			pfPW = new JPasswordField();
			pfPW.setBounds(242, 233, 116, 21);
		}
		return pfPW;
	}

	private JButton getBtnRogin() {
		if (btnRogin == null) {
			btnRogin = new JButton("로그인");
			btnRogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					clientRoginAction();
//					adminRoginAction();
					getMypage();
				}
			});
			btnRogin.setBounds(191, 268, 167, 44);
		}
		return btnRogin;
	}

	private JLabel getLbMainLogo() {
		if (lbMainLogo == null) {
			lbMainLogo = new JLabel("카페행");
			lbMainLogo.setFont(new Font("Dialog", Font.PLAIN, 43));
			lbMainLogo.setBounds(215, 77, 116, 79);
			lbMainLogo.setForeground(Color.white);
		}
		return lbMainLogo;
	}

	private JLabel getLbMainImg() {
		if (lbMainImg == null) {
			lbMainImg = new JLabel("");
			lbMainImg.setBounds(0, 0, 545, 478);
			ImageIcon icon = new ImageIcon("/Users/Mac/eclipse-workspace/cafe_test/src/com/javalec/image/main.png");
			lbMainImg.setIcon(icon);
		}
		return lbMainImg;
	}

	private JLabel getLbMypage() {
		if (lbMypage == null) {
			lbMypage = new JLabel("마이페이지");
			lbMypage.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
			lbMypage.setBounds(27, 35, 126, 37);
			lbMypage.setVisible(false);
		}
		return lbMypage;
	}

	private JLabel getLbMypageId() {
		if (lbMypageId == null) {
			lbMypageId = new JLabel("아이디");
			lbMypageId.setBounds(29, 102, 61, 16);
			lbMypageId.setVisible(false);
		}
		return lbMypageId;
	}

	private JTextField getTfMypageId() {
		if (tfMypageId == null) {
			tfMypageId = new JTextField();
			tfMypageId.setEditable(false);
			tfMypageId.setBounds(103, 97, 130, 26);
			tfMypageId.setColumns(10);
			tfMypageId.setVisible(false);
		}
		return tfMypageId;
	}

	private JLabel getLbMypagePw() {
		if (lbMypagePw == null) {
			lbMypagePw = new JLabel("비밀번호");
			lbMypagePw.setBounds(27, 142, 61, 16);
			lbMypagePw.setVisible(false);
		}
		return lbMypagePw;
	}

	private JPasswordField getPwfMypagePw() {
		if (pwfMypagePw == null) {
			pwfMypagePw = new JPasswordField();
			pwfMypagePw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			pwfMypagePw.setEditable(false);
			pwfMypagePw.setBounds(101, 137, 130, 26);
			pwfMypagePw.setVisible(false);
		}
		return pwfMypagePw;
	}

	private JLabel getLbMypagePwCheck() {
		if (lbMypagePwCheck == null) {
			lbMypagePwCheck = new JLabel("비밀번호확인");
			lbMypagePwCheck.setBounds(27, 184, 75, 16);
			lbMypagePwCheck.setVisible(false);
		}
		return lbMypagePwCheck;
	}

	private JPasswordField getPwfMypagePwCheck() {
		if (pwfMypagePwCheck == null) {
			pwfMypagePwCheck = new JPasswordField();
			pwfMypagePwCheck.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					checkPw();
				}
			});
			pwfMypagePwCheck.addMouseListener(new MouseAdapter() {
			});
			pwfMypagePwCheck.setEditable(false);
			pwfMypagePwCheck.setBounds(101, 179, 130, 26);
			pwfMypagePwCheck.setVisible(false);
		}
		return pwfMypagePwCheck;
	}

	private JLabel getLbMypageName() {
		if (lbMypageName == null) {
			lbMypageName = new JLabel("이름");
			lbMypageName.setBounds(26, 230, 61, 16);
			lbMypageName.setVisible(false);
		}
		return lbMypageName;
	}

	private JTextField getTfMypageName() {
		if (tfMypageName == null) {
			tfMypageName = new JTextField();
			tfMypageName.setEditable(false);
			tfMypageName.setColumns(10);
			tfMypageName.setBounds(100, 225, 130, 26);
			tfMypageName.setVisible(false);
		}
		return tfMypageName;
	}

	private JLabel getLbMypageTelno() {
		if (lbMypageTelno == null) {
			lbMypageTelno = new JLabel("전화번호");
			lbMypageTelno.setBounds(25, 280, 61, 16);
			lbMypageTelno.setVisible(false);
		}
		return lbMypageTelno;
	}

	private JTextField getTfMypageTelno() {
		if (tfMypageTelno == null) {
			tfMypageTelno = new JTextField();
			tfMypageTelno.setEditable(false);
			tfMypageTelno.setColumns(10);
			tfMypageTelno.setBounds(99, 275, 130, 26);
			tfMypageTelno.setVisible(false);
		}
		return tfMypageTelno;
	}

	private JLabel getLbMypageNick() {
		if (lbMypageNick == null) {
			lbMypageNick = new JLabel("닉네임");
			lbMypageNick.setBounds(25, 335, 61, 16);
			lbMypageNick.setVisible(false);
		}
		return lbMypageNick;
	}

	private JTextField getTfMypageNick() {
		if (tfMypageNick == null) {
			tfMypageNick = new JTextField();
			tfMypageNick.setEditable(false);
			tfMypageNick.setColumns(10);
			tfMypageNick.setBounds(99, 330, 130, 26);
			tfMypageNick.setVisible(false);
		}
		return tfMypageNick;
	}

	private JButton getBtnOverlap() {
		if (btnOverlap == null) {
			btnOverlap = new JButton("중복확인");
			btnOverlap.setEnabled(false);
			btnOverlap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkNick();
				}
			});
			btnOverlap.setBounds(246, 329, 117, 29);
			btnOverlap.setVisible(false);
		}
		return btnOverlap;
	}

	// method
	// 로그인확인 메소
	private void clientRoginAction() {
		wkId = tfId.getText().trim(); // 전역변수인 변수에 사용자 입력값을 저장한다. 
		char[] wkPws = pfPW.getPassword();
		String wkPw = "";
		String wkName = "";
		for (int i = 0; i < wkPws.length; i++) {
			wkPw += wkPws[i];
		}
		
		DbAction_Mypage_YJ dbAction = new DbAction_Mypage_YJ(wkId, wkPw, wkName); // DbAction 클래스로 넘기는것도, 전역변수로 넘김 
		Bean_Mypage_YJ bean = dbAction.adminRoginAction();
		if (rdbtnClient.isSelected()) {
			if (wkId.equals(bean.getClientId()) && wkPw.equals(bean.getClientPw())) {
				JOptionPane.showMessageDialog(null, bean.getClientName() + "님 환영합니다.");
				mainVisible();
				clientControl();
			} else {
				JOptionPane.showMessageDialog(null, "아이디 및 비밀번호를 확인하세요.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "회원만 로그인 가능합니다.");
		}
	}

//	private void adminRoginAction() {
//		String wkId = tfId.getText().trim();
//		char[] wkPws = pfPW.getPassword();
//		String wkPw = "";
//		String wkName = "";
//		boolean isLogin = false;
//		for (int i = 0; i < wkPws.length; i++) {
//			wkPw += wkPws[i];
//		}
//
//		String query = "select clientId, clientPw, clientName from client where clientId = '" + wkId
//				+ "' and clientPw = '" + wkPw + "'";
//
////      System.out.println(query + wkId); 쿼리 검사
////		System.out.println(wkPw);
//		if (rdbtnAdmin.isSelected() == false) {
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//				Statement stmt_mysql = conn_mysql.createStatement();
//
//				ResultSet rs = stmt_mysql.executeQuery(query);
//
//				if (rs.next()) {
//					wkId = rs.getString(1);
//					wkPw = rs.getString(2);
//					wkName = rs.getString(3);
////				System.out.println("성공"); 작동 검사
//					isLogin = true;
//				}
//				userId = wkId;
//				if (isLogin == true) {
//					JOptionPane.showMessageDialog(null, wkName + "님 환영합니다.");
//					mainVisible();
//					clientControl();
//				} else {
//					JOptionPane.showMessageDialog(null, "아이디 및 비밀번호를 확인하세요.");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			JOptionPane.showMessageDialog(null, "관리자만 접근 가능합니다.");
//		}
//	}

	private void mainVisible() {
		// 로그인 후 안보여질 것들
		lbMainLogo.setVisible(false);
		lbMainSlogan.setVisible(false);
		lbId.setVisible(false);
		tfId.setVisible(false);
		lbPw.setVisible(false);
		pfPW.setVisible(false);
		rdbtnClient.setVisible(false);
		rdbtnAdmin.setVisible(false);
		btnRogin.setVisible(false);
		lbMainImg.setVisible(false);
	}

	private void clientControl() {
		// 로그인 후 보여지는 것들
		lbAdminLogo.setVisible(true);
		lbMypage.setVisible(true);
		lbMypageId.setVisible(true);
		tfMypageId.setVisible(true);
		lbMypagePw.setVisible(true);
		pwfMypagePw.setVisible(true);
		lbMypagePwCheck.setVisible(true);
		pwfMypagePwCheck.setVisible(true);
		lbMypageName.setVisible(true);
		tfMypageName.setVisible(true);
		lbMypageTelno.setVisible(true);
		tfMypageTelno.setVisible(true);
		lbMypageNick.setVisible(true);
		tfMypageNick.setVisible(true);
		btnOverlap.setVisible(true);

	}
	
	private void getMypage() { // 로그인 한 사용자의 정보 불러오는 것도, 전역변수를 기준으로 DbAction 클래스로 넘겨준다.
		
		DbAction_Mypage_YJ dbAction = new DbAction_Mypage_YJ(wkId);
		Bean_Mypage_YJ bean = dbAction.getMypage();
		
		tfMypageId.setText(bean.getClientId());
		pwfMypagePw.setText(bean.getClientPw());
		pwfMypagePwCheck.setText(bean.getClientPw());
		tfMypageName.setText(bean.getClientName());
		tfMypageTelno.setText(bean.getClientTelno());
		tfMypageNick.setText(bean.getClientNick());
	}

//	private void getMypage() {
//
//		String query = "select clientId, clientPw, clientName, clientTelno, clientNick from client ";
//		String query1 = "where clientId = '" + userId + "'";
//		System.out.println(userId);
//		System.out.println(query + query1);
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//
//			ResultSet rs = stmt_mysql.executeQuery(query + query1);
//
//			if (rs.next()) {
//				tfMypageId.setText(rs.getString("clientId"));
//				pwfMypagePw.setText(rs.getString("clientPw"));
//				pwfMypagePwCheck.setText(rs.getString("clientPw"));
//				tfMypageName.setText(rs.getString("clientName"));
//				tfMypageTelno.setText(rs.getString("clientTelno"));
//				tfMypageNick.setText(rs.getString("clientNick"));
//			}
//
//			conn_mysql.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	private void checkPw() {
		char[] pw1 = pwfMypagePw.getPassword();
		String pwCheck1 = new String(pw1);
		char[] pw2 = pwfMypagePwCheck.getPassword();
		String pwCheck2 = new String(pw2);


		if (pwCheck1.equals(pwCheck2)) {
			lbPwCheckStr.setText("비밀번호 동일합니다");
		} else {
			lbPwCheckStr.setVisible(true);
		}
	}
	
	
	private void updateUser() {
		
		char[] pw = pwfMypagePw.getPassword();
		String setPw = "";
		String setName = tfMypageName.getText().trim();
		String setTelno = tfMypageTelno.getText().trim();
		String setNick = tfMypageNick.getText().trim();
		for (int i = 0; i < pw.length; i++) {
			setPw += pw[i];
		}
		DbAction_Mypage_YJ dbAction = new DbAction_Mypage_YJ(wkId, setPw, setName, setTelno, setNick);
		boolean isUpdate = dbAction.updateUser();
		
		if (isUpdate == true) {
			JOptionPane.showMessageDialog(null, tfMypageName.getText().trim() + "님의 정보가 수정 되었습니다!");
		} else {
			JOptionPane.showMessageDialog(null, tfMypageName.getText().trim() + "님의 정보수정 중 오류가 생겼습니다.");
		}
	}

//	private void updateUser() {
//		PreparedStatement ps = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
////			(clientId, clientPw, clientName, clientTelno, clientNick)
//			char[] pw = pwfMypagePw.getPassword();
//			String setPw = "";
//			for (int i = 0; i < pw.length; i++) {
//				setPw += pw[i];
//			}
//			String query = "update client set ";
//			String query1 = "clientPw = ?, clientName = ?, clientTelno = ?, clientNick = ? where clientId = '" + userId
//					+ "'";
//
//			ps = conn_mysql.prepareStatement(query + query1);
//
//			ps.setString(1, setPw);
//			ps.setString(2, tfMypageName.getText().trim());
//			ps.setString(3, tfMypageTelno.getText().trim());
//			ps.setString(4, tfMypageNick.getText().trim());
//			ps.executeUpdate(); // 입력
//
//			conn_mysql.close();
//			JOptionPane.showMessageDialog(null, userId + "님의 정보가 수정 되었습니다!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	private void checkNick() {
		String checkText = "";
		String userText = tfMypageNick.getText().trim();
		
		DbAction_Mypage_YJ dbAction = new DbAction_Mypage_YJ(wkId, userText);
		Bean_Mypage_YJ bean = dbAction.checkNick();
		
		if (userText.equals(bean.getClientNick())) {
			JOptionPane.showMessageDialog(null, "중복입니다. 다른 닉네임을 설정하세요.");
		} else {
			JOptionPane.showMessageDialog(null, userText + "은 가능한 닉네임 입니다.");
		}
	}

//	private void checkNick() {
//		String checkText = "";
//		String userText = tfMypageNick.getText().trim();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//
//			String query = "select clientNick from client where clientNick = '" + userText + "'";
//
//			ResultSet rs = stmt_mysql.executeQuery(query);
//
//			while (rs.next()) {
//				checkText = rs.getString(1);
//			}
//			if (userText.equals(checkText)) {
//				JOptionPane.showMessageDialog(null, "중복입니다. 다른 닉네임을 설정하세요.");
//			} else {
//				JOptionPane.showMessageDialog(null, userText + "은 가능한 닉네임 입니다.");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

//	private void checkText() {
//		int checkIndex = 0;
//		String option = "";
//		char[] pw1 = pwfMypagePw.getPassword();
//		String pwStr1 = "";
//		char[] pw2 = pwfMypagePwCheck.getPassword();
//		String pwStr2 = "";
//
//		for (int i = 0; i < pw1.length; i++) {
//			pwStr1 += pw1[i];
//		}
//		for (int i = 0; i < pw2.length; i++) {
//			pwStr2 += pw2[i];
//		}
////		clientId, clientPw, clientName, clientTelno, clientNick
//		if (pwStr1.length() == 0) {
//			option = "비밀번호를 ";
//			pwfMypagePw.grabFocus();
//			checkIndex++;
//		}
//
//		if (pwStr2.length() == 0) {
//			option = "비밀번호를 ";
//			pwfMypagePwCheck.grabFocus();
//			checkIndex++;
//		}
//
//		if (tfMypageName.getText().trim().length() == 0) {
//			option = "이름을 ";
//			tfMypageName.grabFocus();
//			checkIndex++;
//		}
//
//		if (tfMypageTelno.getText().trim().length() == 0) {
//			option = "전화번호를 ";
//			tfMypageTelno.grabFocus();
//			checkIndex++;
//		}
//
//		if (tfMypageNick.getText().trim().length() == 0) {
//			option = "닉네임을 ";
//			tfMypageNick.grabFocus();
//			checkIndex++;
//		}
//
//		if (checkIndex > 0) {
//			JOptionPane.showMessageDialog(null, option + "입력해주세요.");
//		} else {
//			updateUser();
//		}
//	}

	private JLabel getLbPwCheckStr() {
		if (lbPwCheckStr == null) {
			lbPwCheckStr = new JLabel("비밀번호가 동일하지 않습니다.");
			lbPwCheckStr.setBounds(103, 202, 175, 16);
			lbPwCheckStr.setVisible(false);
		}
		return lbPwCheckStr;
	}

	private JButton getBtnMypageReset() {
		if (btnMypageReset == null) {
			btnMypageReset = new JButton("수정");
			btnMypageReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnMypageReset.setVisible(false);
					btnMypageResetOk.setVisible(true);
					pwfMypagePw.setEditable(true);
					pwfMypagePwCheck.setEditable(true);
					tfMypageName.setEditable(true);
					tfMypageTelno.setEditable(true);
					tfMypageNick.setEditable(true);
					btnOverlap.setEnabled(true);
				}
			});
			btnMypageReset.setBounds(281, 436, 117, 29);
		}
		return btnMypageReset;
	}

	private JButton getBtnMypageCancel() {
		if (btnMypageCancel == null) {
			btnMypageCancel = new JButton("취소");
			btnMypageCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getMypage();
					tfMypageId.setEditable(false);
					pwfMypagePw.setEditable(false);
					pwfMypagePwCheck.setEditable(false);
					tfMypageName.setEditable(false);
					tfMypageTelno.setEditable(false);
					btnOverlap.setEnabled(false);
					
				}
			});
			btnMypageCancel.setBounds(406, 436, 117, 29);
		}
		return btnMypageCancel;
	}

	private JButton getBtnMypageResetOk() {
		if (btnMypageResetOk == null) {
			btnMypageResetOk = new JButton("완료");
			btnMypageResetOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					checkText();
					updateUser();
					btnMypageReset.setVisible(true);
				}
			});
			btnMypageResetOk.setBounds(281, 436, 117, 29);
			btnMypageResetOk.setVisible(false);
		}
		return btnMypageResetOk;
	}
	public void setMain(MainProcess main) {
		this.main = main;
	}
}