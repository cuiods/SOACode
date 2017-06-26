
package cn.edu.nju.jw.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>排序方式类型的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="排序方式类型"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="从高到低"/&gt;
 *     &lt;enumeration value="从低到高"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "\u6392\u5e8f\u65b9\u5f0f\u7c7b\u578b")
@XmlEnum
public enum 排序方式类型 {

    从高到低,
    从低到高;

    public String value() {
        return name();
    }

    public static 排序方式类型 fromValue(String v) {
        return valueOf(v);
    }

}
