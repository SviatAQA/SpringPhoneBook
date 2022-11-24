package springcourse.phonebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@AllArgsConstructor
@Data
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contactName;
    private String phoneNumber;

    public UserContact() {
    }
}
