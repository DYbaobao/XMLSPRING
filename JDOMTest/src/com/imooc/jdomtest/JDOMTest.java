package com.imooc.jdomtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.imooc.entity.Book;

public class JDOMTest {
    private static ArrayList<Book> booksList = new ArrayList<Book>();
	public static void main(String[] args) {
      //���ж�book.xml��jdom����
	  //׼������
	  //1.����һ��SAXBuilder�Ķ���
		SAXBuilder saxBuilder  = new SAXBuilder();
		InputStream in;
		try {
			//2.����һ��������,��xml���뵽��������
			in = new FileInputStream("src/res/books.xml");
			//��������
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			//3.ͨ��saxBuilder��build����,�����������ص�saxBuilder��
			Document document = saxBuilder.build(isr);
			//4.ͨ��document�����ȡxml�ļ��ĸ��ڵ�
			Element rootElement = document.getRootElement();
			//5.��ȡ���ڵ��µ��ӽڵ��list����
			List<Element> bookList = rootElement.getChildren();
			//6.�������н���
			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("=========��ʼ������"+(bookList.indexOf(book)+1) +"����==========");
				//����book���Լ���
				List<Attribute> attrList = book.getAttributes();
				//��֪�ڵ����������ȡ����ֵ
				//book.getAttributeValue("id");
				//����attrList����(�����book�ڵ������Ե����ֺ�����)
				for (Attribute attr : attrList) {
					//��ȡ������
					String attrName = attr.getName();
					//��ȡ����ֵ
					String attrValue =attr.getValue();
					System.out.println("������: "+ attrName + "-----����ֵ : "+attrValue);
					if (attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				//��book�ڵ���ӽڵ�Ľڵ����Լ��ڵ�ֵ���б���
				List<Element> bookChilds = book.getChildren();
				for (Element chiled : bookChilds) {
					System.out.println("�ڵ��� : " + chiled.getName() + "----- : �ڵ�ֵ:" + chiled.getValue());
					if (chiled.getName().equals("name")) {
						bookEntity.setName(chiled.getValue());
					} else if (chiled.getName().equals("author")) {
						bookEntity.setAuthor(chiled.getValue());
					} else if (chiled.getName().equals("price")) {
						bookEntity.setPrice(chiled.getValue());
					} else if (chiled.getName().equals("year")) {
						bookEntity.setYear(chiled.getValue());
					} else if (chiled.getName().equals("language")) {
						bookEntity.setLanguage(chiled.getValue());
					}
				}
				System.out.println("=========����������"+(bookList.indexOf(book)+1) +"����==========");
				booksList.add(bookEntity);
				bookEntity = null;
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (JDOMException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

}
