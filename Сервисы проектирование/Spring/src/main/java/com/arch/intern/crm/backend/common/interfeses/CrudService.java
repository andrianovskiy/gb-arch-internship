package com.arch.intern.crm.backend.common.interfeses;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * @author Marchenko_DS in 25/04/2022
 */

public interface CrudService<T extends AbstractEntity> {

    /**
     * Переопрееление интерфейса репозитария
     *
     * @return
     */
    JpaRepository<T, Long> getRepository();

    /**
     * save item
     *
     * @param entity
     * @return
     */
    default T save(T entity) {
        return getRepository().saveAndFlush(entity);
    }

    /**
     * Delete by entity
     *
     * @param entity
     */
    default void delete(T entity) {
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        getRepository().delete(entity);
    }

    /**
     * delete by id
     *
     * @param id
     * @return
     */
    default T delete(Long id) {
        Optional<T> entity = find(id);
        delete(entity.get());
        return entity.get();
    }

    /**
     * Count items
     *
     * @return
     */
    default long count() {
        return getRepository().count();
    }

    /**
     * Find item
     *
     * @param id
     * @return
     */
    default Optional<T> find(Long id) {
        Optional<T> entity = getRepository().findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }

    /**
     * Find all items
     *
     * @return
     */
    default List<T> findAll() {
        return StreamSupport
                .stream(getRepository().findAll().spliterator(), false)
                .collect(Collectors.toList());

    }

}
