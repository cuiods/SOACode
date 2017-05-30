package edu.nju.soa.entity;

import javax.xml.bind.annotation.*;

/**
 * <p>Java class for 地址类型 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="地址类型">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="国家" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="省直辖市" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="区县" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="街道" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="号" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "地址类型", propOrder = {
        "country",
        "province",
        "district",
        "block",
        "number"
})
public class Address {

    @XmlElement(name = "国家",namespace = NameSpace.NJU_URI)
    private String country;

    @XmlElement(name = "省直辖市", namespace = NameSpace.NJU_URI)
    private String province;

    @XmlElement(name = "区县", namespace = NameSpace.NJU_URI)
    private String district;

    @XmlElement(name = "街道", namespace = NameSpace.NJU_URI)
    private String block;

    @XmlElement(name = "号", namespace = NameSpace.NJU_URI)
    private String number;

    public Address() {
    }

    public Address(String country, String province, String district, String block, String number) {
        this.country = country;
        this.province = province;
        this.district = district;
        this.block = block;
        this.number = number;
    }

    /**
     * Gets the value of the country property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param country
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the value of the province property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     *
     * @param province
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the value of the 区县 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the value of the 区县 property.
     *
     * @param district
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Gets the value of the 街道 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBlock() {
        return block;
    }

    /**
     * Sets the value of the 街道 property.
     *
     * @param block
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBlock(String block) {
        this.block = block;
    }

    /**
     * Gets the value of the 号 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the 号 property.
     *
     * @param number
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
