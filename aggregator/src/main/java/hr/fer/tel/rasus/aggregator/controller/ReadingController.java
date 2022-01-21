package hr.fer.tel.rasus.aggregator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import hr.fer.tel.rasus.aggregator.model.ReadingDTO;

@RequestMapping("reading")
@RestController
@RefreshScope
public class ReadingController {

	@Autowired
	private EurekaClient discoveryClient;

	@Value("${app.temp.unit}")
	private String tempUnit;

	@GetMapping("")
	public ResponseEntity<List<ReadingDTO>> getReading() {
		InstanceInfo hum = discoveryClient.getNextServerFromEureka("humidity-sensor", false);
		InstanceInfo temp = discoveryClient.getNextServerFromEureka("temp-sensor", false);

		RestTemplate rt = new RestTemplate();

		ReadingDTO humidity = rt.getForEntity(hum.getHomePageUrl() + "/reading", ReadingDTO.class).getBody();
		ReadingDTO temperature = rt.getForEntity(temp.getHomePageUrl() + "/reading", ReadingDTO.class).getBody();

		if (tempUnit.equals("K")) {
			temperature = new ReadingDTO(temperature.getName(), tempUnit, temperature.getValue() + 273.15);
		}

		return ResponseEntity.ok(List.of(humidity, temperature));
	}

}
