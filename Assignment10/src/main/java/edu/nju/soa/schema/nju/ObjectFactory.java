
package edu.nju.soa.schema.nju;

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

    private final static QName _部门_QNAME = new QName("http://www.nju.edu.cn/schema", "\u90e8\u95e8");
    private final static QName _个人信息_QNAME = new QName("http://www.nju.edu.cn/schema", "\u4e2a\u4eba\u4fe1\u606f");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.edu.nju.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DepartmentType }
     *
     */
    public DepartmentType create部门类型() {
        return new DepartmentType();
    }

    /**
     * Create an instance of {@link PersonInfoType }
     *
     */
    public PersonInfoType create个人信息类型() {
        return new PersonInfoType();
    }

    /**
     * Create an instance of {@link AddressType }
     *
     */
    public AddressType create地址类型() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepartmentType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.nju.edu.cn/schema", name = "\u90e8\u95e8")
    public JAXBElement<DepartmentType> create部门(DepartmentType value) {
        return new JAXBElement<DepartmentType>(_部门_QNAME, DepartmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonInfoType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.nju.edu.cn/schema", name = "\u4e2a\u4eba\u4fe1\u606f")
    public JAXBElement<PersonInfoType> create个人信息(PersonInfoType value) {
        return new JAXBElement<PersonInfoType>(_个人信息_QNAME, PersonInfoType.class, null, value);
    }

}
