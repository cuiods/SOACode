package edu.nju.soa.entity;

import edu.nju.soa.enums.DepartmentType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Department entity
 */
public class Department extends Entity {
    private String id;
    private String name;
    private DepartmentType type;
    private String description;
    private Location location;

    public Department(String did, String name, DepartmentType type, String description, Location location) {
        if (did.length()!=6 || name.length()>12) throw new IllegalArgumentException();
        this.id = did;
        this.name = name;
        this.type = type;
        this.description = description;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentType getType() {
        return type;
    }

    public void setType(DepartmentType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public Element parseElement(Document document, String tagName) {
        Element root = document.createElement(tagName);
        root.setAttribute("部门编号",id);
        root.setAttribute("部门名称",name);
        Element dtype = document.createElement("部门性质");
        dtype.setTextContent(type.toString());
        Element ddes = document.createElement("部门介绍");
        ddes.setTextContent(description);
        Element dlocation = location.parseElement(document,"部门地址");
        root.appendChild(dtype);
        root.appendChild(ddes);
        root.appendChild(dlocation);
        return root;
    }
}
