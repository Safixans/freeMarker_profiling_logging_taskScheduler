package lesson9_9_assignment.uz.pdp.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TodoDTO {
    private String title;
    private String description;
    private boolean completed;
//    private LocalDateTime createdAt;
}
