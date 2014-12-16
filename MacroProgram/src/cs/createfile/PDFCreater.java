package cs.createfile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import cs.parser.DBFiledInfo;
import cs.parser.SAX;

public class PDFCreater {

	private String content, path;
	private Document doc;

	// PDF 생성 메소드
	public PDFCreater(String content, String path) {
		this.content = content;
		this.path = path;
	}

	public void createPDFFile() {
		DBFiledInfo dbfiledinfo = (DBFiledInfo) new DBFiledInfo();
		SAX saxObj = new SAX(dbfiledinfo);
		// tableName, logicalName, columnName, name, sizeName, notNullName,
		// primaryKeyName의 데이터 값을 가져옴

		try {
			saxObj.read("C://Data.xml");

			File file = new File(content);
			FileOutputStream fos = new FileOutputStream(path);

			doc = new Document();
			PdfWriter.getInstance(doc, fos);
			doc.open();
			
			PDFTitleAndMakeUpCreater("PDF", "Test PDF", "Java Test",
					"Sample PDF", "DBinfo", "Test DBInfo");
			// PDF 제목 꾸미는 메소드
			
			PDFOneTableAndCellCreater(1, saxObj.getData1);
			// PDF 1번째 테이블(차트)을 만들어 getData1(tablename)의 값을 차트안에 넣는 메소드

			PDFTwoTableAndCellCreater(1, 250, saxObj.getData2);
			// PDF 2번째 테이블(차트)을 만들어 getData1(logicalName)의 값을 차트안에 넣는 메소드

			PDFTwoTableAndCellCreater(1, 250, saxObj.getData3);
			// PDF 3번째 테이블(차트)을 만들어 getData1(columnName)의 값을 차트안에 넣는 메소드

			PDFTwoTableAndCellCreater(1, 250, saxObj.getData4);
			// PDF 4번째 테이블(차트)을 만들어 getData1(name)의 값을 차트안에 넣는 메소드

			PDFTwoTableAndCellCreater(1, 250, saxObj.getData5);
			// PDF 5번째 테이블(차트)을 만들어 getData1(sizeName)의 값을 차트안에 넣는 메소드

			PDFTwoTableAndCellCreater(1, 250, saxObj.getData6);
			// PDF 6번째 테이블(차트)을 만들어 getData1(notNullName)의 값을 차트안에 넣는 메소드

			PDFTwoTableAndCellCreater(1, 250, saxObj.getData7);
			// PDF 7번째 테이블(차트)을 만들어 getData1(primaryKeyName)의 값을 차트안에 넣는 메소드

			doc.close();

			System.out.println(file.getAbsolutePath()
					+ "created successfully! PDfFile");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// PDF 제목 꾸미는 메소드
	private void PDFTitleAndMakeUpCreater(String a, String b, String c,
			String d, String e, String f) throws DocumentException {
		doc.add(new Paragraph(a));
		doc.add(new Paragraph(new Date().toString()));

		doc.addAuthor(b);
		doc.addCreationDate();
		doc.addCreator(c);
		doc.addTitle(d);

		// Create Paragraph
		Paragraph paragraph = new Paragraph(e, new Font(
				Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));

		// New line
		paragraph.add(new Paragraph(" "));
		paragraph.add(f);
		paragraph.add(new Paragraph(" "));

		doc.add(paragraph);
	}

	// PDF 첫번째 테이블(표)를 만들고 그안에 getdata(tableName)의 데이터 갯수만큼 넣음
	private void PDFOneTableAndCellCreater(int createTable, String[] getData)
			throws DocumentException {
		PdfPCell cell;
		PdfPTable pdfTable;

		pdfTable = new PdfPTable(createTable);
		cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		pdfTable.addCell(cell);

		for (int i = 0; i < 8; i++) {

			pdfTable.addCell(getData[i]);
		}
		doc.add(pdfTable);
	}

	// PDF 두번째 테이블(표)를 만들고 그안에 getdata의 데이터 갯수만큼 넣음
	private void PDFTwoTableAndCellCreater(int createTable, int dataSzie,
			String[] getData) throws DocumentException {

		PdfPTable pdfTable1;

		pdfTable1 = new PdfPTable(createTable);

		for (int i = 0; i < dataSzie; i++) {

			pdfTable1.addCell(getData[i]);

		}
		doc.add(pdfTable1);
	}
}
