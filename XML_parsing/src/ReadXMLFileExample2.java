import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFileExample2 {
	private static String sourceFileName = "E:\\Harshad\\Git\\JavaEE\\XML parsing\\src\\WindchillOfficeApp.xml";
	private static String destFileName = "E:\\Harshad\\Git\\JavaEE\\XML parsing\\src\\employee_updated.xml";

	public static void main(String[] args) {
		File file = null;
		try {
			file = new File(sourceFileName);
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			System.out.println("Root element: " + document.getDocumentElement().getNodeName());

			document.getDocumentElement().normalize();

			if (document.hasChildNodes()) {
				updateHostUrlString(document.getChildNodes());
				updateHostUrlString(document.getChildNodes());
			}

			saveUpdatedHostUrlStringInFile(document, destFileName);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void saveUpdatedHostUrlStringInFile(Document updateDocument, String fileName)
			throws TransformerException {
		updateDocument.getDocumentElement().normalize();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(updateDocument);
		StreamResult result = new StreamResult(new File(fileName));
		transformer.setOutputProperty(OutputKeys.INDENT, "no");
		transformer.transform(source, result);
		System.out.println("XML file updated successfully");
	}

	private static void updateHostUrlString(NodeList nodeList) {

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node elemNode = nodeList.item(count);

			if (elemNode.getNodeType() == Node.ELEMENT_NODE) {
				// get node name and value
				/*
				 * System.out.println("\nNode Name =" + elemNode.getNodeName() + " [OPEN]");
				 * System.out.println("Node Content =" + elemNode.getTextContent());
				 */
				if (elemNode.hasAttributes()) {

					NamedNodeMap nodeMap = elemNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {

						Node node = nodeMap.item(i);

						String nodeValue = node.getNodeValue();
						if (nodeValue.contains("https://vagrant.ptcnet.ptc.com:22443")) {
							System.out.println("*******************************************");
							System.out.println("Node Name =" + elemNode.getNodeName());
							System.out.println("attr name : " + node.getNodeName());
							System.out.println("attr value : " + nodeValue);

							String[] urlString = nodeValue.split("Windchill");

							for (int delimiterIndex = 0; delimiterIndex < urlString.length; delimiterIndex++) {
								System.out.println("[" + delimiterIndex + "]" + urlString[delimiterIndex]);
								if (delimiterIndex == 0) {
									urlString[delimiterIndex] = "https://google.com:2222/";
								}
							}

							String newNodeValue = null;

							if (urlString.length > 1) {
								newNodeValue = urlString[0] + "Windchill" + urlString[1];
							} else {
								newNodeValue = urlString[0];
							}

							node.setNodeValue(newNodeValue);

						} else if (nodeValue.contains("https://google.com:2222/")) {
							System.out.println("###########################################");
							System.out.println("attr name : " + node.getNodeName());
							System.out.println("attr value : " + nodeValue);
						}
					}
				}

				if (elemNode.hasChildNodes()) {
					// recursive call if the node has child nodes
					updateHostUrlString(elemNode.getChildNodes());
				}
				// System.out.println("Node Name =" + elemNode.getNodeName() + " [CLOSE]");
			}
		}
	}
}