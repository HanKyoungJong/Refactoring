package cs.createfile;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;

public class CreateFile {
	public static void test() {

		Frame f = new Frame();
		FileDialog fd = new FileDialog(f, "Please select the file");
		fd.setVisible(true);

		if (fd.getDirectory() != null && fd.getFile() != null) {

			String execFile = fd.getDirectory() + fd.getFile();
			File file = new File(execFile);

			try {
				new ProcessBuilder(execFile).start();
			} catch (IOException e) {
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().edit(file);
					} catch (IOException e1) {
						e1.printStackTrace();
						System.out
								.println("This file can't be run on the computer");
					}
				}
			}
		}
	}

}
