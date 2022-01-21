package hr.fer.tel.rasus.humiditysensor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hr.fer.tel.rasus.humiditysensor.model.Reading;
import hr.fer.tel.rasus.humiditysensor.repository.ReadingRepository;

@Component
public class ReadingsLoader implements CommandLineRunner {

	private ReadingRepository readingRepository;

	@Autowired
	public ReadingsLoader(ReadingRepository readingRepository) {
		this.readingRepository = readingRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("readings.csv"))))) {

			Counter cnt = new Counter();

			List<Reading> list = br.lines().map(l -> {
				Reading r = new Reading(cnt.cnt, new ReadingLine(splitLine(l)).getHumidity());
				cnt.cnt++;
				return r;
			}).collect(Collectors.toList());

			readingRepository.saveAll(list.subList(1, list.size()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class Counter {
		int cnt = 0;
	}

	@SuppressWarnings("unused")
	private static class ReadingLine {

		private Double temperature;
		private Double pressure;
		private Double humidity;
		private Double co;
		private Double no2;
		private Double so2;

		public ReadingLine(String... params) {
			this(parseParam(params[0]), parseParam(params[1]), parseParam(params[2]), parseParam(params[3]),
					parseParam(params[4]), parseParam(params[5]));
		}

		public ReadingLine(Double temperature, Double pressure, Double humidity, Double co, Double no2, Double so2) {
			super();
			this.temperature = temperature;
			this.pressure = pressure;
			this.humidity = humidity;
			this.co = co;
			this.no2 = no2;
			this.so2 = so2;
		}

		public Double getHumidity() {
			return humidity;
		}

		private static Double parseParam(String param) {
			try {
				return (param.isBlank() ? null : Double.parseDouble(param));
			} catch (NumberFormatException e) {
				return null;
			}
		}

	}

	private static String[] splitLine(String line) {
		String[] arr = new String[6];
		int cnt = 0;
		int prevIdx = 0;
		int idx = line.indexOf(',');

		while (idx > -1) {
			arr[cnt] = line.substring(prevIdx, idx);
			prevIdx = idx + 1;
			idx = line.indexOf(',', idx + 1);
			cnt++;
		}
		return arr;
	}

}
