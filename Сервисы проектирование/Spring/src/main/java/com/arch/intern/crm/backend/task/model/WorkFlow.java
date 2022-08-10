package com.arch.intern.crm.backend.task.model;

import com.arch.intern.crm.backend.board.model.BoardPreset;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "work_flows")
@Data
@EqualsAndHashCode
public class WorkFlow extends AbstractEntity {

    private String code;

    private String name;

    @ManyToMany
    private List<BoardPreset> boardPreset;
}
