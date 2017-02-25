package org.sversh.sportlogger.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sversh.sportlogger.model.domain.Identifiable;

/**
 * 
 * 
 * @author Sergey Vershinin
 *
 * @param <PK>
 * @param <E>
 */
@Repository
public abstract class BaseDao<PK, E extends Identifiable<PK>> implements Dao <PK, E> {
    private static final Logger LOG = LoggerFactory.getLogger(BaseDao.class);

    @PersistenceContext
    private EntityManager entityManager;
    
    private final Class<E> clazz;

    protected BaseDao(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public E find(final PK id) {
        return entityManager.find(clazz, id);
    }


    @Transactional(propagation = Propagation.MANDATORY)
    public void save(final E entity) {
        entityManager.persist(entity);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void update(final E entity) {
        entityManager.merge(entity);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void delete(final E entity) {
        entityManager.remove(entity);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteById(PK entityId) {
        final E entity = entityManager.find(clazz, entityId);
        delete(entity);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void saveOrUpdate(E entity) {
        if (entity.getId() == null) {
            save(entity);
        } else {
            update(entity);
        }
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public E merge(E entity) {
        return entityManager.merge(entity);
    }

    public void detach(E entity) {
        getEntityManager().detach(entity);
    }

}
