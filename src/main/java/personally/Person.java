package personally;

import javax.persistence.*;

import java.util.List;

import static java.lang.String.format;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstname;
    private String surname;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<Address> addresses;

    public String getFullname(){
        return format("%s %s", firstname, surname);
    }

}
