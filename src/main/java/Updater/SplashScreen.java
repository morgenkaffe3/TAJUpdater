package Updater;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import org.update4j.FileMetadata;
import org.update4j.service.UpdateHandler;

public class SplashScreen implements UpdateHandler {
	private final JFrame frame;
	private final JProgressBar progressBar;
	private final JLabel status;
	
	public SplashScreen() {
		this.frame = this.createFrame();
		this.progressBar = this.createProgressBar();
		this.status = this.createStatus();
		
		this.frame.add(this.progressBar);
		this.frame.add(this.status);
		this.frame.setVisible(true);
	}
	
	private JLabel createStatus() {
		JLabel status = new JLabel("Initializing...");
		status.setFont(new Font("arial",Font.PLAIN,15));//Setting font size of text
		status.setForeground(Color.BLUE);//Setting foreground color
		status.setBounds(110, 340, 400, 40);
		return status;
	}
	
	private JFrame createFrame() {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setSize(600, 400);
		
		//Setting location to the center of screen
		frame.setLocationRelativeTo(null);
		
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JLabel appName = new JLabel("TeaseAI-Java");
		appName.setFont(new Font("arial",Font.BOLD,30));//Setting font size of text
		appName.setForeground(Color.BLUE);//Setting foreground color
		appName.setBounds(170, 220, 600, 40);
		frame.add(appName);

		return frame;
	}

	private JProgressBar createProgressBar() {
		JProgressBar progress = new JProgressBar();
		progress.setBounds(100,280,400,30);
		progress.setValue(0);
		progress.setStringPainted(true);
		progress.setBorderPainted(true);
		progress.setStringPainted(true);
		progress.setBackground(Color.WHITE);
		progress.setForeground(Color.BLACK);
		return progress;
	}

	
	private void updateStatus(String text) {
		this.status.setText(text);
	}
	
	@Override
	public void startCheckUpdates() {
		this.updateStatus("Checking for updates...");
	}

	

	@Override
	public void updateDownloadProgress(float frac) {
		this.progressBar.setValue((int)(100*frac));
	}

	@Override
	public void startDownloadFile(FileMetadata file) {
		this.updateStatus("Downloading file: " + file.getUri());
	}

	@Override
	public void startDownloads() {
		this.updateStatus("Starting download...");
	}
	

	@Override
	public void succeeded() {
		this.updateStatus("Done.");
		this.frame.dispose();
	}
}
