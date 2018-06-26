package com.imooc.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.imooc.handler.SAXPerserHandlerDemo;

public class SAXStudentsTest {

	public static void main(String[] args) {
		SAXParserFactory factory =	SAXParserFactory.newInstance();
           try {
			SAXParser saxParser = factory.newSAXParser();
			SAXPerserHandlerDemo   saxPerserHandlerDemo = new SAXPerserHandlerDemo();
	        saxParser.parse("students.xml", saxPerserHandlerDemo);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
