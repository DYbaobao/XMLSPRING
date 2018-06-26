package com.imooc.dom4jtest;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4jStudetTes {

	public static void main(String[] args) {
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(new File("src/res/students.xml"));
			Element students = document.getRootElement();
			Iterator iterator  = students.elementIterator();
			while (iterator.hasNext()) {
				System.out.println("---------开始遍历 某个学生-----------");
				Element student = (Element) iterator.next();
                List<Attribute>  studentList =  student.attributes();
                for (Attribute attr : studentList) {
					System.out.println("属性名  : "+attr.getName() + "----属性值:"+attr.getValue());
				}
                Iterator studentChilds = student.elementIterator();
                while (studentChilds.hasNext()) {
                	Element studentChild = (Element) studentChilds.next();
                	System.out.println("节点属性名: "+studentChild.getName()+ "----节点属性值:"+studentChild.getStringValue());
                }
            	System.out.println("---------结束遍历 某个学生-----------");
			}
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
	}

}
