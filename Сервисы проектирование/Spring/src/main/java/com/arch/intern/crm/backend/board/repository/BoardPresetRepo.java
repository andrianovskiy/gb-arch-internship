package com.arch.intern.crm.backend.board.repository;

import com.arch.intern.crm.backend.board.model.BoardPreset;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
public interface BoardPresetRepo extends JpaRepository<BoardPreset, Long> {

}
