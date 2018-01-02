package rudhra.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import rudhra.entity.Car;
import rudhra.exceptions.BadRequestException;
import rudhra.exceptions.NotFoundException;
import rudhra.repository.CarRepository;
import rudhra.service.CarService;

@Service
public class CarServiceImpl implements CarService{
	
	private CarRepository repository;
	
	public CarServiceImpl(CarRepository repository) {
		//super();
		this.repository = repository;
	}

	@Override
	public List<Car> findAll() {
		return repository.findAll();
	}

	@Override
	public Car findOne(String id) {
		Car existingcar = repository.findOne(id); 
		if(existingcar == null) {
			//TODO throw an exception 404 to client
			throw new NotFoundException("Car with id " +id+ "does not exist");
		}
		return existingcar;
	}

	@Override
	public Car update(String id, Car car) {
		Car existing = repository.findByVin(car.getVin());
		if(existing != null ) {
			//TODO throw an exception 400 bad request
			throw new NotFoundException("Car with id " +id+ "does not exist");
		}
		return repository.update(id, car);
	}

	@Override
	public Car createOne(Car car) {
		Car existing = repository.findByVin(car.getVin());
		if(existing != null ) {
			//TODO throw an exception 400 bad request
			throw new BadRequestException("Car with vin " +car.getVin()+ "already exist");
		}
		return repository.createOne(car);
	}

	@Override
	public void delete(String id) {
		Car existing = repository.findOne(id);
		if(existing != null ) {
			//TODO throw an exception 400 bad request
			throw new NotFoundException("Car with id " +id+ "does not exist");
		}
		repository.delete(id);
	}
	

}
