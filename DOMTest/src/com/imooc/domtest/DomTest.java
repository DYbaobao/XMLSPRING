package com.imooc.domtest;

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

public class DomTest {

	public static void main(String[] args) {
		//����DocumentBuilderFactory����
		DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
	
		try {
			//����DocumentBuilder����
			DocumentBuilder db= dbf.newDocumentBuilder();
			//ͨ��DocumentBuilder�����parse��������books.xml�ļ�����Ŀ��
			Document document=  db.parse("books.xml");
			//��ȡ����book�ڵ�ļ���
			NodeList booklist =document.getElementsByTagName("book");
			//ͨ��nodelist��getLength()�ķ������Ի�ȡbooklist�ĳ���
			System.out.println("һ����"+booklist.getLength()+"����");
			//����ÿһ��book�ڵ�
			for (int i = 0; i < booklist.getLength(); i++) {
				System.out.println("=================���濪ʼ������" + ( i + 1 ) + "���������=================");
				//ͨ��item(i)������ȡһ��book�ڵ�,nodelist�������Ǵ�0��ʼ��
				  //(δ֪���Ը���)
				 Node book =booklist.item(i);
				//��ȡbook�ڵ��������Եļ���
				NamedNodeMap attrs =book.getAttributes();
				System.out.println("��" + (i + 1) + "���鹲��" + attrs.getLength()+ "������");
				//����book������
				for (int j = 0; j < attrs.getLength(); j++) {
					//ͨ��item(index)��ȡbook�ڵ��ĳһ������,index��0��ʼ
					Node attr = attrs.item(j);
					//��ȡ������
				    System.out.print("������: "+  attr.getNodeName());
					//��ȡ����ֵ
				    System.out.println("---����ֵ: "+  attr.getNodeValue());
				}
				
				/**
				 * ��֪���Ը���
				 * ǰ�᣺�Ѿ�֪��book�ڵ�����ֻ����һ��id����
				 * ��book�ڵ����ǿ������ת����ת����Element
				 */
			        /*  Element book  = (Element) booklist.item(i);
			          //ͨ��getAttribute("id")������ȡ����ֵ
			          String attrValue = book.getAttribute("id");
			  
			          System.out.println("id���Ե�����ֵΪ:"+attrValue);*/
				//����book�ڵ���ӽڵ�
				    NodeList childNodes =  book.getChildNodes();
				    //����childNodes ��ȡÿ���ڵ�Ľڵ����ͽڵ�ֵ
				    System.out.println("��" + (i+1)+"���鹲��"+childNodes.getLength()+"���ӽڵ�");
				    for (int k = 0; k < childNodes.getLength(); k++) {
				    	//����text���͵�node�Լ�element���͵�node�ڵ�
				    	if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
				    		//��ȡ��element���ͽڵ�Ľڵ���
				    		System.out.print("��"+(k+1)+"���ڵ�Ľڵ��� : "
				    				+childNodes.item(k).getNodeName());
				    		//��ȡ��element���ͽڵ�Ľڵ�ֵ
				    		//System.out.println("  ---�ڵ�ֵ  :"+childNodes.item(k).getFirstChild().getNodeValue());
				    		System.out.println("  ---�ڵ�ֵ  :"+childNodes.item(k).getTextContent());
				    	}
						
					}
				System.out.println("=================����������" + ( i + 1 ) + "���������=================");
			
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
