package com.java.blue_set;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Form3 extends JFrame {

	config_port cf_serial = new config_port();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form3 frame = new Form3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Form3()

	{
		getContentPane().setForeground(Color.ORANGE);
		getContentPane().setBackground(SystemColor.scrollbar);
		setSize(new Dimension(500, 500));
		setTitle("TEST_JAVA___");
		getContentPane().setLayout(null);

		final JButton btnOpenport = new JButton();
		btnOpenport.setIcon(null);
		btnOpenport.setFont(new Font("JasmineUPC", Font.PLAIN, 20));
		btnOpenport.setForeground(Color.BLACK);
		btnOpenport.setBackground(Color.GREEN);
		btnOpenport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cf_serial.initialize();
				if (cf_serial.init_port() != null) {
					btnOpenport.setBackground(Color.gray);
				}

			}
		});
		btnOpenport.setText("Open_port");
		btnOpenport.setBounds(12, 185, 115, 40);
		getContentPane().add(btnOpenport);

		JButton btnCloseport = new JButton();
		btnCloseport.setBackground(Color.RED);
		btnCloseport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOpenport.setBackground(Color.GREEN);
				cf_serial.close();
				JOptionPane.showMessageDialog(null, "ClosePort", "SerialPort",
						1);
			}
		});
		btnCloseport.setText("close_port");
		btnCloseport.setBounds(171, 185, 99, 40);
		btnCloseport.setOpaque(true);
		getContentPane().add(btnCloseport);

		String combo_set[] = { "", "COM3", "COM5", "COM20" };

		JLabel label_text = new JLabel("Find " + cf_serial.init_port()
				+ " connect this port");
		System.out.print(cf_serial.init_port());

		label_text.setBounds(48, 27, 196, 30);
		getContentPane().add(label_text);
		setSize(300, 300);
		getContentPane().setLayout(null);
		setVisible(true);
		System.out.print("HELLO");
	}
}
