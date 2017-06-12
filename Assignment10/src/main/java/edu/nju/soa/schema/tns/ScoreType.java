
package edu.nju.soa.schema.tns;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>成绩性质类型的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ScoreType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="平时成绩"/>
 *     &lt;enumeration value="作业成绩"/>
 *     &lt;enumeration value="期中成绩"/>
 *     &lt;enumeration value="期末成绩"/>
 *     &lt;enumeration value="总评成绩"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "成绩性质类型")
@XmlEnum
public enum ScoreType {

    平时成绩,
    作业成绩,
    期中成绩,
    期末成绩,
    总评成绩;

    public String value() {
        return name();
    }

    public static ScoreType fromValue(String v) {
        return valueOf(v);
    }

}
