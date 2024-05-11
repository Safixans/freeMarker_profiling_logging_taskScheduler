package lesson9_9_assignment.uz.pdp.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lesson9_9_assignment.uz.pdp.entity.TODO;
import lesson9_9_assignment.uz.pdp.repositroy.TodoRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MailingService {
    private final Configuration configuration;

    private final JavaMailSender javaMailSender;
    private final TodoRepository todoRepository;

    public MailingService(Configuration configuration, JavaMailSender javaMailSender,
                          TodoRepository todoRepository) {
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
        this.todoRepository = todoRepository;
    }

    @Async
    public void sendActivationEmail(String activationLink) {/// using freeMarker
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo("safixongg@gmail.com");
            helper.setSubject("Account Activation");

            Map<String, Object> model = new HashMap<>();
            model.put("activationLink", activationLink);

            String html = getHtmlFromTemplate(model, "registration.ftlh");
            helper.setText(html, true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = " * * * * * *")// every day at 8 am and 8 pm alarming 0 0 8,20 * * *
    public void sendUncompletedTodoList() throws TemplateException, IOException, MessagingException {
        List<TODO> uncompletedTodos = todoRepository.findUncompletedTodos();

        if (uncompletedTodos.isEmpty()) {
            return;
        }
        Map<String, Object> model = new HashMap<>();
        model.put("todos", uncompletedTodos);
        String htmlFromTemplate = getHtmlFromTemplate(model, "uncompletedTodosList.ftlh");

        sendEmail("Your uncompleted tasks", htmlFromTemplate);

    }

    private String getHtmlFromTemplate(Map<String, Object> model, String templateName) throws IOException, TemplateException {
        Template template = configuration.getTemplate(templateName);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    }

    private void sendEmail(String subject, String htmlBody) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo("safixongg@gmail.com");
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        javaMailSender.send(message);
    }

}


