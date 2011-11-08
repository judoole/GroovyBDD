package ninja;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import static ninja.Weapon.BOMB;

@Entity
public class NinjaHouse {
    @Id
    private String id;
    @OneToMany
    private List<Ninja> ninjas;
    private String name;
    private boolean destroyed;

    public void blowUp(){
        for(Ninja ninja:ninjas){
            ninja.killBy(BOMB);
        }
        destroyed = true;
    }
}
