package piateam.footballmanager.business.abstracts;

import java.util.List;

import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.concretes.Player;
import piateam.footballmanager.entities.dtos.PlayerAddDto;
import piateam.footballmanager.entities.dtos.PlayerListDto;

public interface PlayerService {
	
	DataResult<List<PlayerListDto>> getAll();
	
	Result add(PlayerAddDto playerAddDto);
	
	Result delete(Player player);
	
	Result update(PlayerAddDto playerAddDto);

}
