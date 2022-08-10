package com.arch.intern.crm.backend.board.service;

import com.arch.intern.crm.backend.board.model.BoardPreset;
import com.arch.intern.crm.backend.board.repository.BoardPresetRepo;
import com.arch.intern.crm.backend.common.interfeses.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class BoardPresetService implements CrudService<BoardPreset> {

    private final BoardPresetRepo boardRepo;

    @Autowired
    public BoardPresetService(BoardPresetRepo boardRepo) {
        this.boardRepo = boardRepo;
    }


    @Override
    public JpaRepository<BoardPreset, Long> getRepository() {
        return boardRepo;
    }


}
