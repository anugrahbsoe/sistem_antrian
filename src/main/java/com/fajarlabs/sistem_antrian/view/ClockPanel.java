package com.fajarlabs.sistem_antrian.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;


public class ClockPanel extends Thread {
	
	private Boolean loop = true;
	private Date date;
	private JLabel lClock;
	private Boolean flag = false;
	
	public ClockPanel(JLabel lClock) {
		date = new Date();
		this.lClock = lClock;
	}
	
	public void stopLoop() {
		loop = false;
	}

	@Override
	public void run() {
		while(loop) {
			date = new Date();
			SimpleDateFormat sdf = null;
			sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			StringBuilder strDate = new StringBuilder(sdf.format(date));
			if(flag) {
				strDate.setCharAt(13, ' ');
				flag = false;
			} else {
				strDate.setCharAt(13, ':');
				flag = true;	
			}
			
			lClock.setText(strDate.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
