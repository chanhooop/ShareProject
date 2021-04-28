package com.javalec.Search;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.bean.base.coffeeBean_KMJ;
import com.dbaction.base.coffeeSearchAction_KMJ;

import javax.swing.JTable;

import java.awt.Font;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class coffeeSearch_KMJ {
	private mainCoffee mainCoffee;
	
	private JFrame frame;
	private JPanel panel;
	private JComboBox cbSerarch;
	private JTextField tfSearch;
	private JButton btnsearch;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable searchList_table;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1_1;
	private JTextField textField_3;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JTable comment_table;
	private JLabel lblNewLabel_1_3;
	private JTextField tfComment;
	private JButton btnNewButton_1;
	private final DefaultTableModel search_Out_Table = new DefaultTableModel();
	private final DefaultTableModel comment_Out_Table = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coffeeSearch_KMJ window = new coffeeSearch_KMJ();
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
	public coffeeSearch_KMJ() {
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
				searchLisetOuttable();
				commentOuttable();
				searchLisetInnertable();
			}
		});
		frame.setBounds(100, 100, 450, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getCbSerarch());
			panel.add(getTfSearch());
			panel.add(getBtnsearch());
			panel.add(getLblNewLabel());
			panel.add(getScrollPane());
			panel.add(getLblNewLabel_1());
			panel.add(getTextField_1());
			panel.add(getTextField_2());
			panel.add(getLblNewLabel_1_1());
			panel.add(getTextField_3());
			panel.add(getLblNewLabel_1_2());
			panel.add(getLblNewLabel_2());
			panel.add(getScrollPane_1());
			panel.add(getLblNewLabel_1_3());
			panel.add(getTfComment());
			panel.add(getBtnNewButton_1());
			panel.add(getTfLogin());
			panel.add(getBtnTest());
		}
		return panel;
	}

	private JComboBox getCbSerarch() {
		if (cbSerarch == null) {
			cbSerarch = new JComboBox();
			cbSerarch.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					cbSearchItemChange();
				}
			});
			cbSerarch.setModel(new DefaultComboBoxModel(new String[] { "메뉴타입", "메뉴명", "브랜드명", "가격" }));
			cbSerarch.setBounds(6, 59, 88, 27);
		}
		return cbSerarch;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setToolTipText("");
			tfSearch.setBounds(94, 58, 281, 26);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}

	private JButton getBtnsearch() {
		if (btnsearch == null) {
			btnsearch = new JButton("검색");
			btnsearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchBtnClick();
				}
			});
			btnsearch.setBounds(371, 58, 73, 29);
		}
		return btnsearch;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("카페행");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(74, 33, 450, 47);
		}
		return lblNewLabel;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 98, 438, 165);
			scrollPane.setViewportView(getSearchList_table());
		}
		// private final DefaultTableModel Outer_Table = new DefaultTableModel();
		// 필수

		return scrollPane;
	}

	private JTable getSearchList_table() {
		if (searchList_table == null) {
			searchList_table = new JTable();
			searchList_table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					commentLisetInnertable();
				}
			});
			searchList_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			searchList_table.setModel(search_Out_Table); // 안쪽테이블과 바깥쪽 테이블이서로 연동
		}
		return searchList_table;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("브랜드");
			lblNewLabel_1.setBounds(6, 275, 120, 16);
		}
		return lblNewLabel_1;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(47, 270, 79, 26);
			textField_1.setColumns(10);
		}
		return textField_1;
	}

	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(196, 270, 79, 26);
		}
		return textField_2;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("메뉴");
			lblNewLabel_1_1.setBounds(170, 275, 105, 16);
		}
		return lblNewLabel_1_1;
	}

	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(346, 270, 79, 26);
		}
		return textField_3;
	}

	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("가격");
			lblNewLabel_1_2.setBounds(320, 275, 105, 16);
		}
		return lblNewLabel_1_2;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("원");
			lblNewLabel_2.setBounds(428, 275, 16, 16);
		}
		return lblNewLabel_2;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(6, 322, 438, 165);
			scrollPane_1.setViewportView(getComment_table());
		}
		return scrollPane_1;
	}

	private JTable getComment_table() {
		if (comment_table == null) {
			comment_table = new JTable();
			comment_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			comment_table.setModel(comment_Out_Table); // 안쪽테이블과 바깥쪽 테이블이서로 연동
		}
		return comment_table;
	}

	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("브랜드");
			lblNewLabel_1_3.setBounds(6, 499, 43, 16);
		}
		return lblNewLabel_1_3;
	}

	private JTextField getTfComment() {
		if (tfComment == null) {
			tfComment = new JTextField();
			tfComment.setColumns(10);
			tfComment.setBounds(47, 494, 328, 26);
		}
		return tfComment;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("전송");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addComment();
				}
			});
			btnNewButton_1.setBounds(371, 494, 73, 29);
		}
		return btnNewButton_1;
	}

