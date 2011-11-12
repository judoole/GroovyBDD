package steps.ninja

import ninja.Ninja
import ninja.Weapon
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import steps.background.GetEntity
import steps.background.PersistEntity
import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat
import static factory.ObjectFactory.ninja

@Component
class NinjaStep {
    @Autowired GetEntity get
    @Autowired PersistEntity persist
    private Ninja _ninja

    @Transactional
    void ninja_exists(Object theNinja = null) {
        _ninja = theNinja == null ? ninja() : new Ninja(theNinja)
        persist.entity(this._ninja);
    }

    @Transactional
    void the_ninja_gets_killed_by(Weapon weapon) {
        get.ninja(_ninja.name).killBy(weapon);
    }

    @Transactional
    void the_ninja_should_be_dead(String nameOfNinja) {
        assertThat(get.ninja(nameOfNinja).isDead(), equalTo(true));
    }
}
