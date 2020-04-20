package com.java.blue_set;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class config_port extends config_para {

	JSONObject obj = new JSONObject();

	String init_port() {
		portEnum = CommPortIdentifier.getPortIdentifiers();

		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum
					.nextElement();
			super.PORT_NAMES[0] = currPortId.getName();

		}
		return super.PORT_NAMES[0];
	}

	public void initialize() {

		portEnum = CommPortIdentifier.getPortIdentifiers();
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum
					.nextElement();
			// System.out.print("Port __" + currPortId.getName());
			super.PORT_NAMES[0] = currPortId.getName();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;

					break;
				}
			}
		}

		if (portId == null) {
			System.out.println("Could not find COM port.");
			msg_show("PLEASE_CHECK_PORT", "ERRROR");
		} else {
			msg_show("OPEN PORT :" + super.PORT_NAMES[0], "ALEART");
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(
					serialPort.getInputStream()));

			output = serialPort.getOutputStream();
			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}

	}

	public void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();

		}
	}

	public void start_set() {
		try {

			byte[] b = Send_Json.getBytes();
			output.write(b);

		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public void send_json() {
		StringWriter out = new StringWriter();
		try {
			obj.writeJSONString(out);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		config_para.Send_Json = out.toString();
		start_set();
		System.out.println(config_para.Send_Json);
		config_para.Send_Json = null;
	}

	public void put_json(String topic, int command) {
		obj.put(topic, command);

	}

	public void pop_json(String topic) {
		obj.remove(topic);
	}

	public void msg_show(String title, String msg) {
		JOptionPane.showMessageDialog(null, title, msg, 1);
	}

	public synchronized void serialEvent(SerialPortEvent oEvent) {

		// Decode Json
		JSONParser parser = new JSONParser();
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine = input.readLine() + "\n";
				read_string = inputLine;
				System.out.println(inputLine);
				JSONObject jsonObject = (JSONObject) parser
						.parse(config_para.read_string);
				System.out.println(jsonObject);
				get_Json[0] = (String) jsonObject.get("sensor");
				get_Json[1] = (String) jsonObject.get("test");
				System.out.println(get_Json[0]);
				// System.out.println(read_string);
			} catch (Exception e) {
				// System.err.println(e.toString());
			}
		}

	}

}
