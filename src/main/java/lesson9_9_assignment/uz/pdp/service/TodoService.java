package lesson9_9_assignment.uz.pdp.service;

import lesson9_9_assignment.uz.pdp.dtos.TodoDTO;
import lesson9_9_assignment.uz.pdp.entity.TODO;
import lesson9_9_assignment.uz.pdp.exceptions.TodoNotFoundException;
import lesson9_9_assignment.uz.pdp.repositroy.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TodoService {
    private final TodoRepository todoRepository;
    private final RegisterService registerService;



    public TodoService(TodoRepository todoRepository, RegisterService registerService) {
        this.todoRepository = todoRepository;
        this.registerService = registerService;
    }

    public ResponseEntity<TODO> create(TodoDTO todoDTO) {
        TODO entity = TODO
                .builder()
                .title(todoDTO.getTitle())
                .description(todoDTO.getDescription())
                .completed(todoDTO.isCompleted())
                .build();
        todoRepository.save(entity);
        registerService.saveUser(todoDTO);
        return ResponseEntity.ok().body(entity);
    }

    public ResponseEntity<TODO> update(Long id, TodoDTO todoDTO) {
        Optional<TODO> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            TODO todo = optionalTodo.get();
                    TODO.builder()
                    .title(todoDTO.getTitle())
                    .description(todoDTO.getDescription())
                    .completed(todoDTO.isCompleted())
                    .build();

            todoRepository.save(todo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<TODO> getAll() {
        return todoRepository.findAll();
    }

    public TODO getById(Long id) {
        return todoRepository
                .findById(id)
                .orElseThrow(
                        () -> new TodoNotFoundException("TOdo not found by given ID {}" + id));
    }
    public ResponseEntity<Void> deleteTodoById(Long id){
        Optional<TODO> check = todoRepository.findById(id);
        if (check.isPresent()) {
            log.info("Todo is available on the list and in the process of deleting from it");
        todoRepository.deleteById(id);
            log.info("The task is deleted Successfully!");
        }else {
            log.error("Todo by given id: "+id+"  is not available on the list of TODO`s");
        }

        return ResponseEntity.notFound().build();
    }

}
