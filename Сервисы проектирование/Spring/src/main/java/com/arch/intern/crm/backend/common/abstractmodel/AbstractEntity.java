package com.arch.intern.crm.backend.common.abstractmodel;

import com.arch.intern.crm.backend.auth.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id", unique = true, nullable = false)
	private Long id;


	@Column(name = "created")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
	private Date created;

	@Column(name = "modified")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
	private Date modified;

	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private User user;

	@Version
	private int version;

	public boolean isNew() {
		return id == null;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AbstractEntity(Long id) {
		this.id = id;
	}

	public AbstractEntity() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractEntity that = (AbstractEntity) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
