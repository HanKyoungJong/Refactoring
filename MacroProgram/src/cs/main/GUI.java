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

import cs.createfile.CreateExcel;
import cs.createfile.CreatePDF;
import cs.createfile.CreateWord;
import cs.createfile.CreateFile;

@SuppressWarnings("serial")
class GUI extends JFrame implements ActionListener {

	JButton b1, b2, b3, b4, b5;
	JLabel jb;
	JTextField jf;
	JTextArea ja;
	String a, b;

	public GUI() {
		setTitle("MacroProgram Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();

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
			CreateExcel ce = new CreateExcel();
			JOptionPane.showMessageDialog(this, "잠시만기다려주세요.", "Loding",
					JOptionPane.INFORMATION_MESSAGE);
			try {
				ce.createExcelFile("", "D://DBinfo/info1.xlsx");
				jf.setText("D:/DBinfo/info1.xlsx");
				JOptionPane.showMessageDialog(this, "파일이생성되었습니다.", "completed",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (s == b2) {
			CreateWord cd = new CreateWord();
			JOptionPane.showMessageDialog(this, "잠시만기다려주세요.", "Loding",
					JOptionPane.INFORMATION_MESSAGE);
			try {
				cd.createWordFile("", "D://DBinfo/info1.docx");
				JOptionPane.showMessageDialog(this, "파일이생성되었습니다.", "completed",
						JOptionPane.INFORMATION_MESSAGE);
				jf.setText("D:/DBinfo/info1.docx");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (s == b3) {
			CreatePDF cp = new CreatePDF();
			JOptionPane.showMessageDialog(this, "잠시만기다려주세요.", "Loding",
					JOptionPane.INFORMATION_MESSAGE);
			try {
				cp.createPDFFile("", "D://DBinfo/info.pdf");
				JOptionPane.showMessageDialog(this, "파일이생성되었습니다.", "completed",
						JOptionPane.INFORMATION_MESSAGE);
				jf.setText("D:/DBinfo/info.pdf");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (s == b4) {
			CreateFile cf = new CreateFile();

			cf.test(a, b);

		}

	}

}