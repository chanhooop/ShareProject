

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

public class Search_CH {

	private MainProcess main;
	
	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable InnerTable;
	private JButton btnMypage;
	private JLabel lblNewLabel;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JComboBox cmbList;
	
	
	//데이터베이스 환경 정의

	
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
	private JTextField tfMcode;
	private JLabel lblNewLabel_1_1;
	private JComboBox cmbPriceSelect;
<<<<<<< HEAD
	private JButton btnComent;
	private JLabel lbBrandProduct;
=======
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)


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
<<<<<<< HEAD
		frame.setBounds(100, 100, 545, 478 );
=======
		frame.setBounds(100, 100, 715, 522);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
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
		frame.getContentPane().add(getTfMcode());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getCmbPriceSelect());
<<<<<<< HEAD
		frame.getContentPane().add(getBtnComent());
		frame.getContentPane().add(getLbBrandProduct());
=======
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(25, 81, 487, 134);
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
			InnerTable.setModel(Outer_Table);		  //**************이너 아우터 연동 중요******************
			
		}
		return InnerTable;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("마이페이지");
			btnMypage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
<<<<<<< HEAD
			btnMypage.setBounds(443, 6, 91, 23);
=======
			btnMypage.setBounds(401, 48, 91, 23);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
		}
		return btnMypage;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("검색 :");
			lblNewLabel.setBounds(24, 48, 50, 15);
		}
		return lblNewLabel;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(184, 41, 203, 28);
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
					if(cmbList.getSelectedIndex() == 2) {
						tfSearch.setVisible(false);
					}else {
						tfSearch.setVisible(true);
					}
					//________________________________________________________________
				}
			});
			cmbList.setModel(new DefaultComboBoxModel(new String[] {"이름", "브랜드", "가격"}));
			cmbList.setBounds(66, 44, 104, 23);				
				
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
<<<<<<< HEAD
			btnSearch.setBounds(421, 43, 91, 23);
=======
			btnSearch.setBounds(506, 101, 91, 23);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
		}
		return btnSearch;
	}

	
	private JTextField getTfBrand() {
		if (tfBrand == null) {
			tfBrand = new JTextField();
<<<<<<< HEAD
			tfBrand.setEditable(false);
			tfBrand.setBounds(95, 228, 96, 21);
=======
			tfBrand.setBounds(177, 291, 96, 21);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
			tfBrand.setColumns(10);
		}
		return tfBrand;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
<<<<<<< HEAD
			tfName.setBounds(95, 271, 96, 21);
=======
			tfName.setBounds(318, 291, 96, 21);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
		}
		return tfName;
	}
	private JTextField getTfPice() {
		if (tfPice == null) {
			tfPice = new JTextField();
			tfPice.setColumns(10);
<<<<<<< HEAD
			tfPice.setBounds(95, 312, 77, 21);
=======
			tfPice.setBounds(458, 291, 77, 21);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
		}
		return tfPice;
	}
	private JTextField getTfMeterial() {
		if (tfMeterial == null) {
			tfMeterial = new JTextField();
			tfMeterial.setColumns(10);
<<<<<<< HEAD
			tfMeterial.setBounds(95, 355, 91, 21);
=======
			tfMeterial.setBounds(598, 291, 91, 21);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
		}
		return tfMeterial;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("브랜드");
<<<<<<< HEAD
			lblNewLabel_1.setBounds(35, 232, 50, 15);
=======
			lblNewLabel_1.setBounds(133, 294, 50, 15);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
<<<<<<< HEAD
			lblNewLabel_2.setBounds(35, 275, 50, 15);
=======
			lblNewLabel_2.setBounds(285, 294, 50, 15);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("가격");
<<<<<<< HEAD
			lblNewLabel_3.setBounds(35, 316, 50, 15);
=======
			lblNewLabel_3.setBounds(426, 294, 50, 15);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("알레르기");
<<<<<<< HEAD
			lblNewLabel_4.setBounds(33, 357, 50, 18);
=======
			lblNewLabel_4.setBounds(547, 292, 50, 18);
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
		}
		return lblNewLabel_4;
	}
	
	private JTextField getTfMcode() {
		if (tfMcode == null) {
			tfMcode = new JTextField();
			tfMcode.setColumns(10);
			tfMcode.setBounds(65, 291, 56, 21);
		}
		return tfMcode;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("메뉴코드");
			lblNewLabel_1_1.setBounds(12, 294, 50, 15);
		}
		return lblNewLabel_1_1;
	}
	private JComboBox getCmbPriceSelect() {
		if (cmbPriceSelect == null) {
			cmbPriceSelect = new JComboBox();
			cmbPriceSelect.setModel(new DefaultComboBoxModel(new String[] {"전체", "1000~3000", "3000~6000", "6000~9000"}));
			cmbPriceSelect.setBounds(185, 44, 188, 23);
			
		}
		return cmbPriceSelect;
	}
	//------------------------------------------------------------------------------------------------------------------
	
<<<<<<< HEAD
	private JButton getBtnComent() {
		if (btnComent == null) {
			btnComent = new JButton("댓글창");
			btnComent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnComent.setBounds(443, 412, 91, 23);
		}
		return btnComent;
	}
	
	
=======
	// 화면정리
