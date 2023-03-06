package io.github.fairyspace.springbootdemo.config;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;
import lombok.SneakyThrows;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

public class MessageConvert extends AbstractHttpMessageConverter {


    public MessageConvert() {
        super(new MediaType("application","xml"));
    }

    @Override
    protected boolean supports(Class clazz) {
        return true;
    }

    @SneakyThrows
    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshal = unmarshaller.unmarshal(inputMessage.getBody());
        return unmarshal;
    }

    @SneakyThrows
    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        CharacterEscapeHandler escapeHandler = NoEscapeHandler.theInstance;
        marshaller.setProperty("com.sun.xml.internal.bind.characterEscapeHandler",escapeHandler);
        marshaller.marshal(o,outputMessage.getBody());
    }
}
