package io.github.fairyspace.springbootdemo.beans.req;

import io.github.fairyspace.springbootdemo.beans.common.AdapterCDATA;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserReq {
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    String name;
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    String email;
}
