package edu.pku.sa.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.pku.sa.ins.Instance;

/**
 * 
 * @author intfloat@pku.edu.cn, stormier@126.com
 *
 */
public class XMLUtils {
	
	private static DocumentBuilderFactory dbf;
    private static DocumentBuilder db;
    private static Document doc;
    private static Element root;

    /**
     * 
     * @param file
     * @return list of movies
     */
	public static List<Movie> readMovieXML(File file) {
		if (!file.exists()) return null;
        readXMLAux(file);
        NodeList nodeList = root.getElementsByTagName("movie");
        ArrayList<Movie> result = new ArrayList<Movie>();        
        for (int i = 0; i < nodeList.getLength(); ++i) {
        	Element element = (Element) nodeList.item(i);
        	Element id = (Element) element.getElementsByTagName("id").item(0);
        	long movieId = Long.parseLong(id.getTextContent());
        	Element name = (Element) element.getElementsByTagName("name").item(0);
        	String movieName = name.getTextContent();
        	Element dir = (Element) element.getElementsByTagName("director").item(0);
        	String director = dir.getTextContent();
        	Element rating = (Element) element.getElementsByTagName("rating").item(0);
        	double movieRating = Double.parseDouble(rating.getTextContent());
        	result.add(new Movie(movieId, movieName, director, movieRating));
        }
        return result;
    } // end method readMovieXML
	
	/**
	 * 
	 * @param file
	 * @return list of instance
	 */
	public static List<Instance> readCommentXML(File file) {
		if (!file.exists()) return null;
		readXMLAux(file);
		NodeList nodeList = root.getElementsByTagName("comment");
		ArrayList<Instance> result = new ArrayList<Instance>();
		for (int i = 0; i < nodeList.getLength(); ++i) {
			Instance ins = new Instance();
			Element element = (Element) nodeList.item(i);
			Element t = (Element) element.getElementsByTagName("movie_id").item(0);
//			movie ID
			ins.setMovieId(Long.parseLong(t.getTextContent()));
//			comment ID
			ins.setCommentId(Long.parseLong(element.getAttribute("id")));
			t = (Element) element.getElementsByTagName("rating").item(0);
//			rating
			if (t != null)
			    ins.setRating(Double.parseDouble(t.getTextContent()));
			else
				ins.setRating(0.0);
			t = (Element) element.getElementsByTagName("content").item(0);
//			text
			ins.setText(t.getTextContent().trim());
			result.add(ins);
		} // end for loop
		return result;
	} // end readCommentXML method
	
	
    private static void readXMLAux(File file) {
        dbf = DocumentBuilderFactory.newInstance();
        db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        }
        doc = null;
        try {
            doc = db.parse(file);
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();            
        }
        root = doc.getDocumentElement();  
    }  // End method readXML()
    
} // end class XMLUtils
