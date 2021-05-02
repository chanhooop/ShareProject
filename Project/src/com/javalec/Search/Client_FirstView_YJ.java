package com.javalec.Search;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class Client_FirstView_YJ {

	private JFrame frame;
	private JLabel lbBackGround;
	private JButton btnSerch;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_FirstView_YJ window = new Client_FirstView_YJ();
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
	public Client_FirstView_YJ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnSerch());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
	}
	private JButton getBtnSerch() {
		if (btnSerch == null) {
			btnSerch = new JButton("검색하러가기");
			btnSerch.setForeground(Color.BLACK);
			btnSerch.setBounds(160, 394, 218, 39);
		}
		return btnSerch;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("로그아웃");
			lblNewLabel.setBounds(478, 16, 61, 16);
			lblNewLabel.setForeground(Color.white);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("카페행");
			lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 43));
			lblNewLabel_1.setBounds(215, 77, 116, 79);
			lblNewLabel_1.setForeground(Color.white);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("강한 이끌림, 현대인의 필수품");
			lblNewLabel_2.setBounds(199, 148, 148, 15);
			lblNewLabel_2.setForeground(Color.white);
		}
		return lblNewLabel_2;
	}
}
