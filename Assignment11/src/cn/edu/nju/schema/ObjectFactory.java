
package cn.edu.nju.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.edu.nju.schema package. 
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

    private final static QName _基本信息_QNAME = new QName("http://www.nju.edu.cn/schema", "\u57fa\u672c\u4fe1\u606f");
    private final static QName _部门_QNAME = new QName("http://www.nju.edu.cn/schema", "\u90e8\u95e8");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.edu.nju.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link 个人信息类型 }
     * 
     */
    public 个人信息类型 create个人信息类型() {
        return new 个人信息类型();
    }

    /**
     * Create an instance of {@link 部门类型 }
     * 
     */
    public 部门类型 create部门类型() {
        return new 部门类型();
    }

    /**
     * Create an instance of {@link 个人基本信息类型 }
     * 
     */
    public 个人基本信息类型 create个人基本信息类型() {
        return new 个人基本信息类型();
    }

    /**
     * Create an instance of {@link 地址类型 }
     * 
     */
    public 地址类型 create地址类型() {
        return new 地址类型();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 个人信息类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nju.edu.cn/schema", name = "\u57fa\u672c\u4fe1\u606f")
    public JAXBElement<个人信息类型> create基本信息(个人信息类型 value) {
        return new JAXBElement<个人信息类型>(_基本信息_QNAME, 个人信息类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 部门类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nju.edu.cn/schema", name = "\u90e8\u95e8")
    public JAXBElement<部门类型> create部门(部门类型 value) {
        return new JAXBElement<部门类型>(_部门_QNAME, 部门类型.class, null, value);
    }

}
