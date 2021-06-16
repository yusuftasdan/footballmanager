package piateam.footballmanager.business.abstracts;

import java.util.List;

import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.concretes.Team;
import piateam.footballmanager.entities.dtos.TeamAddDto;
import piateam.footballmanager.entities.dtos.TeamListDto;
import piateam.footballmanager.entities.dtos.TeamWPlayerListDto;

public interface TeamService {
	
	DataResult<List<TeamListDto>> getAll();
	
	Result add(TeamAddDto teamAddDto);
	
	Result delete(Team team);
	
	Result update(TeamAddDto teamAddDto);
	
	DataResult<List<TeamWPlayerListDto>> findById(int id);

}
