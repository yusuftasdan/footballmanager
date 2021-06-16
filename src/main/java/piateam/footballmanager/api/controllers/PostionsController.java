package piateam.footballmanager.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballmanager.business.abstracts.PositionService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.dtos.PositionAddDto;
import piateam.footballmanager.entities.dtos.PositionListDto;

@RestController
@RequestMapping("/api/positions")
public class PostionsController {

	private PositionService positionService;

	@Autowired
	public PostionsController(PositionService positionService) {
		super();
		this.positionService = positionService;
	}

	@GetMapping("/getAll")
	public DataResult<List<PositionListDto>> getAll() {
		return this.positionService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody PositionAddDto positionAddDto) {
		return this.positionService.add(positionAddDto);
	}

}
