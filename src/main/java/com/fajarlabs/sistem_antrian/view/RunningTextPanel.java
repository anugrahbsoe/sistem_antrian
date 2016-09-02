package com.fajarlabs.sistem_antrian.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RunningTextPanel extends JPanel implements Runnable {
	JLabel label;
	String str;
	private final int ms = 200; /* miliseconds */

	public RunningTextPanel(String message ,JLabel label) {
		super();
		this.label = label;
		this.str = message;
		add(this.label,BorderLayout.CENTER);
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		while (true) {
			char c = str.charAt(0);
			String rest = str.substring(1);
			str = rest + c;
			label.setText(str);
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
