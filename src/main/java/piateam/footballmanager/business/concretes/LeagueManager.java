package piateam.footballmanager.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballmanager.business.abstracts.LeagueService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.core.utilities.results.SuccessDataResult;
import piateam.footballmanager.core.utilities.results.SuccessResult;
import piateam.footballmanager.dataAccess.abstracts.LeagueDao;
import piateam.footballmanager.entities.concretes.League;
import piateam.footballmanager.entities.dtos.LeagueAddDto;
import piateam.footballmanager.entities.dtos.LeagueListDto;

@Service
public class LeagueManager implements LeagueService {

	private LeagueDao leagueDao;
	private ModelMapper modelMapper;

	@Autowired
	public LeagueManager(LeagueDao leagueDao, ModelMapper modelMapper) {
		super();
		this.leagueDao = leagueDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<LeagueListDto>> getAll() {
		return new SuccessDataResult<List<LeagueListDto>>(this.leagueDao.findAll().stream()
				.map(element -> modelMapper.map(element, LeagueListDto.class)).collect(Collectors.toList()),
				"Data Listelendi(League");
	}

	@Override
	public Result add(LeagueAddDto leagueAddDto) {
		League league = modelMapper.map(leagueAddDto, League.class);
		this.leagueDao.save(league);
		return new SuccessResult("Data Eklendi(League).");
	}

}
