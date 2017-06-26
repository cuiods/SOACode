
package cn.edu.nju.jw.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>课程成绩类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="课程成绩类型"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="成绩" type="{http://jw.nju.edu.cn/wsdl}成绩类型" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="课程编号" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="成绩性质" type="{http://jw.nju.edu.cn/wsdl}成绩性质类型" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u8bfe\u7a0b\u6210\u7ee9\u7c7b\u578b", propOrder = {
    "\u6210\u7ee9"
})
public class 课程成绩类型 {

    @XmlElement(nillable = true)
    protected List<成绩类型> 成绩;
    @XmlAttribute
    protected String 课程编号;
    @XmlAttribute
    protected 成绩性质类型 成绩性质;

    /**
     * Gets the value of the 成绩 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the 成绩 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get成绩().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link 成绩类型 }
     * 
     * 
     */
    public List<成绩类型> get成绩() {
        if (成绩 == null) {
            成绩 = new ArrayList<成绩类型>();
        }
        return this.成绩;
    }

    /**
     * 获取课程编号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get课程编号() {
        return 课程编号;
    }

    /**
     * 设置课程编号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set课程编号(String value) {
        this.课程编号 = value;
    }

    /**
     * 获取成绩性质属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 成绩性质类型 }
     *     
     */
    public 成绩性质类型 get成绩性质() {
        return 成绩性质;
    }

    /**
     * 设置成绩性质属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 成绩性质类型 }
     *     
     */
    public void set成绩性质(成绩性质类型 value) {
        this.成绩性质 = value;
    }

}
