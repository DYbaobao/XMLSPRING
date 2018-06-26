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
		System.out.println("一共有"+nodeList.getLength()+"个学生");
		for (int i = 0; i < nodeList.getLength() ; i++) {
			System.out.println("=================下面开始遍历第" + ( i + 1 ) + "学生的内容=================");
			Node studentList =   nodeList.item(i);
		    NamedNodeMap attrs  =  studentList.getAttributes();
		    System.out.println("===============第"+(i+1)+"个学生共有"+attrs.getLength()+"个属性");
		    for (int j = 0; j < attrs.getLength(); j++) {
				  Node stu =attrs.item(j);
				  System.out.print("属性名 ：" +stu.getNodeName());
				  System.out.println("--属性值 ："+stu.getNodeValue());
				   
			}
		    NodeList childNode = studentList.getChildNodes();
		    System.out.println("第"+(i+1)+"个学生共有"+childNode.getLength()+"个子节点");
		    for (int j = 0; j < childNode.getLength(); j++) {
				if(childNode.item(j).getNodeType()==Node.ELEMENT_NODE){
					System.out.print("第"+(j+1)+"个节点的节点名  :"+childNode.item(j).getNodeName());
					System.out.println("--节点值"+childNode.item(j).getTextContent());
				}
			}
		    
		    System.out.println("=================结束遍历第" + ( i + 1 ) + "学生的内容=================");
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
