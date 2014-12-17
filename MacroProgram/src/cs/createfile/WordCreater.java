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
			// ���� �ȿ� 7��1���� ǥ�� ����� getData[tableName]���� �׾ȿ� ���̸�ŭ �ִ� �޼ҵ�
			doc.createParagraph().createRun().addBreak();
			// onetable�� twotable�� ǥ�� �и�
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData2, TwoTable);
			// ���� �ȿ� 7��1���� ǥ�� ����� getData[logicalName]���� �׾ȿ� ���̸�ŭ �ִ� �޼ҵ�
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData3, TwoTable);
			// ���� �ȿ� 7��1���� ǥ�� ����� getData[columnName]���� �׾ȿ� ���̸�ŭ �ִ� �޼ҵ�
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData4, TwoTable);
			// ���� �ȿ� 7��1���� ǥ�� ����� getData[name]���� �׾ȿ� ���̸�ŭ �ִ� �޼ҵ�
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData5, TwoTable);
			// ���� �ȿ� 7��1���� ǥ�� ����� getData[sizeName]���� �׾ȿ� ���̸�ŭ �ִ� �޼ҵ�
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData6, TwoTable);
			// ���� �ȿ� 7��1���� ǥ�� ����� getData[notNullName]���� �׾ȿ� ���̸�ŭ �ִ� �޼ҵ�
			WordTwoTableRowAndCellCreater(220, 1, 0, saxObj.getData7, TwoTable);
			// ���� �ȿ� 7��1���� ǥ�� ����� getData[primaryKeyName]���� �׾ȿ� ���̸�ŭ �ִ� �޼ҵ�

			doc.write(fos);
			fos.close();

			System.out.println(file.getAbsolutePath()
					+ "created successfully! WordFile");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���� �ȿ� ù��°ǥ�� ����� �޼ҵ�
	private void WordOneTableRowAndCellCreater(int rowCreate, int cellCreate,
			String[] getData, XWPFTable tableName) {

		tableName = doc.createTable(rowCreate, cellCreate);

		for (int i = 0; i < rowCreate; i++) {
			tableName.getRow(i).getCell(cellCreate).setText(getData[i]);
		}
	}

	// ���� �ȿ� �ι�°ǥ�� ����� �޼ҵ�
	private void WordTwoTableRowAndCellCreater(int rowCreate, int cellCreate,
			int cellInput, String[] getData, XWPFTable tableName) {

		tableName = doc.createTable(rowCreate, cellCreate);

		for (int i = 0; i < rowCreate; i++) {
			tableName.getRow(i).getCell(cellInput).setText(getData[i]);
		}
	}

}
