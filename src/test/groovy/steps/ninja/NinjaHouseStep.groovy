package steps.ninja

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import ninja.NinjaHouse
import ninja.Weapon
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

@Component
class NinjaHouseStep {
    @PersistenceContext
    private EntityManager em;
    private NinjaHouse ninjaHouse

    @Transactional
    void ninja_house_exists(Object house) {
        this.ninjaHouse = new NinjaHouse(house)
        em.persist(ninjaHouse);
    }

    @Transactional
    void the_ninja_house_gets_gets_blown_up(Weapon weapon) {
        em.find(NinjaHouse.class, ninjaHouse.id).blowUp();
    }

    @Transactional
    void the_ninja_house_should_be_destroyed(String nameOfHouse){
        NinjaHouse n = em.createQuery("from NinjaHouse where name=?").setParameter(1, nameOfHouse).singleResult;
        assertThat(n.destroyed, equalTo(true));
    }
}
