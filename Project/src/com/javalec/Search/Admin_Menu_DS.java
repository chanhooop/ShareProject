package com.javalec.Search;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.bean.Bean_Admin_Menu_DS;
import com.javalec.dbaction.DbAction_Admin_Menu_DS;
import com.javalec.sharevar.ShareVar_Admin_Menu_DS;
//yhyghyy
public class Admin_Menu_DS {

	private JFrame frame;
	private JLabel lbAdminLogo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfadmincode;

	// Database 환경 정의
	private final String url_mysql = "jdbc:mysql://127.0.0.1/coffee?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root";
	private final String pw_mysql = "qwer1234";
	private JLabel lbMenuControll;
	private JScrollPane scrollPane;
	private JTable Inner_table;
	private JLabel lbMenuCode;
	private JTextField tfMenuCode;
	private JLabel lbMenuType;
	private JLabel lbMenuName;
	private JTextField tfMenuName;
	private JLabel lbMenuPrice;
	private JTextField tfMenuPrice;

	// Table 환경 정의
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lbTest;
	private JLabel lbBrandName;
	private JTextField tfBrandName;
	private JComboBox cbMenuType;

	private int addBtn = 0;
	private int addBtnOk = 0;
	private int resetBtn = 0;
	private int resetBtnOk = 0;
	private int cencel = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Menu_DS window = new Admin_Menu_DS();
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
	public Admin_Menu_DS() {
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
				tableInit();
				selectAllMenu();
			}
		});
		frame.setTitle("카페행");
		frame.setBounds(100, 100, 545, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLbAdminLogo());
		frame.getContentPane().add(getLbMenuControll());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLbMenuCode());
		frame.getContentPane().add(getTfMenuCode());
		frame.getContentPane().add(getLbMenuType());
		frame.getContentPane().add(getLbMenuName());
		frame.getContentPane().add(getTfMenuName());
		frame.getContentPane().add(getLbMenuPrice());
		frame.getContentPane().add(getTfMenuPrice());
		frame.getContentPane().add(getLbBrandName());
		frame.getContentPane().add(getTfBrandName());
		frame.getContentPane().add(getCbMenuType());
		frame.getContentPane().add(getTextField_1());
		frame.getContentPane().add(getLbMenuImg());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfMenuAllergy());
		frame.getContentPane().add(getTextField_1_1());
		frame.getContentPane().add(getBtnAddImg());
		frame.getContentPane().add(getTextField_1_2());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getBtnAddOk());
		frame.getContentPane().add(getBtnReset());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getBtnAdd());
		frame.getContentPane().add(getBtnResetOk());

	}

	private JLabel getLbAdminLogo() {
		if (lbAdminLogo == null) {
			lbAdminLogo = new JLabel("카페행");
			lbAdminLogo.setFont(new Font("Dialog", Font.PLAIN, 35));
			lbAdminLogo.setBounds(215, 0, 116, 59);
		}
		return lbAdminLogo;
	}

	private JLabel getLbMenuControll() {
		if (lbMenuControll == null) {
			lbMenuControll = new JLabel("메뉴관리");
			lbMenuControll.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lbMenuControll.setBounds(28, 42, 83, 31);

		}
		return lbMenuControll;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 77, 458, 108);
			scrollPane.setViewportView(getInner_table());

		}
		return scrollPane;
	}

	private JTable getInner_table() {
		if (Inner_table == null) {
			Inner_table = new JTable();
			Inner_table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			Inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_table.setModel(Outer_Table);
		}
		return Inner_table;
	}

	private JLabel getLbMenuCode() {
		if (lbMenuCode == null) {
			lbMenuCode = new JLabel("메뉴코드");
			lbMenuCode.setBounds(40, 200, 61, 16);
		}
		return lbMenuCode;
	}

	private JTextField getTfMenuCode() {
		if (tfMenuCode == null) {
			tfMenuCode = new JTextField();
			tfMenuCode.setEditable(false);
			tfMenuCode.setBounds(101, 195, 51, 26);
			tfMenuCode.setColumns(10);
		}
		return tfMenuCode;
	}

	private JLabel getLbMenuType() {
		if (lbMenuType == null) {
			lbMenuType = new JLabel("메뉴종류");
			lbMenuType.setBounds(41, 264, 61, 16);
		}
		return lbMenuType;
	}

	private JLabel getLbMenuName() {
		if (lbMenuName == null) {
			lbMenuName = new JLabel("메뉴이름");
			lbMenuName.setBounds(41, 302, 61, 16);
		}
		return lbMenuName;
	}

	private JTextField getTfMenuName() {
		if (tfMenuName == null) {
			tfMenuName = new JTextField();
			tfMenuName.setEditable(false);
			tfMenuName.setBounds(102, 297, 130, 26);
			tfMenuName.setColumns(10);
		}
		return tfMenuName;
	}

	private JLabel getLbMenuPrice() {
		if (lbMenuPrice == null) {
			lbMenuPrice = new JLabel("메뉴가격");
			lbMenuPrice.setBounds(41, 335, 61, 16);
		}
		return lbMenuPrice;
	}

	private JTextField getTfMenuPrice() {
		if (tfMenuPrice == null) {
			tfMenuPrice = new JTextField();
			tfMenuPrice.setEditable(false);
			tfMenuPrice.setBounds(102, 330, 130, 26);
			tfMenuPrice.setColumns(10);
		}
		return tfMenuPrice;
	}

	private JLabel getLbBrandName() {
		if (lbBrandName == null) {
			lbBrandName = new JLabel("브랜드명");
			lbBrandName.setBounds(40, 233, 61, 16);
		}
		return lbBrandName;
	}

	private JTextField getTfBrandName() {
		if (tfBrandName == null) {
			tfBrandName = new JTextField();
			tfBrandName.setEditable(false);
			tfBrandName.setBounds(102, 228, 130, 26);
			tfBrandName.setColumns(10);
		}
		return tfBrandName;
	}

	int check = 0;

	private JComboBox getCbMenuType() {
		if (cbMenuType == null) {
			cbMenuType = new JComboBox();
			cbMenuType.setModel(new DefaultComboBoxModel(new String[] { "커피", "베이커리", "티", "프라페" }));
			cbMenuType.setBounds(101, 260, 131, 25);

			check = cbMenuType.getSelectedIndex();

		}
		return cbMenuType;
	}

	private JTextField getTextField_1() {
		if (tfadmincode == null) {
			tfadmincode = new JTextField();
			tfadmincode.setBounds(406, 27, 96, 21);
			tfadmincode.setColumns(10);
			tfadmincode.setVisible(false);
		}
		return tfadmincode;
	}

	private JLabel getLbMenuImg() {
		if (lbMenuImg == null) {
			lbMenuImg = new JLabel("");
			lbMenuImg.setBounds(244, 195, 137, 128);
		}
		return lbMenuImg;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("재료");
			lblNewLabel.setBounds(40, 361, 50, 31);
		}
		return lblNewLabel;
	}

	private JTextField getTfMenuAllergy() {
		if (tfMenuAllergy == null) {
			tfMenuAllergy = new JTextField();
			tfMenuAllergy.setEditable(false);
			tfMenuAllergy.setBounds(101, 361, 131, 21);
			tfMenuAllergy.setColumns(10);
		}
		return tfMenuAllergy;
	}

	private JTextField getTextField_1_1() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(369, 198, 96, 21);
			tfFilePath.setColumns(10);
			tfFilePath.setVisible(false);
		}
		return tfFilePath;
	}

	private JButton getBtnAddImg() {
		if (btnAddImg == null) {
			btnAddImg = new JButton("등록");
			btnAddImg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

				}
			});
			btnAddImg.setBounds(244, 360, 66, 23);
		}
		return btnAddImg;
	}

	private JTextField getTextField_1_2() {
		if (tfmenuImg == null) {
			tfmenuImg = new JTextField();
			tfmenuImg.setEditable(false);
			tfmenuImg.setBounds(101, 392, 131, 21);
			tfmenuImg.setColumns(10);
		}
		return tfmenuImg;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("메뉴이미지");
			lblNewLabel_1.setBounds(35, 400, 66, 15);
		}
		return lblNewLabel_1;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tfBrandName.getText().trim().isEmpty()) {
						btnAddImg.setEnabled(false);
						btnAdd.setEnabled(true);
						btnDelete.setEnabled(true);
						btnReset.setEnabled(true);
						tfBrandName.setEditable(false);
					} else {
//						cencelInfo();
						ClearColumn();
					}
					resetBtn = 0;
					addBtn = 0;

				}

			});
			btnCancel.setBounds(240, 409, 61, 23);
		}
		return btnCancel;

	}

	private JButton getBtnAddOk() {
		if (btnAddOk == null) {
			btnAddOk = new JButton("확인");
			btnAddOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertAction();
					insertMenuUpdate();
					ClearColumn();
					btnDelete.setEnabled(true);
					btnReset.setEnabled(true);
					btnResetOk.setEnabled(true);
					addBtn = 0;
					btnAdd.setVisible(true);
				}
			});
			btnAddOk.setBounds(386, 409, 62, 23);
		}
		return btnAddOk;
	}

	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("수정");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					resetBtn++;
					if (addBtn == 0) {
						btnReset.setVisible(false);
						tfBrandName.setEditable(true);
						btnAddImg.setEnabled(true);
						btnAdd.setEnabled(false);
						btnAddOk.setVisible(false);
						btnDelete.setEnabled(false);
					}

					if (resetBtn > 0) {
						btnAddOk.setVisible(true);
						btnAdd.setEnabled(false);
						btnAdd.setVisible(true);
						btnAddOk.setVisible(false);
						btnResetOk.setVisible(true);
						btnResetOk.setEnabled(true);
					}
				}
			});
			btnReset.setBounds(313, 409, 61, 23);
		}
		return btnReset;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					menuDelete();
					ClearColumn();
					selectAllMenu();
				}
			});
			btnDelete.setBounds(460, 409, 62, 23);
		}
		return btnDelete;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("등록");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addBtn++;

					if (tfMenuCode.getText().length() > 0) {
						ClearColumn();
						btnAddOk.setEnabled(true);
					}

					if (resetBtn == 0) {
						btnAdd.setVisible(false);
						tfBrandName.setEditable(true);
						btnAddImg.setEnabled(true);
						btnDelete.setEnabled(false);
						btnReset.setEnabled(false);
						btnResetOk.setEnabled(false);
						btnResetOk.setVisible(false);
					}

					if (addBtn > 0) {
						btnAddOk.setVisible(true);
						btnReset.setVisible(true);
						btnDelete.setEnabled(false);
						btnAddOk.setEnabled(true);
					}
				}
			});
			btnAdd.setBounds(386, 409, 62, 23);
		}
		return btnAdd;
	}

	private JButton getBtnResetOk() {
		if (btnResetOk == null) {
			btnResetOk = new JButton("확인");
			btnResetOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tfMenuCode.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "수정 될 정보가 없습니다. 정보를 입력해주세요");
					} else {
						updateMenu();
						updateMenuPrice();
						ClearColumn();
					}
				}
			});
			btnResetOk.setBounds(313, 409, 62, 23);
		}
		return btnResetOk;
	}

	private void tableInit() {
		Outer_Table.addColumn("메뉴코드");
		Outer_Table.addColumn("브랜드명");
		Outer_Table.addColumn("메뉴종류");
		Outer_Table.addColumn("메뉴이름");
		Outer_Table.addColumn("가격");
		Outer_Table.setColumnCount(5);

		int i = Outer_Table.getRowCount();
		System.out.println(i);
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_table.setAutoResizeMode(Inner_table.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_table.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
	}

	// 메뉴 출력
	private void selectAllMenu() {
		DbAction_Admin_Menu_DS dbAction = new DbAction_Admin_Menu_DS();
		ArrayList<Bean_Admin_Menu_DS> beanList = (ArrayList<Bean_Admin_Menu_DS>) dbAction.selectAllMenu();

		int listCount = beanList.size();
		for (int i = 0; i < listCount; i++) {
			String temp = Integer.toString(beanList.get(i).getMenuCode());
			String[] qTxt = { temp, beanList.get(i).getBrandName(), beanList.get(i).getMenuType(),
					beanList.get(i).getMenuName(), beanList.get(i).getMenuPrice() };
			Outer_Table.addRow(qTxt);
		}
	}

	// 테이블 클릭시
	int wkCodeInt = 0;
	int j = 0;
	private JLabel lbMenuImg;
	private JTextField tfMaterial;
	private JLabel lblNewLabel;
	private JTextField tfMenuAllergy;
	private JTextField tfFilePath;
	private JButton btnAddImg;
	private JTextField tfmenuImg;
	private JLabel lblNewLabel_1;
	private JButton btnCancel;
	private JButton btnAddOk;
	private JButton btnReset;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnResetOk;

	private void tableClick() {
		int i = Inner_table.getSelectedRow();
		String menuType = (String) Inner_table.getValueAt(i, 2);
		String wkCode = (String) Inner_table.getValueAt(i, 0);
		wkCodeInt = Integer.parseInt(wkCode);
		System.out.println(wkCodeInt);
		switch (menuType) {
		case "커피":
			j = 0;
			break;
		case "베이커리":
			j = 1;
			break;
		case "티":
			j = 2;
		case "프라페":
			j = 3;
			break;
		}

		DbAction_Admin_Menu_DS dbAction = new DbAction_Admin_Menu_DS(wkCodeInt);
		Bean_Admin_Menu_DS bean = dbAction.tableClick();

		tfMenuCode.setText(Integer.toString(bean.getMenuCode()));
		tfBrandName.setText(bean.getBrandName());
		tfMenuName.setText(bean.getMenuName());
		tfMenuPrice.setText(bean.getMenuPrice());
		cbMenuType.setSelectedIndex(j);

		// Image처리
		// File name이 틀려야 즉각 보여주기가 가능하여
		// ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제

		String filePath = Integer.toString(ShareVar_Admin_Menu_DS.filename);
		tfFilePath.setText(filePath);

		lbMenuImg.setIcon(new ImageIcon(filePath));
		lbMenuImg.setHorizontalAlignment(SwingConstants.CENTER);

		File file = new File(filePath);
		file.delete();

	}

	// 메뉴 수정 (메뉴명, 메뉴종류, 브랜드명)
	private void updateMenu() {

		String menuname = tfMenuName.getText().trim();
		String menutype = (String) cbMenuType.getSelectedItem();
		String brandName = tfBrandName.getText().trim();

		DbAction_Admin_Menu_DS dbAction = new DbAction_Admin_Menu_DS(wkCodeInt, menuname);

		int brandCode = 0;

		switch (brandName) {
		case "스타벅스":
			brandCode = 1;
			break;
		case "투썸플레이스":
			brandCode = 2;
			break;
		case "메가커피":
			brandCode = 3;
			break;
		}

		boolean isUpdate = dbAction.menuUpdate(brandCode, menutype, menuname);

		if (isUpdate == true) {
			JOptionPane.showMessageDialog(null, menuname + "의 정보가 수정 되었습니다!");
		} else {
			JOptionPane.showMessageDialog(null, menuname + "의 정보수정 중 오류가 생겼습니다.");
		}
	}

	// 메뉴 가격 수정
	private void updateMenuPrice() {

		String admin_adminCode = tfadmincode.getText().trim();
		String menu_menuCode = tfMenuCode.getText().trim();
		String brandname = tfBrandName.getText().trim();
		java.sql.Date updateDate = new java.sql.Date(System.currentTimeMillis());
		String menuPrice = tfMenuPrice.getText().trim();

		DbAction_Admin_Menu_DS dbAction = new DbAction_Admin_Menu_DS(wkCodeInt, menuPrice);

		int brandCode = 0;
		switch (brandname) {
		case "스타벅스": {
			brandCode = 1;
			break;
		}
		case "투썸플레이스": {
			brandCode = 2;
			break;
		}
		case "메가커피": {
			brandCode = 3;
		}
			break;
		}

		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean isUpdate = dbAction.MenuPriceUpdate(admin_adminCode, menu_menuCode, brandCode, updateDate, menuPrice,
				input);

		if (isUpdate == true) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	// 메뉴 등록
	private void insertAction() {

		String menutype = (String) cbMenuType.getSelectedItem();

		String brandname = tfBrandName.getText().trim();

		String menuname = tfMenuName.getText().trim();

		String menuAllergy = tfMaterial.getText().trim();
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int brandCode = 0;

		switch (brandname) {
		case "스타벅스": {
			brandCode = 1;
			break;
		}
		case "투썸플레이스": {
			brandCode = 2;
			break;
		}
		case "메가커피": {
			brandCode = 3;
		}
			break;
		}

		DbAction_Admin_Menu_DS dbAction = new DbAction_Admin_Menu_DS();
		System.out.println(brandCode + menutype + menuname);
		boolean msg = dbAction.insertAction(brandCode, menutype, menuname, menuAllergy, input);

		if (msg == true) {
			JOptionPane.showMessageDialog(null, tfMenuName.getText() + "의 정보가 입력 되었습니다.!", "입력 완료!",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!", "Critical Error!",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// 메뉴 등록 (어드민 코드, 브랜드명, 메뉴가격, 메뉴코드, 작성날짜, 수정날짜)
	private void insertMenuUpdate() {
		String admin_adminCode = tfadmincode.getText().trim();
		String brandname = tfBrandName.getText().trim();
		String menuPrice = tfMenuPrice.getText().trim();
		String menu_menuCode = tfMenuCode.getText().trim();
		java.sql.Date createDate = new java.sql.Date(System.currentTimeMillis());
		java.sql.Date updateDate = new java.sql.Date(System.currentTimeMillis());

		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 브랜드 코드를 switch 문으로 써서 각 문자열과 비교하여 데이터 저장
		int brandCode = 0;
		switch (brandname) {
		case "스타벅스": {
			brandCode = 1;
			break;
		}
		case "투썸플레이스": {
			brandCode = 2;
			break;
		}
		case "메가커피": {
			brandCode = 3;
		}
			break;
		}

		DbAction_Admin_Menu_DS dbAction = new DbAction_Admin_Menu_DS();

		boolean msg = dbAction.insertMenuUpdate(admin_adminCode, menu_menuCode, brandCode, createDate, updateDate,
				menuPrice, input);

		if (msg == true) {
		} else {

		}

	}

	// 메뉴 삭제
	private void menuDelete() {

		int menucode = Integer.parseInt(tfMenuCode.getText());

		DbAction_Admin_Menu_DS dbAction = new DbAction_Admin_Menu_DS(menucode);

		boolean msg = dbAction.menuDelete();

		if (msg == true) {
			JOptionPane.showMessageDialog(null, tfMenuName.getText() + "의 정보가 삭게되었습니다.!", "삭제 완료!",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "DB에 자료 삭제 중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!", "Critical Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void ClearColumn() {
		tfMenuCode.setText("");
		tfBrandName.setText("");
		tfMenuName.setText("");
		tfMenuPrice.setText("");
		tfMenuAllergy.setText("");
		tfmenuImg.setText("");

	}

}