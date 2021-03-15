package org.eclipse.om2m.smartehealth.main;

import java.io.StringReader;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class DataParser {


	public HashMap<String, String> parseData(String xmlString) {
		HashMap<String, String> values = new HashMap<String, String>();

		Document xml = convertStringToDocument(xmlString);
		Node user = xml.getFirstChild();
		NodeList childs = user.getChildNodes();
		Node child;
		for (int i = 0; i < childs.getLength(); i++) {
			child = childs.item(i);
			if (!child.getNodeName().equals("#text")) {
				 //System.out.println(child.getNodeName() + " value: " + child.getTextContent());
				getAttributesPairs(child, values);
				if (!child.getNodeName().equals("con")) {
					values.put(child.getNodeName(), child.getTextContent());
					//System.out.println("1");
				}
			}
		}
		//System.out.println(values.get("Address"));
		//System.out.println("Data is: " + values.entrySet());
		return values;
	}

	private static void getAttributesPairs(Node child, HashMap<String, String> values) {
		if (child.getTextContent().contains("xml")) {
			String value = child.getTextContent();

			Pattern NEWLINE = Pattern.compile("\\R");
			String lines[] = NEWLINE.split(value);
			for (String s : lines) {
				if (s.contains("<str")) {
					String[] vals = s.split(" name=");
					String val = "";
					String key = "";
					for (String a : vals) {
						if (a.contains("<str val=")) {
							val = a.substring(14, a.length() - 1);
							//System.out.println("ddddddddddd: " + a.substring(14, a.length() - 1));

						} else if (a.contains("\"/>")) {
							key = a.substring(1, a.length() - 3);
							//System.out.println("gggggggggg: " + a.substring(1, a.length() - 3));
						}

					}
					values.put(key, val);

				}

			}
			

		}

	}

	private static Document convertStringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