>>>>>>> parent of ace828c (Merge pull request #20 from chanhooop/chanho)
	
	
	
	// 테이블 초기화
	private void tableInit() {
		
		Outer_Table.addColumn("");
		Outer_Table.addColumn("브랜드");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("가격");
		Outer_Table.setColumnCount(4);
		
		int i = Outer_Table.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table.removeRow(0);
		}
		
		InnerTable.setAutoResizeMode(InnerTable.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = InnerTable.getColumnModel().getColumn(vColIndex);
		int width = 0;
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
		for(int i = 0 ; i < j; i++) {
		
		String temp = Integer.toString(beanList.get(i).getMenuCode());	// 메뉴코드 스트링타입으로 바꿔주기  
		String[] arr = {temp, beanList.get(i).getBrandName(), beanList.get(i).getMenuName(), beanList.get(i).getmenuprice()};
		Outer_Table.addRow(arr);
			
		}
	}
	
	// 데이터 하나 클릭했읗때 정보 뜨게 하는 기능

		private void TableClick() {
	        int i = InnerTable.getSelectedRow();
	        String tmpSequence = (String)InnerTable.getValueAt(i, 0);
	        
	        DbAction_CH dbAction_CH = new DbAction_CH();
	        Bean_CH bean_CH = dbAction_CH.tableClick(tmpSequence);
	        
	        tfMcode.setText(Integer.toString(bean_CH.getMenuCode()));
	        tfBrand.setText(bean_CH.getBrandName());
	        tfName.setText(bean_CH.getMenuName());
	        tfPice.setText (bean_CH.getmenuprice());
	        tfMeterial.setText(bean_CH.getMetarialName());
	

		}
		
	// 화면지우기 메서드
	private void clearColumn() {   
		tfMcode.setText("");
		tfBrand.setText("");
		tfName.setText("");
		tfPice.setText("");
		tfMeterial.setText("");
	}
		
	
// ####################################### 조건 검색 부분 ###############################################
	
	// 조건 검색 콤보상자 선택
	private void conditionQuery() {
		int i = cmbList.getSelectedIndex();  // 몇번쨰인지 알아봐주는 메서드 겟셀렉티드 인덱스
		String conditionQueryColumn = "";
		switch(i) {
		case 0 : 
			conditionQueryColumn = "m.menuName";
			tableInit(); 								
			clearColumn();
			conditionQueryAction(conditionQueryColumn);
			break;
		case 1 : 
			conditionQueryColumn = "b.brandName";
			tableInit(); 								
			clearColumn();
			conditionQueryAction(conditionQueryColumn);
			break;
		case 2 : 
			tableInit(); 								
			clearColumn();
			priceconditionQuery() ;		// 가격검색 콤보상자	메소드
			break;

		default : 
			break;		
		}
	}
	
	// 조건콤보상자에 맞는 조건검색
	private void conditionQueryAction(String a) {      // a 는 conditionQueryColumn
		// 필요한 값 보내기
		Bean_CH bean_CH = new Bean_CH();
		bean_CH.setTfsearch((String)tfSearch.getText());
		bean_CH.setConditionQueryColumn(a);	
		
		//필요한 값 가져오기		
		DbAction_CH dbAction_CH = new DbAction_CH();
		dbAction_CH.conditionQueryDb(bean_CH);
		ArrayList<Bean_CH> beanlist = dbAction_CH.conditionQueryDb(bean_CH);
		int j = beanlist.size();
				
		for(int i = 0 ; i < j ; i++) {
			String temp = Integer.toString(beanlist.get(i).getMenuCode());
			String[] arr = {temp,beanlist.get(i).getBrandName(),beanlist.get(i).getMenuName(),beanlist.get(i).getmenuprice()};
			
			Outer_Table.addRow(arr);		
		}
	
	}
	
	// 콤보상자에서 가격을 선택했을 때   
	
		private void priceconditionQuery() {
			  // 필요한 값 보내기
				Bean_CH bean_CH = new Bean_CH();
				bean_CH.setCmbPriceSelect(cmbPriceSelect.getSelectedIndex());
				
				//필요한 값 가져오기
				DbAction_CH dbAction_CH = new DbAction_CH();  
				ArrayList<Bean_CH> beanList = dbAction_CH.priceconditionQueryDB(bean_CH);
				int j = beanList.size();
				
				for(int i = 0 ; i < j ; i++) {
					String temp = Integer.toString(beanList.get(i).getMenuCode());
					String[] arr = {temp,beanList.get(i).getBrandName(),beanList.get(i).getMenuName(),beanList.get(i).getmenuprice()};
					
					Outer_Table.addRow(arr);		
	
				}
		}
		
	    // mainProcess와 연동

		public void setMain(MainProcess main) {
			this.main = main;
		}
		
	// #########################################################################################################
	

 		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 		// 찬호님 이 라벨에 이미지 들어갈거에요!!!!!! 이미지 불러오고 하는건 예진이와 함께해요!!!!
	private JLabel getLbBrandProduct() {
		if (lbBrandProduct == null) {
			lbBrandProduct = new JLabel("");
			lbBrandProduct.setBounds(330, 235, 137, 128);
		}
		return lbBrandProduct;
	}
}  /// ------------------
