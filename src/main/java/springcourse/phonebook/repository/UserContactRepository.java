package springcourse.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springcourse.phonebook.model.UserContact;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserContactRepository extends JpaRepository<UserContact, Long> {

   Optional<UserContact> findByContactName(String contactName);

    List<UserContact> findAll();
}
