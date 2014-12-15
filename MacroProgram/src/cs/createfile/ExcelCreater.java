package cs.createfile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cs.parser.DBFiledInfo;
import cs.parser.SAX;

public class ExcelCreater {
	private String content, path;
	private XSSFRow row;
	private XSSFSheet worksheet;

	// ���� ���� �޼ҵ�
	public ExcelCreater(String content, String path) {
		this.content = content;
		this.path = path;
	}

	public void createExcelFile() {

		DBFiledInfo dbfiledinfo = (DBFiledInfo) new DBFiledInfo();
		// tableName, logicalName, columnName, name, sizeName, notNullName,
		// primaryKeyName�� ������ ���� ������

		SAX saxObj = new SAX(dbfiledinfo);
		// SAX�� xml �Ľ� ������ dbfileinfo���� ������ �����͸� ���ϴ� ���� ������
		try {
			saxObj.read("C://Data.xml");
			// List dataArrayList = saxObj.getDataArrayList();
			File file = new File(content);

			FileOutputStream fos = new FileOutputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook();
			worksheet = wb.createSheet();

			// for (int i = 0; i < dataArrayList.size(); i++) {
			// createCell(i, 350, (String[]) dataArrayList.get(i));
			// }

			// // ������ �ڵ�
			cellCreater(0, 8, saxObj.getData1);
			// ���� 1��° ���� getData1[tableName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����
			cellCreater(1, 350, saxObj.getData2);
			// ���� 2��° ���� getData1[logicalName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����
			cellCreater(2, 350, saxObj.getData3);
			// ���� 3��° ���� getData1[columnName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����
			cellCreater(3, 350, saxObj.getData4);
			// ���� 4��° ���� getData1[name �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����
			cellCreater(4, 350, saxObj.getData5);
			// ���� 5��° ���� getData1[sizeName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����
			cellCreater(5, 350, saxObj.getData6);
			// ���� 6��° ���� getData1[notNullName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����
			cellCreater(6, 350, saxObj.getData7);
			// ���� 7��° ���� getData1[primaryKeyName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����

			autoColumnWidthSize();
			// �ڵ����� �÷�, width ���ߴ� �޼ҵ�

			wb.write(fos);
			fos.close();
			// ���ϰ�θ� ǥ��, ������ ����� �����Ǿ����������� ���
			System.out.println(file.getAbsolutePath()
					+ "File created Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���� createRow�� ���� ����� ����, dataSize�� getData���� ������ ����, createCell�� ���° ����
	// ����� ����
	// getData�� tablename,logicalname ���� ����

	private void cellCreater(int createRow, int dataSize, String[] getData) {
		XSSFCell createCell;
		row = worksheet.createRow(createRow);

		for (int i = 0; i < dataSize; i++) {
			createCell = row.createCell(i);
			createCell.setCellValue(getData[i]);
		}
	}

	// �ڵ����� �÷�, width ���ߴ� �޼ҵ�
	private void autoColumnWidthSize() {
		for (int i = 0; i < 350; i++) {
			worksheet.autoSizeColumn((short) i);
			worksheet.setColumnWidth(i, (worksheet.getColumnWidth(i)) + 612);

		}

	}

}
