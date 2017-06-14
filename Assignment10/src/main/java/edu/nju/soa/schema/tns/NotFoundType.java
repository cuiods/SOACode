
package edu.nju.soa.schema.tns;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NotFoundType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NotFoundType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NotFoundReason" type="{http://jw.nju.edu.cn/schema}NotFoundReasonType"/>
 *         &lt;element name="NotFoundId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotFoundType", propOrder = {
    "notFoundReason",
    "notFoundId"
})
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundType {

    @XmlElement(name = "NotFoundReason", required = true)
    protected NotFoundReasonType notFoundReason;
    @XmlElement(name = "NotFoundId", required = true)
    protected String notFoundId;

    /**
     * 获取notFoundReason属性的值。
     *
     * @return
     *     possible object is
     *     {@link NotFoundReasonType }
     *
     */
    public NotFoundReasonType getNotFoundReason() {
        return notFoundReason;
    }

    /**
     * 设置notFoundReason属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link NotFoundReasonType }
     *
     */
    public void setNotFoundReason(NotFoundReasonType value) {
        this.notFoundReason = value;
    }

    /**
     * 获取notFoundId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotFoundId() {
        return notFoundId;
    }

    /**
     * 设置notFoundId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotFoundId(String value) {
        this.notFoundId = value;
    }

}
