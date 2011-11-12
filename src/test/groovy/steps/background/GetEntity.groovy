package steps.background

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import ninja.Ninja
import ninja.NinjaHouse
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class GetEntity {
    @PersistenceContext EntityManager em

    @Transactional
    NinjaHouse ninjaHouse(String name){
        return em.createQuery("from NinjaHouse where name=?").setParameter(1, name).singleResult
    }
    @Transactional
    Ninja ninja(String name){
        return em.createQuery("from Ninja where name=?").setParameter(1, name).singleResult
    }
}
