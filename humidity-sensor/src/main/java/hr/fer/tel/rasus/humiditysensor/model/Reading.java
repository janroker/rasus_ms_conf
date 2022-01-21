package hr.fer.tel.rasus.humiditysensor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reading {

	@Id
	private Integer id;
	private Double humidity;

	public Reading(Integer id, Double humidity) {
		this.id = id;
		this.humidity = humidity;
	}

	public Reading() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

}
