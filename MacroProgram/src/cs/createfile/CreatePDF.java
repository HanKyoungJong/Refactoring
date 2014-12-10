package cs.createfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import cs.parser.DBFiledInfo;
import cs.parser.SAX;

public class CreatePDF {
	public void createPDFFile(String content, String path) {
		try {
			DBFiledInfo dbfiledinfo = (DBFiledInfo) new DBFiledInfo();
			SAX saxObj = new SAX(dbfiledinfo);
			saxObj.read("C://Data.xml");

			File file = new File(content);
			FileOutputStream fos = new FileOutputStream(path);

			Document doc = new Document();
			PdfWriter.getInstance(doc, fos);

			doc.open();
			doc.add(new Paragraph("PDF¸¸µé±â"));
			doc.add(new Paragraph(new Date().toString()));

			doc.addAuthor("Krishna Srinivasan");
			doc.addCreationDate();
			doc.addCreator("JavaBeat");
			doc.addTitle("Sample PDF");

			// Create Paragraph
			Paragraph paragraph = new Paragraph("DBInfo", new Font(
					Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));

			// New line
			paragraph.add(new Paragraph(" "));
			paragraph.add("Test DBInfo");
			paragraph.add(new Paragraph(" "));
			doc.add(paragraph);

			// Create a table in PDF
			PdfPTable pdfTable = new PdfPTable(1);
			PdfPTable pdfTable1 = new PdfPTable(1);
			PdfPTable pdfTable2 = new PdfPTable(1);
			PdfPTable pdfTable3 = new PdfPTable(1);
			PdfPTable pdfTable4 = new PdfPTable(1);
			PdfPTable pdfTable5 = new PdfPTable(1);
			PdfPTable pdfTable6 = new PdfPTable(1);

			for (int i = 0; i < 8; i++) {
				PdfPCell cell1 = new PdfPCell();
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(cell1);
				pdfTable.addCell(saxObj.getData1[i]);
			}
			for (int i = 0; i < 250; i++) {

				pdfTable1.addCell(saxObj.getData2[i]);
				pdfTable2.addCell(saxObj.getData3[i]);
				pdfTable3.addCell(saxObj.getData4[i]);
				pdfTable4.addCell(saxObj.getData5[i]);
				pdfTable5.addCell(saxObj.getData6[i]);
				pdfTable6.addCell(saxObj.getData7[i]);

			}

			doc.add(pdfTable);
			doc.add(pdfTable1);
			doc.add(pdfTable2);
			doc.add(pdfTable3);
			doc.add(pdfTable4);
			doc.add(pdfTable5);
			doc.add(pdfTable6);

			doc.close();

			System.out.println(file.getAbsolutePath()
					+ "created successfully! PDfFile");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
