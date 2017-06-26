
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>部门属性类型的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="部门属性类型"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="系"/&gt;
 *     &lt;enumeration value="院"/&gt;
 *     &lt;enumeration value="直属"/&gt;
 *     &lt;enumeration value="行政部门"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "\u90e8\u95e8\u5c5e\u6027\u7c7b\u578b")
@XmlEnum
public enum 部门属性类型 {

    系,
    院,
    直属,
    行政部门;

    public String value() {
        return name();
    }

    public static 部门属性类型 fromValue(String v) {
        return valueOf(v);
    }

}
