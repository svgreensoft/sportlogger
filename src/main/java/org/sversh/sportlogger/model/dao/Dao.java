package org.sversh.sportlogger.model.dao;

import org.sversh.sportlogger.model.domain.Identifiable;


public interface Dao<PK, E extends Identifiable<PK>> {

    E find(final PK id);

    void save(final E entity);

    void update(final E entity);

    E merge(E entity);

    void delete(final E entity);

    void deleteById(final PK entityId);

    void saveOrUpdate(E entity);

    void detach(E entity);
}