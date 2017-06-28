
package cn.edu.nju.jw.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import cn.edu.nju.jw.wsdl.学号课程号类型;
import cn.edu.nju.jw.wsdl.学生信息;
import cn.edu.nju.jw.wsdl.排序方式类型;
import cn.edu.nju.jw.wsdl.课程信息;
import cn.edu.nju.jw.wsdl.课程成绩列表类型;
import cn.edu.nju.jw.wsdl.课程成绩类型;
import cn.edu.nju.schema.学号类型;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.edu.nju.jw.schema package. 
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

    private final static QName _分数错误_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5206\u6570\u9519\u8bef");
    private final static QName _学号_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u53f7");
    private final static QName _学号课程号_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u53f7\u8bfe\u7a0b\u53f7");
    private final static QName _学号错误_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u53f7\u9519\u8bef");
    private final static QName _学生_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u751f");
    private final static QName _排序方式_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u6392\u5e8f\u65b9\u5f0f");
    private final static QName _课程_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b");
    private final static QName _课程成绩_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u6210\u7ee9");
    private final static QName _课程成绩列表_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868");
    private final static QName _课程编号_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u7f16\u53f7");
    private final static QName _课程编号错误_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u8bfe\u7a0b\u7f16\u53f7\u9519\u8bef");
    private final static QName _数据格式错误_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u6570\u636e\u683c\u5f0f\u9519\u8bef");
    private final static QName _学号类型_QNAME = new QName("http://jw.nju.edu.cn/schema", "\u5b66\u53f7\u7c7b\u578b");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.edu.nju.jw.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5206\u6570\u9519\u8bef")
    public JAXBElement<String> create分数错误(String value) {
        return new JAXBElement<String>(_分数错误_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u53f7")
    public JAXBElement<String> create学号(String value) {
        return new JAXBElement<String>(_学号_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 学号课程号类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u53f7\u8bfe\u7a0b\u53f7")
    public JAXBElement<学号课程号类型> create学号课程号(学号课程号类型 value) {
        return new JAXBElement<学号课程号类型>(_学号课程号_QNAME, 学号课程号类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u53f7\u9519\u8bef")
    public JAXBElement<String> create学号错误(String value) {
        return new JAXBElement<String>(_学号错误_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 学生信息 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u751f")
    public JAXBElement<学生信息> create学生(学生信息 value) {
        return new JAXBElement<学生信息>(_学生_QNAME, 学生信息.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 排序方式类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u6392\u5e8f\u65b9\u5f0f")
    public JAXBElement<排序方式类型> create排序方式(排序方式类型 value) {
        return new JAXBElement<排序方式类型>(_排序方式_QNAME, 排序方式类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 课程信息 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b")
    public JAXBElement<课程信息> create课程(课程信息 value) {
        return new JAXBElement<课程信息>(_课程_QNAME, 课程信息.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 课程成绩类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u6210\u7ee9")
    public JAXBElement<课程成绩类型> create课程成绩(课程成绩类型 value) {
        return new JAXBElement<课程成绩类型>(_课程成绩_QNAME, 课程成绩类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 课程成绩列表类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868")
    public JAXBElement<课程成绩列表类型> create课程成绩列表(课程成绩列表类型 value) {
        return new JAXBElement<课程成绩列表类型>(_课程成绩列表_QNAME, 课程成绩列表类型.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u7f16\u53f7")
    public JAXBElement<String> create课程编号(String value) {
        return new JAXBElement<String>(_课程编号_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u8bfe\u7a0b\u7f16\u53f7\u9519\u8bef")
    public JAXBElement<String> create课程编号错误(String value) {
        return new JAXBElement<String>(_课程编号错误_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u6570\u636e\u683c\u5f0f\u9519\u8bef")
    public JAXBElement<String> create数据格式错误(String value) {
        return new JAXBElement<String>(_数据格式错误_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link 学号类型 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema", name = "\u5b66\u53f7\u7c7b\u578b")
    public JAXBElement<学号类型> create学号类型(学号类型 value) {
        return new JAXBElement<学号类型>(_学号类型_QNAME, 学号类型.class, null, value);
    }

}
