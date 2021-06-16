package piateam.footballmanager.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballmanager.business.abstracts.PlayerService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.concretes.Player;
import piateam.footballmanager.entities.dtos.PlayerAddDto;
import piateam.footballmanager.entities.dtos.PlayerListDto;

@RestController
@RequestMapping("/api/players")
public class PlayersController {

	private PlayerService playerService;

	@Autowired
	public PlayersController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}

	@GetMapping("/getAll")
	public DataResult<List<PlayerListDto>> getAll() {
		return this.playerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody PlayerAddDto playerAddDto) {
		return this.playerService.add(playerAddDto);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam Player player) {
		return this.delete(player);
	}

	@PutMapping("/update")
	public Result update(@RequestBody PlayerAddDto playerAddDto) {
		return this.playerService.update(playerAddDto);
	}

}
