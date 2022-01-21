package hr.fer.tel.rasus.humiditysensor.model;

public class ReadingDTO {

	private String name = "Humidity";
	private String unit = "%";
	private Double value;

	public ReadingDTO(Reading reading) {
		this.value = reading.getHumidity();
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
