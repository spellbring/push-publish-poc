package cl.poc.publisher.pocpublisher.controller;

import cl.poc.publisher.pocpublisher.PocPublisherApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private PocPublisherApplication.PubsubOutboundGateway messagingGateway;

    @Autowired
    public MessageController(PocPublisherApplication.PubsubOutboundGateway messagingGateway) {
        this.messagingGateway = messagingGateway;
    }

    @PostMapping("/message")
    public String publishMessage(@RequestBody String message) {
        messagingGateway.sendToPubsub(message);

        return "OK";
    }
}
