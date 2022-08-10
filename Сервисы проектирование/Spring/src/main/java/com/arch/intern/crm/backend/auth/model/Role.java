package com.arch.intern.crm.backend.auth.model;

import com.arch.intern.crm.backend.common.abstractmodel.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.*;

@Entity(name="roles")
@Getter
@Setter
public class Role extends AbstractEntity {

	@NotEmpty
	@Size(max = 255)
	@Column(unique = true)
	private String code;

	@NotEmpty
	@Size(max = 255)
	@Column(unique = true)
	private String name;

	private boolean active;

	@Override
	public String toString(){
		return name;
	}
}
