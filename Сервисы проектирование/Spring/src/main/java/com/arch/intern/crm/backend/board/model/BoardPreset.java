package com.arch.intern.crm.backend.board.model;

import com.arch.intern.crm.backend.board.model.enums.BoardType;
import com.arch.intern.crm.backend.board.model.enums.BoardView;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@Entity
@Table(name = "boards_preset")
@Data
@EqualsAndHashCode
public class BoardPreset extends AbstractEntity {

    private String name;

    private String text;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Enumerated(EnumType.STRING)
    private BoardView boardView;

//
//    @OneToMany
//    private List<Task> tasks;
}
