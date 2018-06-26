package com.imooc.domtest;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomStudentTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	  DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	  try {
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document =documentBuilder.parse("students.xml");
		NodeList nodeList = document.getElementsByTagName("student"); 
		System.out.println("һ����"+nodeList.getLength()+"��ѧ��");
		for (int i = 0; i < nodeList.getLength() ; i++) {
			System.out.println("=================���濪ʼ������" + ( i + 1 ) + "ѧ��������=================");
			Node studentList =   nodeList.item(i);
		    NamedNodeMap attrs  =  studentList.getAttributes();
		    System.out.println("===============��"+(i+1)+"��ѧ������"+attrs.getLength()+"������");
		    for (int j = 0; j < attrs.getLength(); j++) {
				  Node stu =attrs.item(j);
				  System.out.print("������ ��" +stu.getNodeName());
				  System.out.println("--����ֵ ��"+stu.getNodeValue());
				   
			}
		    NodeList childNode = studentList.getChildNodes();
		    System.out.println("��"+(i+1)+"��ѧ������"+childNode.getLength()+"���ӽڵ�");
		    for (int j = 0; j < childNode.getLength(); j++) {
				if(childNode.item(j).getNodeType()==Node.ELEMENT_NODE){
					System.out.print("��"+(j+1)+"���ڵ�Ľڵ���  :"+childNode.item(j).getNodeName());
					System.out.println("--�ڵ�ֵ"+childNode.item(j).getTextContent());
				}
			}
		    
		    System.out.println("=================����������" + ( i + 1 ) + "ѧ��������=================");
		}
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SAXException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

}
