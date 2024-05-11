package lesson9_9_assignment.uz.pdp.controllers;

import lesson9_9_assignment.uz.pdp.entity.UserEntity;
import lesson9_9_assignment.uz.pdp.service.RegisterService;
import lesson9_9_assignment.uz.pdp.dtos.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
@Slf4j
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        log.info("Program of registration is started");
        this.registerService = registerService;
    }


    @PostMapping("/user-register")
    public void userRegistration(@RequestBody UserDTO userDTO) {
        registerService.saveUser(userDTO);
    }

    @GetMapping("/all")
    public List<UserEntity> getAll() {
        return registerService.getAll();
    }

}
