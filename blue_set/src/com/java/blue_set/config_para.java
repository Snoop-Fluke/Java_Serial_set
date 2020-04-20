package com.java.blue_set;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.util.Enumeration;

abstract class config_para implements SerialPortEventListener {
	SerialPort serialPort;
	static BufferedReader input;
	static OutputStream output;
	static CommPortIdentifier portId;

	static Enumeration portEnum;

	public enum COLOR {
		RED, GREED, YELLOW;
	}

	public enum COM_SET {
		COM3, COM4, COM20;
	}

	public String PORT_NAMES[] = new String[5];
	public static final int TIME_OUT = 5000;
	public static final int DATA_RATE = 115200;
	public static String read_string = "HELLO";
	public static String Send_Json;
	public static String get_Json[] = new String[10];
	public static String val_1;
	public static Integer val_2;
	public static int Config_command[] = new int[10];
}
