package BasicJava.Reflection_IOC_AOP.spring;

/**
 * Created by root on 16-7-24.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

  final private MessageService service;

  // 构造器依赖注入, Constructor injection is the best way of doing DI
  @Autowired
  public MessagePrinter(MessageService service) {
    this.service = service;
  }

  public void printMessage() {
    System.out.println(this.service.getMessage());
  }
}
