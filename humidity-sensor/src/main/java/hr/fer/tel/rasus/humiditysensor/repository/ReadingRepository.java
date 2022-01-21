package hr.fer.tel.rasus.humiditysensor.repository;

import org.springframework.data.repository.CrudRepository;

import hr.fer.tel.rasus.humiditysensor.model.Reading;

public interface ReadingRepository extends CrudRepository<Reading, Integer>{

}
