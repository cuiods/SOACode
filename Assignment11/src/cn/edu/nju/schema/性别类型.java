
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>性别类型的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="性别类型"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="男"/&gt;
 *     &lt;enumeration value="女"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "\u6027\u522b\u7c7b\u578b")
@XmlEnum
public enum 性别类型 {

    男,
    女;

    public String value() {
        return name();
    }

    public static 性别类型 fromValue(String v) {
        return valueOf(v);
    }

}
