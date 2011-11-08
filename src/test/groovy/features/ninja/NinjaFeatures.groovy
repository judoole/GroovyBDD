package features.ninja

import steps.background.AbstractSpringGroovyFeature
import static ninja.Weapon.SHURIKIEN
import org.junit.Test
import static factory.ObjectFactory.ninjaHouse
import static factory.ObjectFactory.ninja

class NinjaFeatures extends AbstractSpringGroovyFeature{

    @Test
    void should_be_able_to_kill_a_ninja(){
        Given.ninja_exists([name:"Shredder"])
        When.the_ninja_gets_killed_by(SHURIKIEN)
        Then.the_ninja_should_be_dead("Shredder")
    }

    @Test
    void a_ninja_house_is_destroy_all_ninjas_in_it_is_killed(){
        Given.ninja_exists(ninja())
        And.ninja_house_exists(ninjaHouse(ninjas: [ninja()]))


    }
}
