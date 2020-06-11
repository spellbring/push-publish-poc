package cl.poc.publisher.pocpublisher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;


@SpringBootApplication
public class PocPublisherApplication {

	@Value(value ="${project.topic.name}")
	private String topic;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PocPublisherApplication.class, args);

	}

	@Bean
	@ServiceActivator(inputChannel = "myOutputChannel")
	public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
		PubSubMessageHandler pubSubMessageHandler = new PubSubMessageHandler(pubsubTemplate, topic);
		pubSubMessageHandler.setSync(true);
		return pubSubMessageHandler;
	}
	@MessagingGateway(defaultRequestChannel = "myOutputChannel")
	public interface PubsubOutboundGateway {
		void sendToPubsub(String text);
	}


}
