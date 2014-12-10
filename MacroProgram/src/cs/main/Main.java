package cs.main;

import cs.createfile.CreateExcel;
import cs.createfile.CreatePDF;
import cs.createfile.CreateWord;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {

		
		
		CreateExcel ce = new CreateExcel();
		ce.createExcelFile("", "D://dbinfo.xlsx");
		
		CreatePDF cf = new CreatePDF();
		cf.createPDFFile("", "D://dbinfo.pdf");
		
		CreateWord cw = new CreateWord();
		cw.createWordFile("","D://dbinfo.docx");
		
		
		
		
		
		
		
	}
}
