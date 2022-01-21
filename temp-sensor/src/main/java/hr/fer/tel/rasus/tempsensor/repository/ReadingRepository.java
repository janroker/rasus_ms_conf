package hr.fer.tel.rasus.tempsensor.repository;

import org.springframework.data.repository.CrudRepository;

import hr.fer.tel.rasus.tempsensor.model.Reading;

public interface ReadingRepository extends CrudRepository<Reading, Integer>{

}
