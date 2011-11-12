package ninja;

import javax.persistence.*;
import java.util.List;

@Entity
public class NinjaHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Ninja> ninjas;
    private String name;
    private boolean destroyed;

    public NinjaHouse() {
    }

    public void destroy(Weapon weapon){
        for(Ninja ninja:ninjas){
            ninja.killBy(weapon);
        }
        destroyed = true;
    }
}
