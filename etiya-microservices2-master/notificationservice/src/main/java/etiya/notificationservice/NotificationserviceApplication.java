package etiya.notificationservice;
import com.etiya.common.events.OrderCreatedEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class NotificationserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationserviceApplication.class, args);
    }

    @KafkaListener(topics = "Order", groupId = "OrderCreatedGroup")
    public void handleOrderCreatedEvent(OrderCreatedEvent event)
    {
        System.out.println("Bir kafka eventi yakalandı:" + event.getCustomerName());
    }

}
