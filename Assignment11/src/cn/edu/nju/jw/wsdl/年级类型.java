
package cn.edu.nju.jw.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>年级类型的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="年级类型"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="大一"/&gt;
 *     &lt;enumeration value="大二"/&gt;
 *     &lt;enumeration value="大三"/&gt;
 *     &lt;enumeration value="大四"/&gt;
 *     &lt;enumeration value="研一"/&gt;
 *     &lt;enumeration value="研二"/&gt;
 *     &lt;enumeration value="研三"/&gt;
 *     &lt;enumeration value="博士在读"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "\u5e74\u7ea7\u7c7b\u578b")
@XmlEnum
public enum 年级类型 {

    大一,
    大二,
    大三,
    大四,
    研一,
    研二,
    研三,
    博士在读;

    public String value() {
        return name();
    }

    public static 年级类型 fromValue(String v) {
        return valueOf(v);
    }

}