//__________________________________________________________________
//	데이터베이스 환경정의 검색리스트
	private final String url_mysql = "jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root";
	private final String pw_mysql = "qwer1234";
	private JTextField tfLogin;
	private JButton btnTest;

	private void searchLisetOuttable() { // 리스트 아웃테이블 기본 설
		search_Out_Table.addColumn("브랜드"); // 첫번쨰 리스트 컬럼
		search_Out_Table.addColumn("메뉴타입"); // 두번쨰 리스트 컬럼
		search_Out_Table.addColumn("메뉴명"); // 세번쨰 리스트 컬럼
		search_Out_Table.addColumn("가격"); // 네번쨰 리스트 컬럼
		search_Out_Table.setColumnCount(4); // 몇개까지 붙러온다
		int i = search_Out_Table.getRowCount();// 카운트숫자를 가지고
		for (int j = 0; j < i; j++) {
			search_Out_Table.removeRow(0);
		}
		searchList_table.setAutoResizeMode(searchList_table.AUTO_RESIZE_OFF); // 테이블사이즈 조정불가
		int vColIndex = 0;
		TableColumn col = searchList_table.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(100);

		vColIndex = 1;
		col = searchList_table.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(100);

		vColIndex = 2;
		col = searchList_table.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(130);

		vColIndex = 3;
		col = searchList_table.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(70);
	}

	private void commentOuttable() { // 코멘트 아웃테이블 기본 설정
		comment_Out_Table.addColumn("댓글");
		comment_Out_Table.setColumnCount(1); // 몇개까지 붙러온다
		int i = comment_Out_Table.getRowCount();// 카운트숫자를 가지고
		for (int j = 0; j < i; j++) {
			comment_Out_Table.removeRow(0);
		}
		comment_table.setAutoResizeMode(comment_table.AUTO_RESIZE_OFF); // 테이블사이즈 조정불가
		int vColIndex = 0;
		TableColumn col = comment_table.getColumnModel().getColumn(vColIndex);
		col.setPreferredWidth(230);
	}

	private void searchLisetInnertable() {
		coffeeSearchAction_KMJ coffeeSearchAction_KMJ = new coffeeSearchAction_KMJ();
		String topic = (String) cbSerarch.getSelectedItem();
		String searchValue = (String) tfSearch.getText();
		coffeeBean_KMJ coffeeBean_KMJ = new coffeeBean_KMJ();
		coffeeBean_KMJ.setTopic(topic);
		coffeeBean_KMJ.setSearchValue(searchValue);

		ArrayList<coffeeBean_KMJ> beanList = coffeeSearchAction_KMJ.searchLisetInnertable(coffeeBean_KMJ);
		for (int i = 0; i < beanList.size(); i++) { // 리스트를 한줄씩 listCount 만큼 가져온다
			String[] queryArray = { beanList.get(i).getBrandName(), beanList.get(i).getMenuType(),
					beanList.get(i).getMenuName(), beanList.get(i).getPrice() };
			search_Out_Table.addRow(queryArray);
		}
	}

	private void commentLisetInnertable() {
//		int i = searchList_table.getSelectedRow();
//		String branNameData = (String) searchList_table.getValueAt(i, 0);
//		String menuNameData = (String) searchList_table.getValueAt(i, 2);
//		
//		coffeeSearchAction coffeeSearchAction = new coffeeSearchAction();
//		ArrayList<coffeeBean> beanList = coffeeSearchAction.commentLisetInnertable(branNameData, menuNameData);
		commentOuttable();
		coffeeSearchAction_KMJ coffeeSearchAction_KMJ = new coffeeSearchAction_KMJ();
		coffeeBean_KMJ coffeeBean_KMJ = new coffeeBean_KMJ();
		int selectedMenu = searchList_table.getSelectedRow();
		String brandName = (String) searchList_table.getValueAt(selectedMenu, 0);
		String menuName = (String) searchList_table.getValueAt(selectedMenu, 2);
		coffeeBean_KMJ.setBrandName(brandName);
		coffeeBean_KMJ.setMenuName(menuName);

		ArrayList<coffeeBean_KMJ> beanList = coffeeSearchAction_KMJ.commentLisetInnertable(coffeeBean_KMJ);
		for (int i = 0; i < beanList.size(); i++) {
			String[] queryArray = { beanList.get(i).getClientName() + " : " + beanList.get(i).getComment() };
			comment_Out_Table.addRow(queryArray);
		}
	}

	private void cbSearchItemChange() {
		searchLisetOuttable(); // 테이블 초기화
		searchLisetInnertable(); // 리스트 재출력
		commentOuttable();
	}

	private void searchBtnClick() {
		searchLisetOuttable(); // 테이블 초기화
		searchLisetInnertable(); // 리스트 재출력
		commentOuttable();
	}

	private void addComment() {
		coffeeSearchAction_KMJ coffeeSearchAction_KMJ = new coffeeSearchAction_KMJ();
		coffeeBean_KMJ coffeeBean_KMJ = new coffeeBean_KMJ();
		String loginName = tfLogin.getText();
		int selectedMenu = searchList_table.getSelectedRow();
		String brandName = (String) searchList_table.getValueAt(selectedMenu, 0);
		String menuName = (String) searchList_table.getValueAt(selectedMenu, 2);
		String comment = tfComment.getText();

		coffeeBean_KMJ.setBrandName(brandName);
		coffeeBean_KMJ.setMenuName(menuName);
		coffeeBean_KMJ.setClientCode(loginName); // 로그인이름 클라이언트코드 찾기위해 필
		coffeeBean_KMJ.setComment(comment);
		coffeeSearchAction_KMJ.addCommend(coffeeBean_KMJ);
		commentLisetInnertable();
	}

	private MainLCH mainLCH;

	// mainProcess와 연동
	public void setMain(mainCoffee mainCoffee) {
		System.out.println(1);
		this.mainCoffee = mainCoffee;
	}

//__________________________________________________________________

	private JTextField getTfLogin() {
		if (tfLogin == null) {
			tfLogin = new JTextField();
			tfLogin.setText("1");
			tfLogin.setBounds(299, 14, 130, 26);
			tfLogin.setColumns(10);
		}
		return tfLogin;
	}

	private JButton getBtnTest() {
		if (btnTest == null) {
			btnTest = new JButton("test");
			btnTest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mainCoffee.showFrameTest();
				}
			});
			btnTest.setBounds(6, 11, 117, 29);
		}
		return btnTest;
	}
}
