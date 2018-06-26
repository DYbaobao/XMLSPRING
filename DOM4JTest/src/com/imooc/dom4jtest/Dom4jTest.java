package com.imooc.dom4jtest;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	    //����book.xml
		//����SAXReader�Ķ���Reader
		SAXReader reader = new SAXReader();	
		try {
			//ͨ��reader�����read��������books.xml
			Document document = reader.read(new File("src/res/books.xml"));
			//ͨ��document�����ȡ���ڵ�bookstore
			Element bookstore = document.getRootElement();
			//ͨ��element�����elementIterator()�ķ������������
			@SuppressWarnings("rawtypes")
			Iterator iterator =bookstore.elementIterator();
			//������������ȡ���ڵ��е�������Ϣ
			while (iterator.hasNext()) {
				System.out.println("===========��ʼ����ĳһ����=============");
				Element book = (Element) iterator.next();
				//��ȡbook��������������ֵ
				List<Attribute> bookAttrs =  book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("������: "+ attr.getName()+"----����ֵ: "+attr.getValue());
				}
				 Iterator itter= book.elementIterator();
				 while (itter.hasNext()) {
					  Element bookChild =   (Element) itter.next();
                      System.out.println("�ڵ��� :" +bookChild.getName() +"---�ڵ�ֵ:"+bookChild.getStringValue());	 
				}
				 System.out.println("===========��������ĳһ����=============");
			}
			
		} catch (DocumentException e) {
		
			e.printStackTrace();
		}

	}

}
