package cs.parser;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xml {
	public static void main(String args[]) {
		File file = new File("C://Data.xml");
		Document document = null;
		NodeList tableName_nodeList = null, logicalName_nodeList = null, columnName_nodeList = null, size_nodeList = null, name_nodeList = null, PK_nodeList = null, notNull_nodeList = null;

		String tableName = null, logicalName = null, columnName = null, size = null, PKName = null, name = null, notNullName = null;
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = null;

		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(file); // 해당 경로의 Xml파일 파싱하는것\.

			Element root = document.getDocumentElement(); // 여기서 root는
															// <net...>.// 최상위
															// element를 말함.

			NodeList personList = root.getElementsByTagName("listeners");
			// 해당 태그명에 해당하는 7개의 <net..> Node가 존재함. 그래서 NodeList.

			for (int i = 0; i < personList.getLength(); i++) {

				Element person = (Element) personList.item(i); // 리스트에서 Person
																// 노드를 1개씩 추출.

				tableName_nodeList = person.getElementsByTagName("tableName");
				logicalName_nodeList = person
						.getElementsByTagName("logicalName");
				columnName_nodeList = person.getElementsByTagName("columnName");
				size_nodeList = person.getElementsByTagName("size");
				name_nodeList = person.getElementsByTagName("name");
				PK_nodeList = person.getElementsByTagName("primaryKey");
				notNull_nodeList = person.getElementsByTagName("notNull");

				// Person 노드에서 태그명에 해당하는 자식노드들을 추출해서 NodeList에 세팅.

				tableName = tableName_nodeList.item(0).getTextContent();
				logicalName = logicalName_nodeList.item(0).getTextContent(); // 노드들의
																				// Value.
																				// 텍스트값을
																				// 추출.
				columnName = columnName_nodeList.item(0).getTextContent();
				size = size_nodeList.item(0).getTextContent();
				name = name_nodeList.item(0).getTextContent();
				PKName = size_nodeList.item(0).getTextContent();
				notNullName = notNull_nodeList.item(0).getTextContent();

				String tableNameNodeName = tableName_nodeList.item(0)
						.getNodeName();
				String logicalNameNodeName = logicalName_nodeList.item(0)
						.getNodeName();// 노드들의 노드명 추출.
				String columnNameNodeName = columnName_nodeList.item(0)
						.getNodeName();
				String sizeNodeName = size_nodeList.item(0).getNodeName();
				String nameNodeName = name_nodeList.item(0).getNodeName();
				String PKNodeName = PK_nodeList.item(0).getNodeName();
				String notNullNodeName = notNull_nodeList.item(0).getNodeName();

				System.out.println(person.getNodeName() + " ---------- "); // 출력.
				System.out.println(tableNameNodeName.toString() + " : "
						+ tableName.toString());
				System.out.println(logicalNameNodeName.toString() + " : "
						+ logicalName.toString());
				System.out.println(columnNameNodeName.toString() + " : "
						+ columnName.toString());
				System.out.println(logicalNameNodeName.toString() + " : "
						+ logicalName.toString());
				System.out.println(sizeNodeName.toString() + " : "
						+ size.toString());
				System.out.println(nameNodeName.toString() + " : "
						+ name.toString());
				System.out.println(notNullNodeName.toString() + ":"
						+ notNullName.toString());
				System.out.println(PKNodeName.toString() + " : "
						+ PKName.toString());
				System.out.println();
				System.out.println();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}