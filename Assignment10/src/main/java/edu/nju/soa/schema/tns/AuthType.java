
package edu.nju.soa.schema.tns;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>权限级别的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="AuthType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="老师"/>
 *     &lt;enumeration value="研究生"/>
 *     &lt;enumeration value="本科生"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "权限级别")
@XmlEnum
public enum AuthType {

    老师,
    研究生,
    本科生;

    public String value() {
        return name();
    }

    public static AuthType fromValue(String v) {
        return valueOf(v);
    }

}
