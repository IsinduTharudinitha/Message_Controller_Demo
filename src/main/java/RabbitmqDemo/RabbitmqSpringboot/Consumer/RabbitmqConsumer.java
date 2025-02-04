package RabbitmqDemo.RabbitmqSpringboot.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info(String.format("Received Message: %s", message));
    }


}
