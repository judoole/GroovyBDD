package steps.background

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

class MergeEntity {
    @PersistenceContext EntityManager em

    void entity(Object entity) {
        em.merge(entity);
    }
}
