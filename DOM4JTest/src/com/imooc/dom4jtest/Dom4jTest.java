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
	    //解析book.xml
		//创建SAXReader的对象Reader
		SAXReader reader = new SAXReader();	
		try {
			//通过reader对象的read方法加载books.xml
			Document document = reader.read(new File("src/res/books.xml"));
			//通过document对象获取根节点bookstore
			Element bookstore = document.getRootElement();
			//通过element对象的elementIterator()的方法或许迭代器
			@SuppressWarnings("rawtypes")
			Iterator iterator =bookstore.elementIterator();
			//遍历迭代器获取根节点中的数据信息
			while (iterator.hasNext()) {
				System.out.println("===========开始遍历某一本书=============");
				Element book = (Element) iterator.next();
				//获取book的属性名和属性值
				List<Attribute> bookAttrs =  book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("属性名: "+ attr.getName()+"----属性值: "+attr.getValue());
				}
				 Iterator itter= book.elementIterator();
				 while (itter.hasNext()) {
					  Element bookChild =   (Element) itter.next();
                      System.out.println("节点名 :" +bookChild.getName() +"---节点值:"+bookChild.getStringValue());	 
				}
				 System.out.println("===========结束遍历某一本书=============");
			}
			
		} catch (DocumentException e) {
		
			e.printStackTrace();
		}

	}

}
