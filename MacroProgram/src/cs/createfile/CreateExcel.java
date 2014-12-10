package cs.createfile;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import cs.parser.DBFiledInfo;
import cs.parser.SAX;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cs.parser.DBFiledInfo;
import cs.parser.SAX;

public class CreateExcel {

	public static void createExcelFile(String content, String path)
			throws Exception {
		try {
			DBFiledInfo dbfiledinfo = (DBFiledInfo) new DBFiledInfo();
			SAX saxObj = new SAX(dbfiledinfo);
			saxObj.read("C://Data.xml");
			File file = new File(content);

			FileOutputStream fos = new FileOutputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet worksheet = wb.createSheet();
			XSSFRow row1 = worksheet.createRow(0);
			for (int i = 0; i < 8; i++) {
				XSSFCell cell1 = row1.createCell(i);
				cell1.setCellValue(saxObj.getData1[i]);
			}

			XSSFRow row2 = worksheet.createRow(1);
			for (int i = 0; i < 350; i++) {

				XSSFCell cell2 = row2.createCell(i);
				cell2.setCellValue(saxObj.getData2[i]);

			}
			XSSFRow row3 = worksheet.createRow(2);
			for (int i = 0; i < 350; i++) {

				XSSFCell cell3 = row3.createCell(i);
				cell3.setCellValue(saxObj.getData3[i]);

			}
			XSSFRow row4 = worksheet.createRow(3);
			for (int i = 0; i < 350; i++) {

				XSSFCell cell4 = row4.createCell(i);
				cell4.setCellValue(saxObj.getData4[i]);

			}
			XSSFRow row5 = worksheet.createRow(4);
			for (int i = 0; i < 350; i++) {

				XSSFCell cell5 = row5.createCell(i);
				cell5.setCellValue(saxObj.getData5[i]);

			}
			XSSFRow row6 = worksheet.createRow(5);
			for (int i = 0; i < 350; i++) {

				XSSFCell cell6 = row6.createCell(i);
				cell6.setCellValue(saxObj.getData6[i]);

			}
			XSSFRow row7 = worksheet.createRow(6);
			for (int i = 0; i < 350; i++) {

				XSSFCell cell7 = row7.createCell(i);
				cell7.setCellValue(saxObj.getData7[i]);

			}
			for(int i=0; i<350; i++){
				worksheet.autoSizeColumn((short)i);
				worksheet.setColumnWidth(i, (worksheet.getColumnWidth(i))+612 );  // 윗줄만으로는 컬럼의 width 가 부족하여 더 늘려야 함.
				}

			wb.write(fos);
			fos.close();
			System.out.println(file.getAbsolutePath()
					+ "File created Successfully!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
