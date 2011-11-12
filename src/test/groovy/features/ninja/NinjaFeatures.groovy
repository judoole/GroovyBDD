package features.ninja

import org.junit.After
import org.junit.Test
import steps.background.AbstractSpringGroovyFeature
import static ninja.Weapon.BOMB
import static ninja.Weapon.SHURIKIEN

class NinjaFeatures extends AbstractSpringGroovyFeature{

    @Test
    void should_be_able_to_kill_a_ninja(){
        Given.ninja_exists([name:"Shredder"])
        When.the_ninja_gets_killed_by SHURIKIEN
        Then.the_ninja_should_be_dead "Shredder"
    }

    @Test
    void skal_kverke_alle_ninjas_i_huset_naar_huset_blir_sprengt(){
        Given.ninja_house_exists()
        When.the_ninjahouse_gets_destroyed_by BOMB
        Then.the_ninjahouse_should_be_destroyed()
    }

    @After
    void rydd_i_databasen() {
        remove.allEntities();
    }
}
