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

	// 엑셀 생성 메소드
	public ExcelCreater(String content, String path) {
		this.content = content;
		this.path = path;
	}

	public void createExcelFile() {

		DBFiledInfo dbfiledinfo = (DBFiledInfo) new DBFiledInfo();
		// tableName, logicalName, columnName, name, sizeName, notNullName,
		// primaryKeyName의 데이터 값을 가져옴

		SAX saxObj = new SAX(dbfiledinfo);
		// SAX는 xml 파싱 종류로 dbfileinfo에서 가져온 데이터를 원하는 값만 가져옴
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

			// // 수정후 코드
			cellCreater(0, 8, saxObj.getData1);
			// 엑셀 1번째 열에 getData1[tableName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수
			cellCreater(1, 350, saxObj.getData2);
			// 엑셀 2번째 열에 getData1[logicalName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수
			cellCreater(2, 350, saxObj.getData3);
			// 엑셀 3번째 열에 getData1[columnName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수
			cellCreater(3, 350, saxObj.getData4);
			// 엑셀 4번째 열에 getData1[name 데이터값] 을 넣겠다, 여기 350은 데이터 갯수
			cellCreater(4, 350, saxObj.getData5);
			// 엑셀 5번째 열에 getData1[sizeName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수
			cellCreater(5, 350, saxObj.getData6);
			// 엑셀 6번째 열에 getData1[notNullName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수
			cellCreater(6, 350, saxObj.getData7);
			// 엑셀 7번째 열에 getData1[primaryKeyName 데이터값] 을 넣겠다, 여기 350은 데이터 갯수

			autoColumnWidthSize();
			// 자동으로 컬럼, width 맞추는 메소드

			wb.write(fos);
			fos.close();
			// 파일경로를 표시, 파일이 제대로 생성되었는지에대한 출력
			System.out.println(file.getAbsolutePath()
					+ "File created Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 변수 createRow는 열을 만드는 변수, dataSize는 getData들의 데이터 갯수, createCell은 몇번째 열을
	// 만드는 변수
	// getData는 tablename,logicalname 등의 변수

	private void cellCreater(int createRow, int dataSize, String[] getData) {
		XSSFCell createCell;
		row = worksheet.createRow(createRow);

		for (int i = 0; i < dataSize; i++) {
			createCell = row.createCell(i);
			createCell.setCellValue(getData[i]);
		}
	}

	// 자동으로 컬럼, width 맞추는 메소드
	private void autoColumnWidthSize() {
		for (int i = 0; i < 350; i++) {
			worksheet.autoSizeColumn((short) i);
			worksheet.setColumnWidth(i, (worksheet.getColumnWidth(i)) + 612);

		}

	}

}
