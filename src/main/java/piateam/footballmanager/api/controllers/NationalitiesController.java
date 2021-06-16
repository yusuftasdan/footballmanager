package piateam.footballmanager.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballmanager.business.abstracts.NationalityService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.dtos.NationalityAddDto;
import piateam.footballmanager.entities.dtos.NationalityListDto;

@RestController
@RequestMapping("/api/nationalities")
public class NationalitiesController {

	private NationalityService nationalityService;

	@Autowired
	public NationalitiesController(NationalityService nationalityService) {
		super();
		this.nationalityService = nationalityService;
	}

	@GetMapping("/getAll")
	public DataResult<List<NationalityListDto>> getAll() {
		return this.nationalityService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody NationalityAddDto nationalityAddDto) {
		return this.nationalityService.add(nationalityAddDto);
	}

}
