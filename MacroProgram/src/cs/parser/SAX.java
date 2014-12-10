package cs.parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler {
	public StringBuffer tableName = new StringBuffer();
	public StringBuffer logicalName = new StringBuffer();
	public StringBuffer name = new StringBuffer();
	public StringBuffer sizeName = new StringBuffer();
	public StringBuffer columnName = new StringBuffer();
	public StringBuffer notNullName = new StringBuffer();
	public StringBuffer primaryKeyName = new StringBuffer();
	public boolean table_Name;
	public boolean logical_Name;
	public boolean column_Name;
	public boolean size_Name;
	public boolean name_Name;
	public boolean PK_Name;
	public boolean notNull_Name;
	public String[] getData1 = new String[8];
	public String[] getData2 = new String[350];
	public String[] getData3 = new String[350];
	public String[] getData4 = new String[350];
	public String[] getData5 = new String[350];
	public String[] getData6 = new String[350];
	public String[] getData7 = new String[350];
	public int i = 0;
	public int j = 0;
	public int k = 0;
	public int q = 0;
	public int w = 0;
	public int e = 0;
	public int r = 0;

	public String dbinfo = "";

	private DBFiledInfo db;

	public SAX(DBFiledInfo db) {
		this.db = db;
	}

	public void read(String fileName) throws Exception {

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser parser = saxParserFactory.newSAXParser();
		try {
			parser.parse(fileName, this);
			// A FileInputStream obtains input bytes from a file.

			// A HWPFDocument used to read document file from FileInputStream

		} catch (SAXException e) {
			System.out.println("parser Exception : " + e.getMessage());
		}
	}

	public void startDocument() throws SAXException {
		System.out.println("* START DB Information *" + "\n");
	}

	public void endDocument() throws SAXException {
		System.out.println("* END DB Information *");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {

		if (qName.equals("tableName")) {
			tableName.setLength(0);
			table_Name = true;

		} else {
			table_Name = false;
		}

		if (qName.equals("logicalName")) {
			logicalName.setLength(0);
			logical_Name = true;
		} else {
			logical_Name = false;
		}

		if (qName.equals("columnName")) {
			columnName.setLength(0);
			column_Name = true;
		} else {
			column_Name = false;
		}
		if (qName.equals("name")) {
			name.setLength(0);
			name_Name = true;
		} else {
			name_Name = false;
		}

		if (qName.equals("size")) {
			sizeName.setLength(0);
			size_Name = true;
		} else {
			size_Name = false;
		}

		if (qName.equals("notNull")) {
			notNullName.setLength(0);
			notNull_Name = true;
		} else {
			notNull_Name = false;
		}
		if (qName.equals("primaryKey")) {
			primaryKeyName.setLength(0);
			PK_Name = true;

		} else {
			PK_Name = false;
		}

	}

	public void characters(char[] ch, int start, int len) throws SAXException {
		if (table_Name) {
			tableName.append(ch, start, len);

			tableName.trimToSize();
		} else if (logical_Name) {
			logicalName.append(ch, start, len);

			logicalName.trimToSize();
		} else if (column_Name) {
			columnName.append(ch, start, len);

			columnName.trimToSize();
		} else if (name_Name) {
			name.append(ch, start, len);

			name.trimToSize();
		} else if (size_Name) {
			sizeName.append(ch, start, len);

			sizeName.trimToSize();
		} else if (notNull_Name) {
			notNullName.append(ch, start, len);

			notNullName.trimToSize();
		} else if (PK_Name) {
			primaryKeyName.append(ch, start, len);

			primaryKeyName.trimToSize();
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		DBFiledInfo dBFiledInfo = this.db;

		if (table_Name) {
			getData1[i] = "" + tableName;
			dBFiledInfo.setTableName(getData1[i].toString());
			i++;
			System.out.println(dBFiledInfo.getTableName());
		}

		else if (logical_Name) {
			getData2[j] = "" + logicalName;
			dBFiledInfo.setlogcialName(getData2[j].toString());
			j++;

			System.out.println(dBFiledInfo.getlogcialName());
		} else if (column_Name) {

			getData3[k] = "" + columnName;
			dBFiledInfo.setcolumnName(getData3[k].toString());
			k++;

			System.out.println(dBFiledInfo.getcolumnName());
		} else if (name_Name) {

			getData4[q] = "" + name;
			dBFiledInfo.setName(getData4[q].toString());
			q++;
			System.out.println(dBFiledInfo.getName());

		} else if (size_Name) {

			getData5[w] = "" + sizeName;
			dBFiledInfo.setsizeName(getData5[w].toString());
			w++;

			System.out.println(dBFiledInfo.getsizeName());
		} else if (notNull_Name) {

			getData6[e] = "" + notNullName;
			dBFiledInfo.setnotNullName(getData6[e].toString());
			e++;

			System.out.println(dBFiledInfo.getnotNullName());
		} else if (PK_Name) {

			getData7[r] = "" + primaryKeyName;
			dBFiledInfo.setprimaryKeyName(getData7[r].toString());
			r++;
			System.out.println(dBFiledInfo.getprimaryKeyName());
			System.out
					.println("--------------------------------------------------");
		}

	}

	public void warning(SAXParseException exception) throws SAXException {
		System.err.println("[Warning] " + exception.getMessage() + " at line "
				+ exception.getLineNumber() + ", column "
				+ exception.getColumnNumber());
	}

	public void error(SAXParseException exception) throws SAXException {
		System.err.println("[Error] " + exception.getMessage() + " at line "
				+ exception.getLineNumber() + ", column "
				+ exception.getColumnNumber());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("[Fatal Error] " + exception.getMessage()
				+ " at line " + exception.getLineNumber() + ", column "
				+ exception.getColumnNumber());
		throw exception;
	}

	public String getendElement() {
		dbinfo = dbinfo + db.getTableName();
		dbinfo = dbinfo + db.getlogcialName();
		dbinfo = dbinfo + db.getcolumnName();
		dbinfo = dbinfo + db.getName();
		dbinfo = dbinfo + db.getsizeName();
		dbinfo = dbinfo + db.getnotNullName();
		dbinfo = dbinfo + db.getprimaryKeyName();
		return dbinfo.toString();
	}

}
