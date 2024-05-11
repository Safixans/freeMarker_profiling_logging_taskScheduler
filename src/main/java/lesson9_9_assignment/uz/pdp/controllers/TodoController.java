package lesson9_9_assignment.uz.pdp.controllers;

import lesson9_9_assignment.uz.pdp.dtos.TodoDTO;
import lesson9_9_assignment.uz.pdp.entity.TODO;
import lesson9_9_assignment.uz.pdp.service.MailingService;
import lesson9_9_assignment.uz.pdp.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// so i end up now :
// whats done till now : registration loggers and alarming on specific time no testing yet cause todocontroller has to be done !!!
// tomorrow it will be checked and rewritten all other specifications or tasks given from pdp )

// most importantly:  no error occured okay
@RestController
@RequestMapping("/todo")
@Slf4j
public class TodoController {
    private final TodoService todoService;
    private final MailingService mailingService;

    public TodoController(TodoService todoService, MailingService mailingService) {
        this.todoService = todoService;
        this.mailingService = mailingService;
    }

    @GetMapping("/all")
    public List<TODO> getAll() {
        log.info("All tasks !!!! ");
        return todoService.getAll();
    }

    @GetMapping("/all-web")
    public ModelAndView getAllWithHtmlPage(ModelAndView modelAndView) {
        log.info("All tasks !!!! ");
        List<TODO> entities = todoService.getAll();
        modelAndView.setViewName("todoWeb");
        modelAndView.addObject("todos", entities);

        return modelAndView;
    }

    @PostMapping("/create")
    public ResponseEntity<TODO> create(@RequestBody TodoDTO todoDTO) {
        log.info("the Todo task is created ... {}", todoDTO);
        return todoService.create(todoDTO);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TODO> update(@RequestBody TodoDTO todoDTO, @PathVariable Long id) {
        log.info("the Todo task is updated ... {}, ID: {}", todoDTO, id);
        TODO updatedTodo = todoService.update(id, todoDTO).getBody();
        if (updatedTodo != null) {
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get/{id}")
    public TODO getById(@PathVariable Long id) {
        log.info("task by specified id: {}", id);
        return todoService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return todoService.deleteTodoById(id);
    }

}
