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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.bean.Bean_Admin_Brand_YJ;
import com.javalec.dbaction.DbAction_Admin_Brand_YJ;
import com.javalec.sharevar.ShareVar_Admin_Brand_YJ;

public class Admin_Brand_YJ {

	private JFrame frmBrand;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable Inner_table;
	private JLabel lbBrandCode;
	private JTextField tfBrandCode;
	private JLabel lbBrandName;
	private JTextField tfBrandName;
	private JLabel lbBrandLogo1;
	private JTextField tfBrandLogo;
	private JButton btnAddLogo;
	private JLabel lbBrandLogo;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnCencel;
	private JButton btnAddOk;
	private JTextField tfFilePath;
	FileInputStream brandImg;
	private String tkSequence = "";
	private int wkSequence = 0;

	private int addBtn = 0;
	private int addBtnOk = 0;
	private int resetBtn = 0;
	private int resetBtnOk = 0;
	private int cencel = 0;

	// Database 환경 정의
	private final String url_mysql = "jdbc:mysql://127.0.0.1/coffee?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root";
	private final String pw_mysql = "qwer1234";
	public static int filename = 0;

	// Table 환경 정의
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnReset;
	private JButton btnResetOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Brand_YJ window = new Admin_Brand_YJ();
					window.frmBrand.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_Brand_YJ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrand = new JFrame();
		frmBrand.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frmBrand.setTitle("Brand");
		frmBrand.setBounds(100, 100, 545, 478);
		frmBrand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrand.getContentPane().setLayout(null);
		frmBrand.getContentPane().add(getLabel_1());
		frmBrand.getContentPane().add(getLabel_2());
		frmBrand.getContentPane().add(getScrollPane());
		frmBrand.getContentPane().add(getLabel_3());
		frmBrand.getContentPane().add(getTfBrandCode());
		frmBrand.getContentPane().add(getLbBrandName());
		frmBrand.getContentPane().add(getTfBrandName());
		frmBrand.getContentPane().add(getLbBrandLogo1());
		frmBrand.getContentPane().add(getTfBrandLogo());
		frmBrand.getContentPane().add(getBtnAddLogo());
		frmBrand.getContentPane().add(getLabel_4());
		frmBrand.getContentPane().add(getBtnDelete());
		frmBrand.getContentPane().add(getBtnAdd());
		frmBrand.getContentPane().add(getBtnCencel());
		frmBrand.getContentPane().add(getBtnAddOk());
		frmBrand.getContentPane().add(getTfFilePath());
		frmBrand.getContentPane().add(getBtnReset());
		frmBrand.getContentPane().add(getBtnResetOk());
	}

	private JLabel getLabel_1() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("카페행");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setBounds(243, 0, 63, 41);
		}
		return lblNewLabel;
	}

	private JLabel getLabel_2() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("브랜드관리");
			lblNewLabel_1.setBounds(30, 48, 61, 16);
		}
		return lblNewLabel_1;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 70, 483, 169);
			scrollPane.setViewportView(getInner_table());
			Inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_table.setModel(Outer_Table);
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
		}
		return Inner_table;
	}

	private JLabel getLabel_3() {
		if (lbBrandCode == null) {
			lbBrandCode = new JLabel("브랜드코드");
			lbBrandCode.setBounds(30, 258, 61, 16);
		}
		return lbBrandCode;
	}

	private JTextField getTfBrandCode() {
		if (tfBrandCode == null) {
			tfBrandCode = new JTextField();
			tfBrandCode.setEnabled(false);
			tfBrandCode.setBounds(105, 253, 130, 26);
			tfBrandCode.setColumns(10);
		}
		return tfBrandCode;
	}

	private JLabel getLbBrandName() {
		if (lbBrandName == null) {
			lbBrandName = new JLabel("브랜드명");
			lbBrandName.setBounds(30, 298, 61, 16);
		}
		return lbBrandName;
	}

	private JTextField getTfBrandName() {
		if (tfBrandName == null) {
			tfBrandName = new JTextField();
			tfBrandName.setEditable(false);
			tfBrandName.setColumns(10);
			tfBrandName.setBounds(105, 293, 130, 26);
		}
		return tfBrandName;
	}

	private JLabel getLbBrandLogo1() {
		if (lbBrandLogo1 == null) {
			lbBrandLogo1 = new JLabel("브랜드로고");
			lbBrandLogo1.setBounds(30, 343, 61, 16);
		}
		return lbBrandLogo1;
	}

	private JTextField getTfBrandLogo() {
		if (tfBrandLogo == null) {
			tfBrandLogo = new JTextField();
			tfBrandLogo.setEnabled(false);
			tfBrandLogo.setColumns(10);
			tfBrandLogo.setBounds(105, 338, 130, 26);
		}
		return tfBrandLogo;
	}

	private JButton getBtnAddLogo() {
		if (btnAddLogo == null) {
			btnAddLogo = new JButton("등록");
			btnAddLogo.setEnabled(false);
			btnAddLogo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
					FileInputStream input = null;
					File file = new File(tfFilePath.getText());
					try {
						input = new FileInputStream(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnAddLogo.setBounds(244, 338, 75, 29);
		}
		return btnAddLogo;
	}

	private JLabel getLabel_4() {
		if (lbBrandLogo == null) {
			lbBrandLogo = new JLabel("");
			lbBrandLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lbBrandLogo.setBounds(361, 251, 137, 128);
		}
		return lbBrandLogo;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteAction();
					clearColumn();
					searchAction();
				}
			});
			btnDelete.setBounds(430, 414, 83, 29);
		}
		return btnDelete;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("등록");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addBtn++;

					if (tfBrandCode.getText().length() > 0) {
						clearColumn();
						btnAddOk.setEnabled(true);
					}

					if (resetBtn == 0) {
						btnAdd.setVisible(false);
						tfBrandName.setEditable(true);
						btnAddLogo.setEnabled(true);
						btnDelete.setEnabled(false);
						btnReset.setEnabled(false);
						btnResetOk.setEnabled(false);
						btnResetOk.setVisible(false);
					}

					if (addBtn > 0) {
						btnAddOk.setVisible(true);
						btnReset.setVisible(true);
						btnDelete.setEnabled(false);
					}
				}
			});
			btnAdd.setBounds(338, 414, 83, 29);
		}
		return btnAdd;
	}

	private JButton getBtnCencel() {
		if (btnCencel == null) {
			btnCencel = new JButton("취소");
			btnCencel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tfBrandName.getText().trim().isEmpty()) {
						btnAddLogo.setEnabled(false);
						btnAdd.setEnabled(true);
						btnDelete.setEnabled(true);
						btnReset.setEnabled(true);
						tfBrandName.setEditable(false);
					} else {
//						cencelInfo();
						clearColumn();
					}
					resetBtn = 0;
					addBtn = 0;

				}
			});
			btnCencel.setBounds(154, 414, 83, 29);
		}
		return btnCencel;
	}

	private JButton getBtnAddOk() {
		if (btnAddOk == null) {
			btnAddOk = new JButton("확인");
			btnAddOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertBrand();
					clearColumn();
					btnDelete.setEnabled(true);
					btnReset.setEnabled(true);
					btnResetOk.setEnabled(true);
					addBtn = 0;
					btnAdd.setVisible(true);
				}
			});
			btnAddOk.setBounds(338, 414, 83, 29);
		}
		return btnAddOk;
	}

	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(313, 379, 130, 26);
			tfFilePath.setColumns(10);
			tfFilePath.setVisible(false);
		}
		return tfFilePath;
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
						btnAddLogo.setEnabled(true);
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
			btnReset.setBounds(244, 414, 83, 29);
		}
		return btnReset;
	}

	private JButton getBtnResetOk() {
		if (btnResetOk == null) {
			btnResetOk = new JButton("확인");
			btnResetOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tfBrandCode.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "수정 될 정보가 없습니다. 정보를 입력해주세요");
					} else {
						editAction();
//						searchAction();
						clearColumn();
					}
				}
			});
			btnResetOk.setBounds(243, 414, 83, 29);
		}
		return btnResetOk;
	}

	// 메소드@@@@@@@@@@@@@@@@@@@@@@@@@@@

	private void tableInit() { // 테이블 아웃테이블행설정
		Outer_Table.addColumn("브랜드코드");
		Outer_Table.addColumn("브랜드명");
		Outer_Table.setColumnCount(2);

		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_table.setAutoResizeMode(Inner_table.AUTO_RESIZE_OFF); // 뭐 자동으로 삭제되는걸 막는듯함

		// 순서에 대한 정의
		int vColIndex = 0; // 첫번째 행 정의 = 순서
		TableColumn col = Inner_table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1; // 두번째 행 정의 = 이름
		col = Inner_table.getColumnModel().getColumn(vColIndex);
		width = 300;
		col.setPreferredWidth(width);

	}

	private void searchAction() { // 이너테이블에 나올 내용
		DbAction_Admin_Brand_YJ dbAction = new DbAction_Admin_Brand_YJ();
		ArrayList<Bean_Admin_Brand_YJ> beanList = dbAction.SelectList();

		int listCount = beanList.size();

		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getBrandCode());
			String[] qTxt = { temp, beanList.get(index).getBrandName() };
			Outer_Table.addRow(qTxt);
		}
	}

	private void insertBrand() { // 등록
		String brandName = tfBrandName.getText().trim();

		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DbAction_Admin_Brand_YJ dbaction = new DbAction_Admin_Brand_YJ(brandName, input);
		boolean aaa = dbaction.insertBrand();
		if (aaa == true) {
			JOptionPane.showMessageDialog(null, tfBrandName.getText() + " 의 정보가 입력 되었습니다.!");
		} else {
			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");
		}

		tableInit();
		searchAction();
	}

	private void tableClick() { // 클릭 정보
		int i = Inner_table.getSelectedRow();
		tkSequence = (String) Inner_table.getValueAt(i, 0);
		wkSequence = Integer.parseInt(tkSequence);

		DbAction_Admin_Brand_YJ dbAction = new DbAction_Admin_Brand_YJ(wkSequence);
		Bean_Admin_Brand_YJ bean = dbAction.tableClick();

		tfBrandCode.setText(Integer.toString(bean.getBrandCode()));
		tfBrandName.setText(bean.getBrandName());

		// Image처리
		// File name이 틀려야 즉각 보여주기가 가능하여
		// ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제

		String filePath = Integer.toString(ShareVar_Admin_Brand_YJ.filename);
		tfFilePath.setText(filePath);

		lbBrandLogo.setIcon(new ImageIcon(filePath));
		lbBrandLogo.setHorizontalAlignment(SwingConstants.CENTER);

		File file = new File(filePath);
		file.delete();

	}

	private void FilePath() { // 이미지 등록
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg", "png", "bmp");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFilePath.setText(filePath);
		lbBrandLogo.setIcon(new ImageIcon(filePath));
		lbBrandLogo.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void clearColumn() { // 안보이게 다 지우는것
		tfBrandCode.setText("");
		tfBrandName.setText("");
		lbBrandLogo.setIcon(null);
		btnAddLogo.setEnabled(false);
		btnAdd.setEnabled(true);
		btnDelete.setEnabled(true);
		btnReset.setEnabled(true);
		tfBrandName.setEditable(false);
	}

	private void editAction() { // 수정
		String brandName = tfBrandName.getText().trim();

		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DbAction_Admin_Brand_YJ dbaction = new DbAction_Admin_Brand_YJ(brandName, input, wkSequence);
		boolean aaa = dbaction.editAction();
		if (aaa == true) {
			JOptionPane.showMessageDialog(null, tfBrandName.getText() + " 의 정보가 수정 되었습니다.!");
		} else {
			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");
		}
		tableInit();
		searchAction();
	}

	private void deleteAction() { // 삭제
		int i = Inner_table.getSelectedRow();
		tkSequence = (String) Inner_table.getValueAt(i, 0);

		String query1 = "delete from brand where brandCode = " + tkSequence;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			stmt_mysql.executeUpdate(query1);
			conn_mysql.close();
			JOptionPane.showMessageDialog(null, tkSequence + " 의 정보가 삭제 되었습니다.!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableInit();
		searchAction();
	}

}