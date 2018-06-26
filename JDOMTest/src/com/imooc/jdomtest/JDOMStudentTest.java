package com.imooc.jdomtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDOMStudentTest {

	public static void main(String[] args) {
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream in;
		try {
			in = new FileInputStream("src/res/students.xml");
			Document document = saxBuilder.build(in);
			Element rootElement = document.getRootElement();
			List<Element> studentList = rootElement.getChildren();
			for (Element student : studentList) {
				System.out.println("��ʼ������"+(studentList.indexOf(student)+1)+"��ѧ��");
				List<Attribute> attrs = student.getAttributes();
				for (Attribute attr : attrs) {
					System.out.println("������ �� "+attr.getName()+ "-----����ֵ ��"+attr.getValue());
				}
				List<Element> studentChilds = student.getChildren();
				for (Element studentChild : studentChilds) {
					System.out.println("�ڵ��� ��"+studentChild.getName()+"------�ڵ�ֵ:" +studentChild.getValue());
				}
				System.out.println("����������"+(studentList.indexOf(student)+1)+"��ѧ��");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
