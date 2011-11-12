package steps.background

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import org.junit.Test
import org.junit.After
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ["classpath:applicationContext-groovy-bdd.xml"])
class AbstractSpringGroovyFeature extends AbstractGroovyFeature {
    @PersistenceContext
    private EntityManager em
}
