package lesson9_9_assignment.uz.pdp.service;

import lesson9_9_assignment.uz.pdp.activaitionLink.GeneratorActivationLinkGenerator;
import lesson9_9_assignment.uz.pdp.dtos.TodoDTO;
import lesson9_9_assignment.uz.pdp.dtos.UserDTO;
import lesson9_9_assignment.uz.pdp.entity.TODO;
import lesson9_9_assignment.uz.pdp.entity.UserEntity;
import lesson9_9_assignment.uz.pdp.repositroy.TodoRepository;
import lesson9_9_assignment.uz.pdp.repositroy.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RegisterService {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final MailingService mailingService;


    public RegisterService(UserRepository todoRepository, TodoRepository todoRepository1, MailingService mailingService) {
        this.userRepository = todoRepository;
        this.todoRepository = todoRepository1;
        this.mailingService = mailingService;

    }

    public void saveUser(UserDTO userDTO) {
        log.info("Received user registration request: {}", userDTO);

        UserEntity entity = UserEntity.builder()
                .username(userDTO.username())
                .email(userDTO.email())
                .password(userDTO.password())
                .build();
        String activationLink = GeneratorActivationLinkGenerator.activateLink(entity.getId());
        mailingService.sendActivationEmail(activationLink);
        userRepository.save(entity);
        log.info("User registration completed successfully for: {}", userDTO.username());
    }

    public void saveUser(TodoDTO userDTO) {
        TODO todo = TODO
                .builder()
                .title(userDTO.getTitle())
                .description(userDTO.getDescription())
                .completed(userDTO.isCompleted())
                .build();


        String activationLink = GeneratorActivationLinkGenerator.activateLink(todo.getId());
        mailingService.sendActivationEmail(activationLink);
        todoRepository.save(todo);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
