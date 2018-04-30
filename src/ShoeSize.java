
/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class ShoeSize {
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;

    static final String FILENAME = "shoesize.xml";

    private Integer shoesize;

    public ShoeSize() {
        shoesize = null;
    }

    public String show() {
        return (shoesize == null ? "" : shoesize.toString());
    }

    public boolean set(Integer v) {
        if (v == null || v >= ShoeSize.SHOESIZEMIN && v <= ShoeSize.SHOESIZEMAX) {
            shoesize = v;
            save();
            return true;
        } else {
            shoesize = null;
            return false;
        }
    }

    static ShoeSize load() {
        // add code here that will load shoe size from a file called "FILENAME"
        ShoeSize ss = new ShoeSize();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try{
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("1.xml"));
            Node shorsize = doc.getFirstChild();
            NodeList nl = shorsize.getChildNodes();
            Node n = nl.item(0);
            if(n != null){
                ss.shoesize = Integer.parseInt(n.getTextContent());
            }

        }catch(Exception e){
            System.err.println("Problem loading " + "1.xml");
        }


        return ss;
    }

    void save() {
        // add code here that will save shoe size into a file called "FILENAME"
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try{
            db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element shoe = doc.createElement("SHOE");

            Element size = doc.createElement("SIZE");
            size.appendChild(doc.createTextNode(String.valueOf(shoesize)));
            shoe.appendChild(size);
            doc.appendChild(shoe);
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // set xml encoding to utf-8
            transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("1.xml"));
            transformer.transform(source, result);


        }catch(Exception e){
            System.err.println("Problem saving " + "1.xml");
        }
    }
}