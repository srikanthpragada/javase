import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DownloadManager extends JFrame {

	JTextField tfUrl;
	JButton btnDownload;
	JTextArea taLog;
	FileWriter logFile;
	static String BASEFOLDER;
	
	static {
		BASEFOLDER = System.getProperty("user.dir") + "\\";
		System.out.println(BASEFOLDER);
	}

	public DownloadManager() {
		super("Download Manager 1.0");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// UI
		tfUrl = new JTextField(30);
		btnDownload = new JButton("Download");
		taLog = new JTextArea();

		JPanel tp = new JPanel();
		tp.add(new JLabel("URL :"));
		tp.add(tfUrl);
		tp.add(btnDownload);

		Container c = getContentPane();
		c.add(tp, BorderLayout.PAGE_START);

		JScrollPane sp = new JScrollPane(taLog, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		c.add(sp);

		// Event handling
		btnDownload.addActionListener(e -> download());

		// log file
		try {
			logFile = new FileWriter(BASEFOLDER + "download.log", true);
		} catch (Exception ex) {

		}

	}

	private void download() {
		DownloadThread t = new DownloadThread(tfUrl.getText());
		t.start();
		taLog.append("Started Downloading  : " + tfUrl.getText() + " at " + LocalDateTime.now().toString() + "\n");
		try {
			logFile.write("Started Downloading  : " + tfUrl.getText() + " at " + LocalDateTime.now().toString() + "\n");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {

		DownloadManager f = new DownloadManager();
		f.setSize(500, 300);
		f.setVisible(true);
	}

	class DownloadThread extends Thread {
		String urlString;

		public DownloadThread(String urlString) {
			this.urlString = urlString;
		}

		@Override
		public void run() {
			try {
				URL url = new URL(urlString);
				InputStream is = url.openStream();
				// get file in url

				int pos = urlString.lastIndexOf("/");
				String filename = urlString.substring(pos + 1);

				FileOutputStream fos = new FileOutputStream(BASEFOLDER + filename);

				while (true) {
					byte data[] = new byte[1000];
					int bytesRead = is.read(data);

					fos.write(data, 0, bytesRead);

					if (bytesRead < data.length) {
						break; // EOF
					}

					Thread.sleep(1000);
				}
				fos.close();
				logFile.append(
						"Completed Downloading  : " + urlString + " at " + LocalDateTime.now().toString() + "\n");
				logFile.flush();

				JOptionPane.showMessageDialog(DownloadManager.this, "Downloading [" + urlString + "] Completed",
						"Status", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				try {
					logFile.write("Error : " + ex.getMessage() + "\n");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
	}

}
