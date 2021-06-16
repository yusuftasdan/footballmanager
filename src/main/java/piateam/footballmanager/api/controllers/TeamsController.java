package piateam.footballmanager.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballmanager.business.abstracts.TeamService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.concretes.Team;
import piateam.footballmanager.entities.dtos.TeamAddDto;
import piateam.footballmanager.entities.dtos.TeamListDto;
import piateam.footballmanager.entities.dtos.TeamWPlayerListDto;

@RestController
@RequestMapping("/api/teams")
public class TeamsController {

	private TeamService teamService;

	@Autowired
	public TeamsController(TeamService teamService) {
		super();
		this.teamService = teamService;
	}

	@GetMapping("/getAll")
	public DataResult<List<TeamListDto>> getAll() {
		return this.teamService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody TeamAddDto teamAddDto) {
		return this.teamService.add(teamAddDto);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam Team team) {
		return this.teamService.delete(team);
	}

	@PutMapping("/update")
	public Result update(@RequestBody TeamAddDto teamAddDto) {
		return this.teamService.update(teamAddDto);
	}

	@GetMapping(value = "/getPlayersByTeamId/{id}")
	public DataResult<List<TeamWPlayerListDto>> findById(@PathVariable int id) {
		return this.teamService.findById(id);
	}

}
