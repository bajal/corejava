
/**
 * Created by Bajal on 4/18/16.
 */

import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Bajal on 4/18/16.
 */
public class SaajTester {
    public static void main(String args[]) throws Exception {
        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        // Send SOAP Message to SOAP Server

        String url = " <Give URL Here>";
        String xml=  " <Give XML Here >";

        SOAPMessage soapResponse = soapConnection.call(getSoapMessageFromString(xml), url);
        // print SOAP Response
        System.out.print("Response SOAP Message:");
        soapResponse.writeTo(System.out);
        soapConnection.close();
    }

    private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();

        MimeHeaders m = new MimeHeaders();
        m.addHeader("X-CIS-SYSTEMID","BAJAL");

        SOAPMessage message = factory.createMessage( m , new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        return message;
    }


}
