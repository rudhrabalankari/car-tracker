package rudhra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rudhra.entity.Readings;
import rudhra.service.ReadingService;

@RestController
public class ReadingController {

	@Autowired
	ReadingService readingService;

	@RequestMapping(method = RequestMethod.POST, value = "/readings")
	public Readings saveReading(Readings readings) {
		return readingService.saveReading(readings);
	}
}