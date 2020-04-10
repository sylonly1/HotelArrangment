package Mec_java_View;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class ShowTime implements Runnable {
	JLabel label;
	
	public ShowTime(JLabel label) {
		this.label = label;
	}
	
	@Override
	public void run() {
	while(true) {
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String str = sdf.format(d);
		 label.setText(str);
		try {
			Thread.sleep(333);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	}
	
	
	
}
