
package mail.login;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import service.LoginInfo;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mail.login package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginPassword_QNAME = new QName("http://mail/login", "LoginPassword");
    private final static QName _LoginResults_QNAME = new QName("http://mail/login", "LoginResults");
    private final static QName _LoginUsername_QNAME = new QName("http://mail/login", "LoginUsername");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mail.login
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mail/login", name = "LoginPassword")
    public JAXBElement<String> createLoginPassword(String value) {
        return new JAXBElement<String>(_LoginPassword_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mail/login", name = "LoginResults")
    public JAXBElement<LoginInfo> createLoginResults(LoginInfo value) {
        return new JAXBElement<LoginInfo>(_LoginResults_QNAME, LoginInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mail/login", name = "LoginUsername")
    public JAXBElement<String> createLoginUsername(String value) {
        return new JAXBElement<String>(_LoginUsername_QNAME, String.class, null, value);
    }

}
