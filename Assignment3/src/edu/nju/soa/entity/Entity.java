package edu.nju.soa.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Base entity class
 */
abstract class Entity {
    public abstract Element parseElement(Document document, String tagName);
}
