package hr.fer.tel.rasus.tempsensor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reading {

	@Id
	private Integer id;

	private Double temperature;

	public Reading() {
	}

	public Reading(Integer id, Double temperature) {
		this.id = id;
		this.temperature = temperature;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

}
