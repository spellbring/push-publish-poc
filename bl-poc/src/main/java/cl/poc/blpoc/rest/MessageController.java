package cl.poc.blpoc.rest;


import cl.poc.blpoc.rest.message.MessagePubSub;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    @PostMapping("/message")
    public String saveFlightConfig(@RequestBody MessagePubSub messagePubSub) {
        String subscription = messagePubSub.getSubscription();
        String message = messagePubSub.getMessage().getData();

        byte[] byteDecoded = Base64.decodeBase64(message.getBytes());
        LOGGER.info(subscription
                .concat(" Data:")
                .concat(message)
                .concat (" Message Decode BASE64:")
                .concat(new String(byteDecoded))

        ) ;
        return "OK";


    }




}
