package com.ferchichi.personne.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Machine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMachine;

	private String nomMachine;
	private String descMachine;

	@JsonIgnore
	@OneToMany(mappedBy = "machine")
	List<Personne> personne;

	public String getDescMachine() {
		return descMachine;
	}

	public void setDescMachine(String descMachine) {
		this.descMachine = descMachine;
	}

	public String getNomMachine() {
		return nomMachine;
	}

	public void setNomMachine(String nomMachine) {
		this.nomMachine = nomMachine;
	}

	public long getIdMachine() {
		return idMachine;
	}

	public void setIdMachine(long idMachine) {
		this.idMachine = idMachine;
	}

	public List<Personne> getPersonne() {
		return personne;
	}

	public void setPersonne(List<Personne> personne) {
		this.personne = personne;
	}

}
