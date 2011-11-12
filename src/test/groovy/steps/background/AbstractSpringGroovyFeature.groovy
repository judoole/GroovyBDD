package steps.background

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ["classpath:applicationContext-groovy-bdd.xml"])
class AbstractSpringGroovyFeature extends AbstractGroovyFeature {
    @PersistenceContext
    private EntityManager em
}
