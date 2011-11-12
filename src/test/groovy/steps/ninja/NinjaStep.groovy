package steps.ninja

import org.springframework.stereotype.Component
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import org.springframework.transaction.annotation.Transactional
import ninja.Ninja
import ninja.Weapon
import static org.junit.Assert.assertThat
import static org.hamcrest.CoreMatchers.equalTo
import static factory.ObjectFactory.*;

@Component
class NinjaStep {
    @PersistenceContext
    private EntityManager em;
    private Ninja ninjaOnStep

    @Transactional
    void ninja_exists(Object ninja) {
        this.ninjaOnStep = new Ninja(ninja)
        em.persist(this.ninjaOnStep);
    }

    void en_ninja_eksisterer(Object theNinja = null) {
        this.ninjaOnStep = theNinja == null ? ninja() : new Ninja(theNinja)
        em.persist(this.ninjaOnStep);
    }

    @Transactional
    void the_ninja_gets_killed_by(Weapon weapon) {
        em.find(Ninja.class, ninjaOnStep.id).killBy(weapon);
    }

    @Transactional
    void the_ninja_should_be_dead(String nameOfNinja) {
        Ninja n = em.createQuery("from Ninja where name=?").setParameter(1, nameOfNinja).singleResult;
        assertThat(n.isDead(), equalTo(true));
    }
}
