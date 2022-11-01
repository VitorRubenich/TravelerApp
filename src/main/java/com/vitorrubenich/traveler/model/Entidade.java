package com.vitorrubenich.traveler.model;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class Entidade {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidade other = (Entidade) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return String.format("%s [id=%d]", this.getClass().getName(), getId());
	}

	
}
