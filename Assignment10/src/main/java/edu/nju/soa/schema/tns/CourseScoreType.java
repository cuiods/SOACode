
package edu.nju.soa.schema.tns;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CourseScoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CourseScoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sid" type="{http://jw.nju.edu.cn/schema}学号类型"/>
 *         &lt;element name="score" type="{http://jw.nju.edu.cn/schema}得分类型"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "成绩类型", propOrder = {
    "sid",
    "score"
})
@NoArgsConstructor
@AllArgsConstructor
public class CourseScoreType {

    @XmlElement(name = "学号" ,required = true)
    protected String sid;
    @XmlElement(name = "得分")
    protected int score;

    /**
     * 获取学号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSid() {
        return sid;
    }

    /**
     * 设置学号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSid(String value) {
        this.sid = value;
    }

    /**
     * 获取得分属性的值。
     * 
     */
    public int getScore() {
        return score;
    }

    /**
     * 设置得分属性的值。
     * 
     */
    public void setScore(int value) {
        this.score = value;
    }

}
