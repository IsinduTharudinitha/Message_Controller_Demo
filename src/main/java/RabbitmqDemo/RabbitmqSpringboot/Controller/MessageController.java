package RabbitmqDemo.RabbitmqSpringboot.Controller;


import RabbitmqDemo.RabbitmqSpringboot.Publisher.RabbitmqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitmqProducer rabbitmqProducer;

    public MessageController(RabbitmqProducer rabbitmqProducer) {
        this.rabbitmqProducer = rabbitmqProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitmqProducer.sendMessage(message);
        return ResponseEntity.ok("Message Sent to RabbitMQ ...");
    }

}
