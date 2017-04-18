package edu.nju.soa.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * person info entity
 */
public class PersonInfo extends Entity {
    private String name;
    private Department department;
    private Location location;
    private String description;

    public PersonInfo(String name, Department department, Location location, String description) {
        if (name.length()>12) throw new IllegalArgumentException();
        this.name = name;
        this.department = department;
        this.location = location;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Element parseElement(Document document, String tagName) {
        Element root = document.createElement(tagName);
        root.setAttribute("xmlns","http://www.nju.edu.cn/schema");
        Element nameE = document.createElement("个人姓名");
        nameE.setTextContent(name);
        Element departmentE = department.parseElement(document,"所在部门");
        Element locationE = location.parseElement(document,"家庭住址");
        Element descriptionE = document.createElement("个人简介");
        descriptionE.setTextContent(description);
        root.appendChild(nameE);
        root.appendChild(departmentE);
        root.appendChild(locationE);
        root.appendChild(descriptionE);
        return root;
    }
}
