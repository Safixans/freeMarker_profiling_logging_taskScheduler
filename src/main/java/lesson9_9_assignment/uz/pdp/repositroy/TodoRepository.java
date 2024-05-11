package lesson9_9_assignment.uz.pdp.repositroy;

import lesson9_9_assignment.uz.pdp.entity.TODO;
import lesson9_9_assignment.uz.pdp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<TODO, Long> {

    @Query("select t from TODO  t where t.completed=false")
    List<TODO> findUncompletedTodos();

    Optional<UserEntity> findByTitle(String title);

}
