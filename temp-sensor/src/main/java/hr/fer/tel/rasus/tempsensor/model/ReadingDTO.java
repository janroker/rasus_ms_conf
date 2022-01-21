package hr.fer.tel.rasus.tempsensor.model;

public class ReadingDTO {

	private String name = "Temperature";
	private String unit = "C";
	private Double value;

	public ReadingDTO(Reading reading) {
		this.value = reading.getTemperature();
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

}
