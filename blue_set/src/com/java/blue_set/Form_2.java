package com.java.blue_set;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Form_2 extends JFrame {

	// private JPanel contentPane;

	private JTextField textField_2;
	private JTextField textField_3;
	final public static Form_2 frame = new Form_2();
	private JTextField textField;
	private JTextField textField_1;

	Login_ log_in = new Login_();

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

	public Form_2() {

		getContentPane().setBackground(Color.WHITE);
		setSize(new Dimension(500, 500));
		setTitle("TEST_JAVA");
		getContentPane().setLayout(null);

		JLabel la1, la2;
		la1 = new JLabel(config_para.get_Json[0]);
		la1.setBounds(56, 53, 86, 20);
		getContentPane().add(la1);

		la2 = new JLabel(config_para.get_Json[1]);
		la2.setBounds(76, 73, 106, 40);
		getContentPane().add(la2);

		JLabel lblDjfdfdf = new JLabel("Radar_Speed_Set");
		lblDjfdfdf.setBounds(110, 39, 267, 60);
		lblDjfdfdf.setFont(new Font("JasmineUPC", Font.PLAIN, 48));
		getContentPane().add(lblDjfdfdf);

		textField = new JTextField();
		textField.setBounds(163, 156, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(163, 213, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.getText();
				boolean sucess = log_in.login_(textField.getText(),
						textField_1.getText());
				if (sucess) {
					Form4 form4 = new Form4();
					form4.setVisible(true);
					frame.setVisible(false);
				} else {

				}
				System.out.println(textField.getText());
				System.out.println(textField_1.getText());
			}
		});
		btnNewButton_1.setBounds(171, 289, 97, 25);
		getContentPane().add(btnNewButton_1);

		System.out.println(config_para.get_Json[0]);
		System.out.println("check");
	}
}
