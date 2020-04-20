package com.java.blue_set;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Form1 extends JFrame {
	final public static Form1 frame = new Form1();
	config_port Class_func = new config_port();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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

	public Form1() {
		// ////////////////////////////////////////////////////////////////

		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 500));
		setTitle("TEST_JAVA");
		getContentPane().setLayout(null);

		// //////////////////////////////////////////////////////////////////
		JButton close_port = new JButton();
		close_port.setText("debug");
		close_port.setBounds(12, 343, 89, 23);
		close_port.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(24, 67, 318, 274);
				getContentPane().add(scrollPane);

				JTextArea textArea_1 = new JTextArea();
				scrollPane.setViewportView(textArea_1);
				// while (true) {
				textArea_1.append(Class_func.read_string);
				// }

			}

		});
		getContentPane().add(close_port);
		// System.out.println(config_para.read_string);

		String color[] = { "", "RED", "YELLOW", "GREEN", "BLUE" };

		final JComboBox Speed_start = new JComboBox(new Object[] {});
		Speed_start.setBounds(75, 59, 86, 26);
		getContentPane().add(Speed_start);

		final JComboBox text_alert = new JComboBox(color);
		text_alert.setBounds(345, 143, 86, 26);
		getContentPane().add(text_alert);
		Speed_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Speed_start.getItemAt(Speed_start
						.getSelectedIndex()));
				Class_func.Config_command[4] = Speed_start.getSelectedIndex();
				Class_func.put_json("Ti_Dt", Class_func.Config_command[4]);
				System.out.println(Class_func.Config_command[4]);

			}
		});
		text_alert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(text_alert.getItemAt(text_alert
						.getSelectedIndex()));
				Class_func.Config_command[6] = text_alert.getSelectedIndex();
				Class_func.put_json("Ti_Dt", Class_func.Config_command[6]);
				System.out.println(Class_func.Config_command[6]);

			}
		});

		JButton config_val = new JButton("SET_VAL");
		config_val.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Class_func.send_json();
			}
		});
		config_val.setBounds(12, 315, 89, 23);
		getContentPane().add(config_val);
		// //////////////////////////////////////////////////////////////
		JButton btnSave = new JButton("Write");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Class_func.put_json("Set_mode", 1);
				Class_func.send_json();
				System.out.print("SAVE_CONFIG");
				Class_func.pop_json("Set_mode");
			}
		});
		btnSave.setBounds(185, 376, 115, 29);
		getContentPane().add(btnSave);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Form4 form4 = new Form4();
				form4.setVisible(true);

			}
		});
		btnBack.setBounds(12, 415, 97, 25);
		getContentPane().add(btnBack);

		JLabel lblNewLabel = new JLabel("Color");
		lblNewLabel.setBounds(25, 64, 56, 16);
		getContentPane().add(lblNewLabel);

		JLabel lblBlink_1 = new JLabel("Blink");
		lblBlink_1.setBounds(25, 105, 56, 16);
		getContentPane().add(lblBlink_1);

		JLabel lblTimeMonitor = new JLabel("Time monitor");
		lblTimeMonitor.setBounds(25, 148, 89, 16);
		getContentPane().add(lblTimeMonitor);

		JLabel lblSpeedLimit = new JLabel("Speed limit");
		lblSpeedLimit.setBounds(258, 64, 82, 16);
		getContentPane().add(lblSpeedLimit);

		JLabel lblSpeedStart = new JLabel("Speed start");
		lblSpeedStart.setBounds(248, 105, 82, 16);
		getContentPane().add(lblSpeedStart);

		JLabel lblTextAlert = new JLabel("Text alert");
		lblTextAlert.setBounds(252, 148, 82, 16);
		getContentPane().add(lblTextAlert);

		textField = new JTextField();
		textField.setBounds(75, 105, 89, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(110, 145, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(339, 61, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(339, 102, 116, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel label = new JLabel("Color");
		label.setBounds(25, 177, 56, 16);
		getContentPane().add(label);

		JComboBox comboBox = new JComboBox(new Object[] {});
		comboBox.setBounds(75, 177, 86, 26);
		getContentPane().add(comboBox);

		// //////////////////////////////////////////////////////////////
		Thread t = new Thread() {
			public void run() {

				try {
					Thread.sleep(1000000);
				} catch (InterruptedException ie) {
				}
			}
		};
		t.start();

	}
}
