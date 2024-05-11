package lesson9_9_assignment.uz.pdp.repositroy;

import lesson9_9_assignment.uz.pdp.dtos.TodoDTO;
import lesson9_9_assignment.uz.pdp.entity.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TODO, Long> {

    @Query("select t from TODO  t where t.completed=false")
    List<TODO> findUncompletedTodos();


}
