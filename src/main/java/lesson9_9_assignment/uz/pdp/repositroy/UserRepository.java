package lesson9_9_assignment.uz.pdp.repositroy;

import lesson9_9_assignment.uz.pdp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
