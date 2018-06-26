package com.imooc.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXPerserHandlerDemo extends DefaultHandler {
	String value = null;
    @Override
    public void startElement(String uri, String localName, String qName,
    		Attributes attributes) throws SAXException {
    	
    	super.startElement(uri, localName, qName, attributes);
    
    	if (qName.equals("student")) {
    		
    		 int num = attributes.getLength();
    		 for (int i = 0; i < num; i++) {
				System.out.print("studentԪ�ص�������"+attributes.getQName(i));
				System.out.println("--����ֵ:"+attributes.getValue(i));
			 } 
    	} else if (!qName.equals("students") && !qName.equals("student")) {
    		 System.out.print("�ڵ�������" +qName+"-------");
    	}
    }
    
    @Override
    public void characters(char[] ch, int start, int length)
    		throws SAXException {
    	// TODO Auto-generated method stub
    	super.characters(ch, start, length);
    	value = new String(ch, start, length);
    	if (!value.trim().equals("")) {
    		System.out.println("����ֵ ��"+value);
    	}
    }
    @Override
    public void endElement(String uri, String localName, String qName)
    		throws SAXException {
    
    	super.endElement(uri, localName, qName);
    	
    }
    
    @Override
    public void startDocument() throws SAXException {
    
    	super.startDocument();
    }
    
    @Override
    public void endDocument() throws SAXException {
    
    	super.endDocument();
    }
}
