package cs.createfile;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cs.parser.DBFiledInfo;
import cs.parser.SAX;

import java.io.IOException;

public class CreateExcel {
	private static XSSFCell cell1, cell2, cell3, cell4, cell5, cell6, cell7;
	private static XSSFRow row1;
	private static XSSFSheet worksheet;

	public static void createExcelFile(String content, String path)
			throws Exception {
		try {
			DBFiledInfo dbfiledinfo = (DBFiledInfo) new DBFiledInfo();
			SAX saxObj = new SAX(dbfiledinfo);
			saxObj.read("C://Data.xml");
			File file = new File(content);

			FileOutputStream fos = new FileOutputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook();
			worksheet = wb.createSheet();

			// ������ �ڵ�

			createCell(0, 8, cell1, saxObj.getData1);
			// ���� 1��° ���� getData1[tableName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����

			createCell(1, 350, cell2, saxObj.getData2);
			// ���� 2��° ���� getData2[logicalName �����Ͱ�] �� �ְڴ�, ���� 350�������� ����

			createCell(2, 350, cell3, saxObj.getData3);
			// ���� 3��° ���� getData3[columnName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����

			createCell(3, 350, cell4, saxObj.getData4);
			// ���� 4��° ���� getData4[name �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����

			createCell(4, 350, cell5, saxObj.getData5);
			// ���� 5��° ���� getData5[sizeName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����

			createCell(5, 350, cell6, saxObj.getData6);
			// ���� 6��° ���� getData6[notNullName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����

			createCell(6, 350, cell7, saxObj.getData7);
			// ���� 7��° ���� getData7[primaryKeyName �����Ͱ�] �� �ְڴ�, ���� 350�� ������ ����

			for (int i = 0; i < 350; i++) {
				worksheet.autoSizeColumn((short) i);
				worksheet
						.setColumnWidth(i, (worksheet.getColumnWidth(i)) + 612);

				// ���ٸ����δ� �÷��� width�� �����Ͽ� �� �÷�����
			}

			wb.write(fos);
			fos.close();
			System.out.println(file.getAbsolutePath()
					+ "File created Successfully!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ���� createRow�� ���� ����� ����, dataSize�� getData���� ������ ����, createCell�� ���° ����
	// ����� ����
	// getData�� tablename,logicalname ���� ����

	public static void createCell(int createRow, int dataSize,
			XSSFCell createCell, String[] getData) {

		row1 = worksheet.createRow(createRow);
		for (int i = 0; i < dataSize; i++) {
			createCell = row1.createCell(i);
			createCell.setCellValue(getData[i]);

		}

	}

}
