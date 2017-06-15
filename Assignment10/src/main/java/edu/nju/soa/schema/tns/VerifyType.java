
package edu.nju.soa.schema.tns;

import edu.nju.soa.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>VerifyType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="VerifyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sid" type="{http://jw.nju.edu.cn/schema}学号类型"/>
 *         &lt;element name="authType" type="{http://jw.nju.edu.cn/schema}AuthType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "\u9a8c\u8bc1\u7c7b\u578b", propOrder = {
    "sid",
    "authType"
})
@NoArgsConstructor
@AllArgsConstructor
public class VerifyType {

    @XmlElement(name = "学号",required = true)
    protected String sid;
    @XmlElement(name = "权限",required = true)
    protected AuthType authType;

    public VerifyType(UserEntity userEntity) {
        if (userEntity == null) return;
        BeanUtils.copyProperties(userEntity,this);
        sid = userEntity.getEmail();
    }

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
     * 获取权限属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AuthType }
     *     
     */
    public AuthType getAuthType() {
        return authType;
    }

    /**
     * 设置权限属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AuthType }
     *     
     */
    public void setAuthType(AuthType value) {
        this.authType = value;
    }

}
