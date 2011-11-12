package steps.ninja

import ninja.NinjaHouse
import ninja.Weapon
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import steps.background.GetEntity
import steps.background.PersistEntity
import static factory.ObjectFactory.ninjaHouse
import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

@Component
class NinjaHouseStep {
    @Autowired GetEntity get
    @Autowired PersistEntity persist
    private NinjaHouse _ninjaHouse

    @Transactional
    void ninja_house_exists(Object house = null) {
        _ninjaHouse = house == null ? ninjaHouse() : new NinjaHouse(house)
        persist.entity(_ninjaHouse);
    }

    @Transactional
    void the_ninjahouse_gets_destroyed_by(Weapon weapon) {
       get.ninjaHouse(_ninjaHouse.name).destroy(weapon);
    }

    @Transactional
    void the_ninjahouse_should_be_destroyed(String name = null) {
        String nameOfHouse = name == null ? _ninjaHouse.name : name;
        NinjaHouse n = get.ninjaHouse(nameOfHouse)
        assertThat(n.destroyed, equalTo(true));
    }
}
