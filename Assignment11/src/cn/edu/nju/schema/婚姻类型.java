
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>婚姻类型的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="婚姻类型"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="未婚"/&gt;
 *     &lt;enumeration value="已婚"/&gt;
 *     &lt;enumeration value="离异"/&gt;
 *     &lt;enumeration value="丧偶"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "\u5a5a\u59fb\u7c7b\u578b")
@XmlEnum
public enum 婚姻类型 {

    未婚,
    已婚,
    离异,
    丧偶;

    public String value() {
        return name();
    }

    public static 婚姻类型 fromValue(String v) {
        return valueOf(v);
    }

}
