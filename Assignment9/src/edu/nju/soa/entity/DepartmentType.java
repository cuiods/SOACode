package edu.nju.soa.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for 部门性质类型.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="部门性质类型">
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
public enum  DepartmentType {
    系,
    院,
    直属,
    行政;

    public String value() {
        return name();
    }

    public static DepartmentType fromValue(String v) {
        return valueOf(v);
    }
}
