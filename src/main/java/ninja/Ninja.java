package ninja;

import javax.persistence.*;

@Entity
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private NinjaHouse ninjaHouse;
    private String name;
    private Weapon killedBy;

    public void killBy(Weapon weapon) {
        this.killedBy = weapon;
    }

    public boolean isDead(){
        return killedBy != null;
    }
}
