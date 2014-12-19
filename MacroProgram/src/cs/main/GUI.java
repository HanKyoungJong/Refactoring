package cs.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cs.createfile.PDFCreater;
import cs.createfile.ExcelCreater;
import cs.createfile.CreateFile;
import cs.createfile.WordCreater;

@SuppressWarnings("serial")
class GUI extends JFrame implements ActionListener {
	private JButton b1, b2, b3, b4, b5;
	JLabel jb;
	JTextField jf;
	JTextArea ja;
	String a, b;
	JPanel p;

	public GUI() {
		setTitle("MacroProgram Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new JPanel();

		p.setLayout(null);

		jb = new JLabel(":");
		jf = new JTextField(20);
		b1 = new JButton("엑셀");
		b2 = new JButton("워드");
		b3 = new JButton("PDF");
		b4 = new JButton("Input");
		b5 = new JButton("PPT");

		jf.setText("...................");

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(jb);
		p.add(jf);

		jb.setBounds(5, 30, 30, 25);
		jf.setBounds(10, 30, 215, 25);

		b1.setBounds(5, 80, 70, 50);
		b2.setBounds(80, 80, 70, 50);
		b3.setBounds(155, 80, 70, 50);
		b4.setBounds(230, 30, 70, 25);
		b5.setBounds(230, 80, 70, 50);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		jf.addActionListener(this);

		add(p);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				dispose();
			}
		});

	}

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
		JButton s = (JButton) e.getSource();

		if (s == b1) {
			ExcelImpleMented();
		} else if (s == b2) {
			WordImpleMented();
		} else if (s == b3) {
			PDFImpleMented();

		} else if (s == b4) {
			CreateFile cf = new CreateFile();

			cf.test();

		}

	}

	private void showMessage(String showMessage, String showLoding) {

		JOptionPane.showMessageDialog(this, showMessage, showLoding,
				JOptionPane.INFORMATION_MESSAGE);

	}

	private void setTextFileRoute(String fileRoute) {

		jf.setText(fileRoute);

	}

	private void ExcelImpleMented() {
		ExcelCreater ce = new ExcelCreater("", "D://DBinfo/info1.xlsx");
		showMessage("잠시만기다려주세요.", "Loding");
		try {
			ce.createExcelFile();
			setTextFileRoute("D:/DBinfo/info1.xlsx");
			showMessage("파일이생성되었습니다.", "completed");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void WordImpleMented() {
		WordCreater cd = new WordCreater("", "D://DBinfo/info1.docx");
		showMessage("잠시만기다려주세요.", "Loding");
		try {
			cd.createWordFile();
			setTextFileRoute("D:/DBinfo/info1.docx");
			showMessage("파일이생성되었습니다.", "completed");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void PDFImpleMented() {
		PDFCreater cp = new PDFCreater("", "D://DBinfo/info.pdf");
		showMessage("잠시만기다려주세요.", "Loding");
		try {
			cp.createPDFFile();
			setTextFileRoute("D:/DBinfo/info.pdf");
			showMessage("파일이생성되었습니다.", "completed");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}