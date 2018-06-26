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
      //进行对book.xml的jdom解析
	  //准备工作
	  //1.创建一个SAXBuilder的对象
		SAXBuilder saxBuilder  = new SAXBuilder();
		InputStream in;
		try {
			//2.创建一个输入流,将xml加入到输入流中
			in = new FileInputStream("src/res/books.xml");
			//处理乱码
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			//3.通过saxBuilder的build方法,将输入流加载到saxBuilder中
			Document document = saxBuilder.build(isr);
			//4.通过document对象获取xml文件的根节点
			Element rootElement = document.getRootElement();
			//5.获取根节点下的子节点的list集合
			List<Element> bookList = rootElement.getChildren();
			//6.继续进行解析
			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("=========开始解析第"+(bookList.indexOf(book)+1) +"本书==========");
				//解析book属性集合
				List<Attribute> attrList = book.getAttributes();
				//已知节点的属性名获取属性值
				//book.getAttributeValue("id");
				//遍历attrList集合(不清楚book节点下属性的名字和数量)
				for (Attribute attr : attrList) {
					//获取属性名
					String attrName = attr.getName();
					//获取属性值
					String attrValue =attr.getValue();
					System.out.println("属性名: "+ attrName + "-----属性值 : "+attrValue);
					if (attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				//对book节点的子节点的节点名以及节点值进行遍历
				List<Element> bookChilds = book.getChildren();
				for (Element chiled : bookChilds) {
					System.out.println("节点名 : " + chiled.getName() + "----- : 节点值:" + chiled.getValue());
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
				System.out.println("=========结束解析第"+(bookList.indexOf(book)+1) +"本书==========");
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
