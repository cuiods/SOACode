
package cn.edu.nju.jw.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>成绩类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="成绩类型"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="学号" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="得分" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u6210\u7ee9\u7c7b\u578b", propOrder = {
    "\u5b66\u53f7",
    "\u5f97\u5206"
})
public class 成绩类型 {

    @XmlElement(required = true)
    protected String 学号;
    protected int 得分;

    /**
     * 获取学号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get学号() {
        return 学号;
    }

    /**
     * 设置学号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set学号(String value) {
        this.学号 = value;
    }

    /**
     * 获取得分属性的值。
     * 
     */
    public int get得分() {
        return 得分;
    }

    /**
     * 设置得分属性的值。
     * 
     */
    public void set得分(int value) {
        this.得分 = value;
    }

}
