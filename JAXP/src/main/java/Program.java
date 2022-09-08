import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.xpath.*;
import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException,  XPathExpressionException {
           XPathFactory xPathFactory =XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression xPathExpression = xPath.compile("//book[translate(publish_date,'-','')>=20050101 and price>=10]/* |" +
                    " //book[translate(publish_date,'-','')>=20050101 and price>=10]/@* ");
            File file = new File("src/main/java/books.xml");
            InputSource inputSource = new InputSource(new FileInputStream(file));
            Object oxPath = xPathExpression.evaluate(inputSource, XPathConstants.NODESET);
            NodeList nodeList = (NodeList) oxPath;
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeName()+ ": " + nodeList.item(i).getFirstChild().getNodeValue());
        }
    }
}