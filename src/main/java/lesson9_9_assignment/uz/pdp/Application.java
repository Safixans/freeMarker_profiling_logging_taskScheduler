package lesson9_9_assignment.uz.pdp;

import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import lesson9_9_assignment.uz.pdp.service.MailingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.util.Spliterator;

@SpringBootApplication
@EnableAsync
public class Application {

    public static void main(String[] args) {


        SpringApplication.run(Application.class, args);


    }


/*	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost("sandbox.smtp.mailtrap.io");
		javaMailSender.setPort(587);
		javaMailSender.setUsername("b6c12db1ef7060");
		javaMailSender.setPassword("9b8fde923d03f9");

		// Configure additional properties
		Properties properties = javaMailSender.getJavaMailProperties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);

		return javaMailSender;
	}*/
}
