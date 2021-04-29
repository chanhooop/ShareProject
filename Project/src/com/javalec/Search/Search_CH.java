
package com.javalec.Search;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.MainPackage.MainProcess;
import com.javalec.bean.Bean_CH;
import com.javalec.dbaction.DbAction_CH;

public class Search_CH extends JFrame {

	private MainProcess main;

	
	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable InnerTable;
	private JButton btnMypage;
	private JLabel lblNewLabel;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JComboBox cmbList;

	// 데이터베이스 환경 정의

	// Table 환경 정의
	private final DefaultTableModel Outer_Table = new DefaultTableModel();

	private JTextField tfBrand;
	private JTextField tfName;
	private JTextField tfPice;
	private JTextField tfMeterial;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox cmbPriceSelect;
	private JButton btnComent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_CH window = new Search_CH();
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
	public Search_CH() {
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
				tableInit();
				searchAction();

			}
		});
		frame.setBounds(100, 100, 678, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnMypage());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfSearch());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getCmbList());
		frame.getContentPane().add(getTfBrand());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfPice());
		frame.getContentPane().add(getTfMeterial());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getCmbPriceSelect());
		frame.getContentPane().add(getBtnComent());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(61, 133, 473, 134);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	private JTable getInnerTable() {
		if (InnerTable == null) {
			InnerTable = new JTable();
			InnerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableClick();

				}
			});
			InnerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			InnerTable.setModel(Outer_Table); // **************이너 아우터 연동 중요******************

		}
		return InnerTable;
	}

	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("마이페이지");
			btnMypage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
					
					main.MypageOpen();
					frame.dispose();
					
				
					// %&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

				}
			});
			btnMypage.setBounds(436, 41, 91, 23);
		}
		return btnMypage;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("검색 :");
			lblNewLabel.setBounds(65, 105, 50, 15);
		}
		return lblNewLabel;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(199, 99, 203, 28);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}

	private JComboBox getCmbList() {
		if (cmbList == null) {
			cmbList = new JComboBox();
			cmbList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// 가격콤보박스 활성화시키기______________________________________________
					if (cmbList.getSelectedIndex() == 2) {
						tfSearch.setVisible(false);
					} else {
						tfSearch.setVisible(true);
					}
					// ________________________________________________________________
				}
			});
			cmbList.setModel(new DefaultComboBoxModel(new String[] { "이름", "브랜드", "가격" }));
			cmbList.setBounds(107, 101, 70, 23);

		}

		return cmbList;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// 조건검색 쿼리
					conditionQuery();

				}
			});
			btnSearch.setBounds(436, 101, 91, 23);
		}
		return btnSearch;
	}

	private JTextField getTfBrand() {
		if (tfBrand == null) {
			tfBrand = new JTextField();
			tfBrand.setEditable(false);
			tfBrand.setBounds(96, 291, 96, 21);
			tfBrand.setColumns(10);
		}
		return tfBrand;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(252, 291, 96, 21);
		}
		return tfName;
	}

	private JTextField getTfPice() {
		if (tfPice == null) {
			tfPice = new JTextField();
			tfPice.setEditable(false);
			tfPice.setColumns(10);
			tfPice.setBounds(388, 291, 77, 21);
		}
		return tfPice;
	}

	private JTextField getTfMeterial() {
		if (tfMeterial == null) {
			tfMeterial = new JTextField();
			tfMeterial.setEditable(false);
			tfMeterial.setColumns(10);
			tfMeterial.setBounds(531, 291, 91, 21);
		}
		return tfMeterial;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("브랜드");
			lblNewLabel_1.setBounds(50, 294, 50, 15);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setBounds(221, 294, 50, 15);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("가격");
			lblNewLabel_3.setBounds(360, 294, 50, 15);
		}
		return lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("알레르기");
			lblNewLabel_4.setBounds(477, 292, 50, 18);
		}
		return lblNewLabel_4;
	}

	private JComboBox getCmbPriceSelect() {
		if (cmbPriceSelect == null) {
			cmbPriceSelect = new JComboBox();
			cmbPriceSelect
					.setModel(new DefaultComboBoxModel(new String[] { "전체", "1000~3000", "3000~6000", "6000~9000" }));
			cmbPriceSelect.setBounds(199, 100, 188, 23);

		}
		return cmbPriceSelect;
	}

	private JButton getBtnComent() {
		if (btnComent == null) {
			btnComent = new JButton("댓글창");
			btnComent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnComent.setBounds(436, 363, 91, 23);
		}
		return btnComent;
	}

	// $$$$$$$$$ 메인 프로세스와 연동 $$$$$$$$$$$$$$$
	public void setMain(MainProcess main) {
		this.main = main;
	}

	// ------------------------------------------------------------------------------------------------------------------

	// 테이블 초기화
	private void tableInit() {

		Outer_Table.addColumn("브랜드");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("메뉴타입");
		Outer_Table.addColumn("가격");
		Outer_Table.setColumnCount(4);

		int i = Outer_Table.getRowCount();
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		InnerTable.setAutoResizeMode(InnerTable.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = InnerTable.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = InnerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

	}

	// 데이터 불러오기
	private void searchAction() {

		DbAction_CH dbAction_CH = new DbAction_CH();
		ArrayList<Bean_CH> beanList = dbAction_CH.selectList();

		int j = beanList.size();
		for (int i = 0; i < j; i++) {

			String[] arr = { beanList.get(i).getBrandName(), beanList.get(i).getMenuName(),
					beanList.get(i).getMenuType(), beanList.get(i).getmenuprice() };
			Outer_Table.addRow(arr);

		}
	}

	// 데이터 하나 클릭했읗때 정보 뜨게 하는 기능

	private void TableClick() {
		int i = InnerTable.getSelectedRow();
		Bean_CH bean_CH = new Bean_CH();

		String tmpSequence = (String) InnerTable.getValueAt(i, 0);
		String tmpSequence2 = (String) InnerTable.getValueAt(i, 1);
		bean_CH.setBrandName(tmpSequence);
		bean_CH.setMenuName(tmpSequence2);

		DbAction_CH dbAction_CH = new DbAction_CH();
		dbAction_CH.tableClick(bean_CH);

		tfBrand.setText(bean_CH.getBrandName());
		tfName.setText(bean_CH.getMenuName());
		tfPice.setText(bean_CH.getmenuprice());
		tfMeterial.setText(bean_CH.getMetarialName());

	}

	// 화면지우기 메서드
	private void clearColumn() {
//		tfMcode.setText("");
		tfBrand.setText("");
		tfName.setText("");
		tfPice.setText("");
		tfMeterial.setText("");
	}

	// ####################################### 조건 검색 부분
	// ###############################################

	// 조건 검색 콤보상자 선택
	private void conditionQuery() {
		int i = cmbList.getSelectedIndex(); // 콤보상자의 몇번쨰인지 알아봐주는 메서드 겟셀렉티드 인덱스
		String conditionQueryColumn = "";
		switch (i) {
		case 0:
			conditionQueryColumn = "m.menuName";
			tableInit();
			clearColumn();
			conditionQueryAction(conditionQueryColumn);
			break;
		case 1:
			conditionQueryColumn = "b.brandName";
			tableInit();
			clearColumn();
			conditionQueryAction(conditionQueryColumn);
			break;
		case 2:
			tableInit();
			clearColumn();
			priceconditionQuery(); // 가격검색 콤보상자 메소드
			break;

		default:
			break;
		}
	}

	// 조건콤보상자에 맞는 조건검색
	private void conditionQueryAction(String a) { // a 는 conditionQueryColumn
		// 필요한 값 빈으로 보내기
		Bean_CH bean = new Bean_CH();
		bean.setTfsearch((String) tfSearch.getText());
		bean.setConditionQueryColumn(a);

		// 필요한 메서드 가져오기
		DbAction_CH dbAction = new DbAction_CH();
		dbAction.conditionQueryDb(bean);
		ArrayList<Bean_CH> beanlist = dbAction.conditionQueryDb(bean);
		int j = beanlist.size();

		for (int i = 0; i < j; i++) {

			String[] arr = { beanlist.get(i).getBrandName(), beanlist.get(i).getMenuName(),
					beanlist.get(i).getMenuType(), beanlist.get(i).getmenuprice() };
			Outer_Table.addRow(arr);
		}

	}

	// 콤보상자에서 가격을 선택했을 때

	private void priceconditionQuery() {
		// 필요한 값 보내기
		Bean_CH bean = new Bean_CH();
		bean.setCmbPriceSelect(cmbPriceSelect.getSelectedIndex());

		// 필요한 값 가져오기
		DbAction_CH dbAction = new DbAction_CH();
		ArrayList<Bean_CH> beanList = dbAction.priceconditionQueryDB(bean);
		int j = beanList.size();

		for (int i = 0; i < j; i++) {

			String[] arr = { beanList.get(i).getBrandName(), beanList.get(i).getMenuName(),
					beanList.get(i).getMenuType(), beanList.get(i).getmenuprice() };
			Outer_Table.addRow(arr);

		}
	}



	// #########################################################################################################

} /// ------------------
