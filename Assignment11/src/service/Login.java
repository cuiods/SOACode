
package service;

import javax.xml.bind.annotation.*;


/**
 * <p>login complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="login"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://mail/login}LoginUsername" minOccurs="0"/&gt;
 *         &lt;element ref="{http://mail/login}LoginPassword" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "login", propOrder = {
    "loginUsername",
    "loginPassword"
})
public class Login {

    @XmlElement(name = "LoginUsername", namespace = "http://mail/login")
    protected String loginUsername;
    @XmlElement(name = "LoginPassword", namespace = "http://mail/login")
    protected String loginPassword;

    /**
     * 获取loginUsername属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginUsername() {
        return loginUsername;
    }

    /**
     * 设置loginUsername属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginUsername(String value) {
        this.loginUsername = value;
    }

    /**
     * 获取loginPassword属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置loginPassword属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginPassword(String value) {
        this.loginPassword = value;
    }

}
