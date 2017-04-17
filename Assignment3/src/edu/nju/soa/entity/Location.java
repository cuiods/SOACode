package edu.nju.soa.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Location entity
 */
public class Location extends Entity{

    private String country;
    private String province;
    private String district;
    private String block;
    private String number;

    public Location(String country, String province, String district, String block, String number) {
        this.country = country;
        this.province = province;
        this.district = district;
        this.block = block;
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public Element parseElement(Document document, String tagName) {
        Element root = document.createElement(tagName);
        Element countryE = document.createElement("国家");
        countryE.setTextContent(province);
        Element provinceE = document.createElement("省直辖市");
        provinceE.setTextContent(province);
        Element districtE = document.createElement("区县");
        districtE.setTextContent(district);
        Element blockE = document.createElement("街道");
        blockE.setTextContent(block);
        Element numberE = document.createElement("号");
        numberE.setTextContent(number);
        root.appendChild(countryE);
        root.appendChild(provinceE);
        root.appendChild(districtE);
        root.appendChild(blockE);
        root.appendChild(numberE);
        return root;
    }
}
