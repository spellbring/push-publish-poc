package cl.poc.blpoc.rest.message;

import lombok.ToString;

@ToString
public class Message {
    Attributes AttributesObject;
    private String data;
    private String messageId;


    // Getter Methods

    public Attributes getAttributes() {
        return AttributesObject;
    }

    public String getData() {
        return data;
    }

    public String getMessageId() {
        return messageId;
    }

    // Setter Methods

    public void setAttributes(Attributes attributesObject) {
        this.AttributesObject = attributesObject;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}