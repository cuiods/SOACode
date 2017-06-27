
package cn.edu.nju.jw.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>课程成绩列表类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="课程成绩列表类型"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="课程成绩" type="{http://jw.nju.edu.cn/wsdl}课程成绩类型" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u8bfe\u7a0b\u6210\u7ee9\u5217\u8868\u7c7b\u578b", propOrder = {
    "\u8bfe\u7a0b\u6210\u7ee9"
})
public class 课程成绩列表类型 {

    @XmlElement(nillable = true)
    protected List<课程成绩类型> 课程成绩;

    /**
     * Gets the value of the 课程成绩 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the 课程成绩 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get课程成绩().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link 课程成绩类型 }
     * 
     * 
     */
    public List<课程成绩类型> get课程成绩() {
        if (课程成绩 == null) {
            课程成绩 = new ArrayList<课程成绩类型>();
        }
        return this.课程成绩;
    }

    public void set课程成绩(List<课程成绩类型> 课程成绩) {
        this.课程成绩 = 课程成绩;
    }
}
