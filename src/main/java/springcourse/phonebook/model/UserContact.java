package springcourse.phonebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contact")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contactName;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> phoneNumbers;

}
