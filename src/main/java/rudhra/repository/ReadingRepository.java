package rudhra.repository;

import rudhra.entity.Readings;

public interface ReadingRepository {

	Readings saveReading(Readings readings);
}