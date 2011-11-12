package steps.background

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import org.springframework.stereotype.Component

@Component
class PersistEntity {
    @PersistenceContext EntityManager em

    void entity(Object entity){
        em.persist(entity);
    }
}
