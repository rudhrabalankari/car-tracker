package rudhra.repository;

import java.util.List;

import rudhra.entity.Car;

public interface CarRepository {
	
	public List<Car> findAll();
	public Car findOne(String id);
	public Car update(String id, Car car);
	public Car createOne(Car car);
	public void delete(String id);
	public Car findByVin(String vin);

}
