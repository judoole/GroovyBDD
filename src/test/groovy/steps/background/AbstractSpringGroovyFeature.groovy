package steps.background

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import org.junit.Test

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ["classpath:applicationContext-groovy-bdd.xml"])
class AbstractSpringGroovyFeature extends AbstractGroovyFeature{

}
