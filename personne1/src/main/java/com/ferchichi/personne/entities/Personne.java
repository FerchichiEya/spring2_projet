package com.ferchichi.personne.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPersonne;

	@NotNull
	private String nomPersonne;

	@Min(value = 300)
	@Max(value = 10000)
	private double salairePersonne;

	private long telPersonne;

	@ManyToOne
	private Machine machine;

	public Personne(long idPersonne, @NotNull String nomPersonne, @Min(300) @Max(10000) double salairePersonne,
			long telPersonne) {
		super();
		this.idPersonne = idPersonne;
		this.nomPersonne = nomPersonne;
		this.salairePersonne = salairePersonne;
		this.telPersonne = telPersonne;
	}

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public double getSalairePersonne() {
		return salairePersonne;
	}

	public void setSalairePersonne(double salairePersonne) {
		this.salairePersonne = salairePersonne;
	}

	public long getTelPersonne() {
		return telPersonne;
	}

	public void setTelPersonne(long telPersonne) {
		this.telPersonne = telPersonne;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nomPersonne=" + nomPersonne + ", salairePersonne="
				+ salairePersonne + ", telPersonne=" + telPersonne + "]";
	}

}
