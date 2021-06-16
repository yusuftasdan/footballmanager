package piateam.footballmanager.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballmanager.business.abstracts.LeagueService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.dtos.LeagueAddDto;
import piateam.footballmanager.entities.dtos.LeagueListDto;

@RestController
@RequestMapping("/api/leagues")
public class LeaguesController {
	
	private LeagueService leagueService;

	@Autowired
	public LeaguesController(LeagueService leagueService) {
		super();
		this.leagueService = leagueService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<LeagueListDto>> getAll(){
		return this.leagueService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LeagueAddDto leagueAddDto) {
		return this.leagueService.add(leagueAddDto);
	}

}
