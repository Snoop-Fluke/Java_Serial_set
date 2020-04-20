package com.java.blue_set;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Form4 extends JFrame {

	public static Form4 frame = new Form4();

	config_port Class_func = new config_port();
	private JTextField txtTest;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Form4() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setSize(new Dimension(500, 500));
		JButton btnNewButton_1 = new JButton("Connect port");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Form3 form3 = new Form3();
				form3.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(147, 195, 162, 25);
		getContentPane().add(btnNewButton_1);

		JButton btnConfigPage = new JButton("next");
		btnConfigPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Form1 form1 = new Form1();
				form1.setVisible(true);
				frame.setVisible(false);
				Class_func.put_json("Set_mode", 1);
				Class_func.send_json();
			}
		});
		btnConfigPage.setBounds(147, 300, 162, 25);
		getContentPane().add(btnConfigPage);

		txtTest = new JTextField();
		txtTest.setText("test");
		txtTest.setBounds(166, 87, 116, 22);
		getContentPane().add(txtTest);
		txtTest.setColumns(10);

	}

}
