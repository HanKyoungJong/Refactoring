package cs.createfile;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import cs.parser.DBFiledInfo;
import cs.parser.SAX;

public class CreateWord {
	@SuppressWarnings("unused")
	public static void createWordFile(String content, String path)
			throws Exception {
		try {
			DBFiledInfo dbfiledinfo = (DBFiledInfo) new DBFiledInfo();
			SAX saxObj = new SAX(dbfiledinfo);
			saxObj.read("C://Data.xml");

			File file = new File(content);
			FileOutputStream fos = new FileOutputStream(path);
			XWPFDocument doc = new XWPFDocument();
			XWPFParagraph tempParagraph = doc.createParagraph();
			XWPFRun tempRun = tempParagraph.createRun();

			XWPFTable table1 = doc.createTable(7, 0);
			doc.createParagraph().createRun().addBreak();
			XWPFTable table2 = doc.createTable(1, 5);

			
			table2.getRow(0).getCell(0).setText("로지컬명");
			table2.getRow(0).getCell(1).setText("피지컬명");
			table2.getRow(0).getCell(2).setText("속     성");
			table2.getRow(0).getCell(3).setText("키     값");
			table2.getRow(0).getCell(4).setText("널     값");


			XWPFTable table3 = doc.createTable(220, 5);

			for (int i = 0; i < 7; i++) {
				
				table1.getRow(i).getCell(0).setText(saxObj.getData1[i]);

			}
			for (int j = 0; j < 220; j++) {
				
				table3.getRow(j).getCell(0).setText(saxObj.getData2[j]);
				table3.getRow(j).getCell(1).setText(saxObj.getData3[j]);
				table3.getRow(j).getCell(2).setText(saxObj.getData4[j]  + "(" + saxObj.getData5[j]	+ ")");
				table3.getRow(j).getCell(3).setText(saxObj.getData6[j]);
				table3.getRow(j).getCell(4).setText(saxObj.getData7[j]);
				
			}

			// tempRun.setText(saxObj.getendElement());
			// tempRun.setFontSize(12);
			doc.write(fos);
			fos.close();

			System.out.println(file.getAbsolutePath()
					+ "created successfully! WordFile");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
