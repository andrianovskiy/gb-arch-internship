package com.arch.intern.crm.backend.common.interfeses;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 *
 * @author Marchenko_DS in 08/07/2021
 */
public interface BaseController<T extends AbstractDTO>  {

    ResponseEntity<T> add(final T itemDto);

    ResponseEntity<List<T>> getAll();

    ResponseEntity<T> get(final Long id);

    ResponseEntity<T> delete(final Long id);

    ResponseEntity<T> edit(final Long id, final T itemDto);
}
