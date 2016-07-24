package BasicJava.Reflection_IOC_AOP.spring;

/**
 * Created by root on 16-7-24.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application {

  @Bean
  MessageService mockMessageService() {
    return new MessageService() {
      public String getMessage() {
        return "Hello World!";
      }
    };
  }

  public static void main(String[] args) {
    ApplicationContext context =
            new AnnotationConfigApplicationContext(Application.class);
    MessagePrinter printer = context.getBean(MessagePrinter.class);
    printer.printMessage();
  }
}
