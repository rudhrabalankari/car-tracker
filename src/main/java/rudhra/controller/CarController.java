package rudhra.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rudhra.constants.URI;
import rudhra.entity.Car;
import rudhra.service.CarService;

@RestController
@RequestMapping(value = URI.CARS)
public class CarController {

	private CarService service;

	public CarController(CarService service) {
		// super();
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Car> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Car findOne(@PathVariable("vin") String vin) {
		return service.findOne(vin);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Car createOne(@RequestBody Car car) {
		return service.createOne(car);

	}

	@RequestMapping(method = RequestMethod.PUT, value = URI.ID, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Car update(@PathVariable("vin") String vin, @RequestBody Car car) {
		return service.update(vin, car);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = URI.ID, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("vin") String vin) {
		service.delete(vin);
	}

}
