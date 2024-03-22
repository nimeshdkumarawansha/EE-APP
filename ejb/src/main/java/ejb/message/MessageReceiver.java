package ejb.message;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "myQueue")
        }
)
public class MessageReceiver implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message received: " + message.getBody(String.class));
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
