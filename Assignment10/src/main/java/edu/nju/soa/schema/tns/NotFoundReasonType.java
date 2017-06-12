
package edu.nju.soa.schema.tns;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NotFoundReasonType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="NotFoundReasonType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="学号不存在"/>
 *     &lt;enumeration value="未找到输入学号的成绩"/>
 *     &lt;enumeration value="课程不存在"/>
 *     &lt;enumeration value="未找到输入课程的成绩"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NotFoundReasonType")
@XmlEnum
public enum NotFoundReasonType {

    学号不存在,
    未找到输入学号的成绩,
    课程不存在,
    未找到输入课程的成绩;

    public String value() {
        return name();
    }

    public static NotFoundReasonType fromValue(String v) {
        return valueOf(v);
    }

}
