package com.arch.intern.crm.backend.board.model.dto;

import com.arch.intern.crm.backend.board.model.enums.BoardType;
import com.arch.intern.crm.backend.board.model.enums.BoardView;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Marchenko_DS in 25/04/2022
 */
@Getter
@Setter
public class BoardPresetDTO extends AbstractDTO{

    private String name;

    private String text;

    private BoardType boardType;

    private BoardView boardView;

    private String filter;

}
