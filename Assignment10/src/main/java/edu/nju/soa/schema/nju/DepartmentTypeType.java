
package edu.nju.soa.schema.nju;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>部门性质类型的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="DepartmentTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="系"/>
 *     &lt;enumeration value="院"/>
 *     &lt;enumeration value="直属"/>
 *     &lt;enumeration value="行政"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "\u90e8\u95e8\u6027\u8d28\u7c7b\u578b")
@XmlEnum
public enum DepartmentTypeType {

    系,
    院,
    直属,
    行政;

    public String value() {
        return name();
    }

    public static DepartmentTypeType fromValue(String v) {
        return valueOf(v);
    }

}
