package hr.fer.tel.rasus.aggregator.model;

public class ReadingDTO {

	private String name;
	private String unit;
	private Double value;

	public ReadingDTO() {
	}

	public ReadingDTO(String name, String unit, Double value) {
		this.name = name;
		this.unit = unit;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public Double getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
