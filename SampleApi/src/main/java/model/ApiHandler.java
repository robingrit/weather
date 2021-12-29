package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ApiHandler {

	//public static String URL = "http://api.openweathermap.org/data/2.5/weather?q=malmo,se&APPID=099eff339f56d6a29a9823857b2f2671&mode=xml";
// behöver vara String istället för void om ska printa i consolen
	public static void getApi(weatherBean wBean) throws IOException {

		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStr() + ","
				+ wBean.getCountryStr() + "&APPID=cc487e7c8408e1dd9c39e1061d911cc0&mode=xml";

		// Printar info i consolen "&APPID=cc487e7c8408e1dd9c39e1061d911cc0&mode=xml"
		//System.out.println(URLtoSend) ;

		URL line_api_url = new URL(URLtoSend);

		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();

		// skickar och tar emot api/Data
		linec.setDoInput(true);
		linec.setDoOutput(true);

		// Defultar till get annars
		linec.setRequestMethod("GET");

		// Gör uppkoppling
		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		// Hantera responsen
		String inputLine;
		// när man inte vet hur långt svaret är
		String ApiResponse = "";

		while ((inputLine = in.readLine()) != null) {
			// System.out.println(InputLine);

			ApiResponse += inputLine;

		}
		// viktigt att alltid stänga
		in.close();

		// Bra testa se allt kommer med
		// print the response
		// System.out.println(ApiResponse);

		// Call a method to make a XMLdoc out of the full response
		Document doc = convertStringToXMLDocument(ApiResponse);

		// normalize the XML response
		doc.getDocumentElement().normalize();
		// check that the XML response is OK by getting the Root element ( första
		// taggen)
		//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		// Create a Node list that gets everything in and under the "joke" tag
		NodeList nList = doc.getElementsByTagName("clouds");
		NodeList nList2 = doc.getElementsByTagName("feels_like");
		NodeList nList3 = doc.getElementsByTagName("lastupdate");
		// loop through the content of the tag(good to do even if there is only one
		// thing in the tag)
		for (int temp = 0; temp < nList.getLength(); temp++) {
			// Save a node of the current list id
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;
				// get the content of an attribute in element
				String XMLclouds = eElement.getAttribute("name");
				//System.out.println(wBean.getCityStr() + " is now a " + XMLclouds);
				wBean.setCloudsStr(XMLclouds);
			}
		}
		//Temprature
		for (int temp = 0; temp < nList2.getLength(); temp++) {
			// Save a node of the current list id
			Node node = nList2.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;
				// get the content of an attribute in element
				String XMLtemperature = eElement.getAttribute("value");
				//System.out.println("temp " + " is now a " + XMLtemperature);
				wBean.setTemprature(Double.parseDouble(XMLtemperature)) ;
				
			}
		}
		
		for (int temp = 0; temp < nList3.getLength(); temp++) {
			// Save a node of the current list id
			Node node = nList3.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;
				// get the content of an attribute in element
				String XMLdate = eElement.getAttribute("value");
				//System.out.println(wBean.getCityStr() + " is now a " + XMLclouds);
				wBean.setDate(XMLdate);
			}
		}
	}

	// Method the makes a XML doc out of a string, if it is in a XML format.
	private static Document convertStringToXMLDocument(String xmlString) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
