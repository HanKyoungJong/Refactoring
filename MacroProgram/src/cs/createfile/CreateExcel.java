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

			// 수정후 코드

			createCell(0, 8, cell1, saxObj.getData1);
			// 엑셀 1번째 열에 getData1[tableName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수

			createCell(1, 350, cell2, saxObj.getData2);
			// 엑셀 2번째 열에 getData2[logicalName 데이터값] 을 넣겠다, 여기 350은데이터 갯수

			createCell(2, 350, cell3, saxObj.getData3);
			// 엑셀 3번째 열에 getData3[columnName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수

			createCell(3, 350, cell4, saxObj.getData4);
			// 엑셀 4번째 열에 getData4[name 데이터값] 을 넣겠다, 여기 350은 데이터 갯수

			createCell(4, 350, cell5, saxObj.getData5);
			// 엑셀 5번째 열에 getData5[sizeName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수

			createCell(5, 350, cell6, saxObj.getData6);
			// 엑셀 6번째 열에 getData6[notNullName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수

			createCell(6, 350, cell7, saxObj.getData7);
			// 엑셀 7번째 열에 getData7[primaryKeyName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수

			for (int i = 0; i < 350; i++) {
				worksheet.autoSizeColumn((short) i);
				worksheet
						.setColumnWidth(i, (worksheet.getColumnWidth(i)) + 612);

				// 윗줄만으로는 컬럼의 width가 부족하여 더 늘려야함
			}

			wb.write(fos);
			fos.close();
			System.out.println(file.getAbsolutePath()
					+ "File created Successfully!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 변수 createRow는 열을 만드는 변수, dataSize는 getData들의 데이터 갯수, createCell은 몇번째 열을
	// 만드는 변수
	// getData는 tablename,logicalname 등의 변수

	public static void createCell(int createRow, int dataSize,
			XSSFCell createCell, String[] getData) {

		row1 = worksheet.createRow(createRow);
		for (int i = 0; i < dataSize; i++) {
			createCell = row1.createCell(i);
			createCell.setCellValue(getData[i]);

		}

	}

}
