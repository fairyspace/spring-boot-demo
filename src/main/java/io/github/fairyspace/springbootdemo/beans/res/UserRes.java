package io.github.fairyspace.springbootdemo.beans.res;

import io.github.fairyspace.springbootdemo.beans.common.AdapterCDATA;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRes {
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    String name;
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    String email;
}
