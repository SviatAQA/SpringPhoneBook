package springcourse.phonebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Size(min = 3, max = 16, message
            = "Phone number must be between 3 and 16 digits")
    private List<String> phoneNumbers;

}
