
package service;

import javax.xml.bind.annotation.*;


/**
 * <p>loginResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="loginResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://mail/login}LoginResults" minOccurs="0"/&gt;
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
@XmlType(name = "loginResponse", propOrder = {
    "loginResults"
})
public class LoginResponse {

    @XmlElement(name = "LoginResults", namespace = "http://mail/login")
    protected LoginInfo loginResults;

    /**
     * 获取loginResults属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LoginInfo }
     *     
     */
    public LoginInfo getLoginResults() {
        return loginResults;
    }

    /**
     * 设置loginResults属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LoginInfo }
     *     
     */
    public void setLoginResults(LoginInfo value) {
        this.loginResults = value;
    }

}
