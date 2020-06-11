package cl.poc.blpoc.rest.message;

import lombok.ToString;

@ToString
public class MessagePubSub {

    Message MessageObject;
    private String subscription;


    // Getter Methods

    public Message getMessage() {
        return MessageObject;
    }

    public String getSubscription() {
        return subscription;
    }

    // Setter Methods

    public void setMessage(Message messageObject) {
        this.MessageObject = messageObject;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }


}

