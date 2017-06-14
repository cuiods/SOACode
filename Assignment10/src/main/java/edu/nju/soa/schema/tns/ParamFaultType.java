
package edu.nju.soa.schema.tns;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>ParamFaultType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ParamFaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ParamIndex" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="FaultInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *       &lt;attribute name="ParamName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamFaultType", propOrder = {

})
@NoArgsConstructor
@AllArgsConstructor
public class ParamFaultType {

    @XmlElement(name = "ParamIndex", required = true)
    protected BigInteger paramIndex;
    @XmlElement(name = "FaultInfo", required = true)
    protected String faultInfo;
    @XmlAttribute(name = "ParamName")
    protected String paramName;

    /**
     * 获取paramIndex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParamIndex() {
        return paramIndex;
    }

    /**
     * 设置paramIndex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParamIndex(BigInteger value) {
        this.paramIndex = value;
    }

    /**
     * 获取faultInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultInfo() {
        return faultInfo;
    }

    /**
     * 设置faultInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultInfo(String value) {
        this.faultInfo = value;
    }

    /**
     * 获取paramName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 设置paramName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParamName(String value) {
        this.paramName = value;
    }

}
