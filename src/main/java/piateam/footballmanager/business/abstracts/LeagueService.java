package piateam.footballmanager.business.abstracts;

import java.util.List;

import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.dtos.LeagueAddDto;
import piateam.footballmanager.entities.dtos.LeagueListDto;

public interface LeagueService {

	DataResult<List<LeagueListDto>> getAll();

	Result add(LeagueAddDto leagueAddDto);

}
