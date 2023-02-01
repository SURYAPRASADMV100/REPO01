package webdriver;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import jakarta.activation.DataContentHandler;

public class ReadDataFromPDF {

	public static void main(String[] args) throws IOException, SAXException, TikaException {
    
		BodyContentHandler contain=new BodyContentHandler();
		FileInputStream fis=new FileInputStream("C:\\Users\\welcome\\Downloads\\surya-assignment04.pdf");
		Metadata meta=new Metadata();
		ParseContext parse=new ParseContext();
	org.apache.tika.parser.pdf.PDFParser pdf=new org.apache.tika.parser.pdf.PDFParser();
	pdf.parse(fis, contain, meta);
	
	System.out.println(contain.toString());	
	}
}