package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLParser {

	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document document = db.parse("http://api.kcisa.kr/openapi/service/rest/convergence2017/conver3?serviceKey=c2222d02-8e16-4173-b0d1-5ede723513b3");
			Element root = document.getDocumentElement();
			NodeList nodeList = root.getChildNodes();
			for(int i=0; i<nodeList.getLength(); i++) {
				Node n = nodeList.item(i);
				if(n.getNodeName().equals("body")) {
					NodeList bodyNodeList = n.getChildNodes();
					for(int j=0; j<bodyNodeList.getLength(); j++) {
						Node n2 = bodyNodeList.item(j);
						if(n2.getNodeName().equals("items")) {
							NodeList itemsNodeList = n2.getChildNodes();
							for(int k=0; k<itemsNodeList.getLength(); k++) {
								Node n3 = itemsNodeList.item(k);
								NodeList itemNodeList  = n3.getChildNodes();
								for(int l=0; l<itemNodeList.getLength(); l++) {
									Node n4 = itemNodeList.item(l);
									System.out.println(n4.getNodeName() +  " : " + n4.getTextContent());
								}
							}
							
						}
						
					}
				}
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
