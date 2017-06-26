
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>教育类型的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="教育类型"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="专科"/&gt;
 *     &lt;enumeration value="本科"/&gt;
 *     &lt;enumeration value="硕士"/&gt;
 *     &lt;enumeration value="博士"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "\u6559\u80b2\u7c7b\u578b")
@XmlEnum
public enum 教育类型 {

    专科,
    本科,
    硕士,
    博士;

    public String value() {
        return name();
    }

    public static 教育类型 fromValue(String v) {
        return valueOf(v);
    }

}
