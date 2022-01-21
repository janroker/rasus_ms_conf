package hr.fer.tel.rasus.tempsensor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.tel.rasus.tempsensor.model.ReadingDTO;
import hr.fer.tel.rasus.tempsensor.repository.ReadingRepository;

@RequestMapping("reading")
@RestController
public class ReadingController {

	private ReadingRepository readingRepository;

	@Autowired
	public ReadingController(ReadingRepository readingRepository) {
		this.readingRepository = readingRepository;
	}

	@GetMapping("")
	public ResponseEntity<ReadingDTO> getReading() {
		ReadingDTO res = new ReadingDTO(
				readingRepository.findById((int) (System.currentTimeMillis() % 100) + 1).orElseThrow());
		return ResponseEntity.ok(res);
	}

}
