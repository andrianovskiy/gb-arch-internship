package com.arch.intern.crm.backend.task.model.dto;

import com.arch.intern.crm.backend.board.model.BoardPreset;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractDTO;
import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
public class WorkFlowDTO extends AbstractDTO {

    private String code;

    private String name;

    private List<BoardPreset> boardPreset;
}
