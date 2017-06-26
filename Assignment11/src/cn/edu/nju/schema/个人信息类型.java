
package cn.edu.nju.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>个人信息类型 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="个人信息类型"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.nju.edu.cn/schema}个人基本信息类型"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="座机号码" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u4e2a\u4eba\u4fe1\u606f\u7c7b\u578b", propOrder = {
    "\u5ea7\u673a\u53f7\u7801"
})
public class 个人信息类型
    extends 个人基本信息类型
{

    protected String 座机号码;

    /**
     * 获取座机号码属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get座机号码() {
        return 座机号码;
    }

    /**
     * 设置座机号码属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set座机号码(String value) {
        this.座机号码 = value;
    }

}
