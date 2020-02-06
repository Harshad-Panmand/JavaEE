import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class CheckDefaultServerURL {
	
	private static String sourceFileName = "WindchillOfficeApp.xml";
	
	
	/*
	 * private static String sourceFileName =
	 * "E:\\Harshad\\Git\\JavaEE\\XML parsing\\src\\WindchillOfficeApp.xml"; private
	 * static String destFileName =
	 * "E:\\Harshad\\Git\\JavaEE\\XML parsing\\src\\employee_updated.xml";
	 */
	private static final String DEFAULT_WEBSERVER_URL = "https://vagrant.ptcnet.ptc.com:22443";

	public static void main(String[] args) {
		File file = null;
		try {
			file = new File(sourceFileName);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);

			XPathFactory xpathfactory = XPathFactory.newInstance();
			XPath xpath = xpathfactory.newXPath();

			Node n = (Node) xpath.evaluate("//*[contains(@*," +"'" + DEFAULT_WEBSERVER_URL + "'" + ")]", doc,
					XPathConstants.NODE);
			// String res = (String) xpath.evaluate("//text()[. = 'HR']", doc,
			// XPathConstants.STRING);

			System.out.println(n.getNodeName());

			/*
			 * XPathExpression expr = xpath.compile("[. = 'https://vagrant.ptcnet.ptc']");
			 * System.out.println(expr); Object result = expr.evaluate(doc,
			 * XPathConstants.NODESET); NodeList nodes = (NodeList) result; for (int i = 0;
			 * i < nodes.getLength(); i++) {
			 * System.out.println(nodes.item(i).getNodeValue()); }
			 */

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
