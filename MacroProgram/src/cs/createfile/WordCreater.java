package cs.createfile;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import cs.parser.DBFiledInfo;
import cs.parser.SAX;

public class WordCreater {
	private String content, path;
	private XWPFDocument doc;
	private XWPFTable OneTable, TwoTable;

	public WordCreater(String content, String path) {
		this.content = content;
		this.path = path;
	}

	@SuppressWarnings("unused")
	public void createWordFile() {
		try {
			DBFiledInfo dbfiledinfo = (DBFiledInfo) new DBFiledInfo();
			SAX saxObj = new SAX(dbfiledinfo);

			saxObj.read("C://Data.xml");

			File file = new File(content);
			FileOutputStream fos = new FileOutputStream(path);
			doc = new XWPFDocument();
			XWPFParagraph tempParagraph = doc.createParagraph();
			XWPFRun tempRun = tempParagraph.createRun();

			WordOneTableRowAndCellCreater(7, 0, saxObj.getData1, OneTable);
			// 워드 안에 7행1열의 표를 만들어 getData[tableName]값을 그안에 길이만큼 넣는 메소드
			doc.createParagraph().createRun().addBreak();
			// onetable과 twotable의 표를 분리
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData2, TwoTable);
			// 워드 안에 7행1열의 표를 만들어 getData[logicalName]값을 그안에 길이만큼 넣는 메소드
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData3, TwoTable);
			// 워드 안에 7행1열의 표를 만들어 getData[columnName]값을 그안에 길이만큼 넣는 메소드
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData4, TwoTable);
			// 워드 안에 7행1열의 표를 만들어 getData[name]값을 그안에 길이만큼 넣는 메소드
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData5, TwoTable);
			// 워드 안에 7행1열의 표를 만들어 getData[sizeName]값을 그안에 길이만큼 넣는 메소드
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData6, TwoTable);
			// 워드 안에 7행1열의 표를 만들어 getData[notNullName]값을 그안에 길이만큼 넣는 메소드
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData7, TwoTable);
			// 워드 안에 7행1열의 표를 만들어 getData[primaryKeyName]값을 그안에 길이만큼 넣는 메소드

			doc.write(fos);
			fos.close();

			System.out.println(file.getAbsolutePath()
					+ "created successfully! WordFile");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 워드 안에 첫번째표를 만드는 메소드
	private void WordOneTableRowAndCellCreater(int rowCreate, int cellCreate,
			String[] getData, XWPFTable tableName) {

		tableName = doc.createTable(rowCreate, cellCreate);

		for (int i = 0; i < rowCreate; i++) {
			tableName.getRow(i).getCell(cellCreate).setText(getData[i]);
		}
	}

	// 워드 안에 두번째표를 만드는 메소드
	private void WordTwoTableRowAndCellCreater(int rowCreate, int cellCreate,
			int cellInput, String[] getData, XWPFTable tableName) {

		tableName = doc.createTable(rowCreate, cellCreate);

		for (int i = 0; i < rowCreate; i++) {
			tableName.getRow(i).getCell(cellInput).setText(getData[i]);
		}
	}

}
