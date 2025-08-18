package com.implementations;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Login_Implementation {

	public String Login(String FilePath, String Credential){
		String CredentialValue="";
		try {
			String filepath = FilePath;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the staff element by tag name directly
			Node CredentialVariables = doc.getElementsByTagName("Credentials").item(0);

			// loop the staff child node
			NodeList list = CredentialVariables.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {
                   Node node = list.item(i);
	             if (Credential!=null && Credential.length()!=0 && "QAADMIN".equals(node.getNodeName())) {
	            	CredentialValue=node.getTextContent();
	            	//System.out.println("The XML value:"+node.getTextContent() );
				   }
				}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CredentialValue;
}}
