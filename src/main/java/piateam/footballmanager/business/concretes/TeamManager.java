package piateam.footballmanager.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballmanager.business.abstracts.TeamService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.ErrorResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.core.utilities.results.SuccessDataResult;
import piateam.footballmanager.core.utilities.results.SuccessResult;
import piateam.footballmanager.dataAccess.abstracts.TeamDao;
import piateam.footballmanager.entities.concretes.Team;
import piateam.footballmanager.entities.dtos.TeamAddDto;
import piateam.footballmanager.entities.dtos.TeamListDto;
import piateam.footballmanager.entities.dtos.TeamWPlayerListDto;

@Service
public class TeamManager implements TeamService {

	private TeamDao teamDao;
	private ModelMapper modelMapper;

	@Autowired
	public TeamManager(TeamDao teamDao, ModelMapper modelMapper) {
		super();
		this.teamDao = teamDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<TeamListDto>> getAll() {
		return new SuccessDataResult<List<TeamListDto>>(this.teamDao.findAll().stream()
				.map(element -> modelMapper.map(element, TeamListDto.class)).collect(Collectors.toList()),
				"Data Listelendi(Teams).");
	}

	@Override
	public Result add(TeamAddDto teamAddDto) {
		Team team = modelMapper.map(teamAddDto, Team.class);
		if (this.teamDao.countByLeague_Id(team.getLeague().getId()) == 20) {
			return new ErrorResult("Takım Eklenemedi. Ligde zaten 20 Takım Mevcut.");
		} else {
			this.teamDao.save(team);
			return new SuccessResult("Data Oluşturuldu(Team).");
		}
	}

	@Override
	public Result delete(Team team) {
		this.teamDao.deleteById(team.getId());
		return new SuccessResult("Data Silindi(Team).");
	}

	@Override
	public Result update(TeamAddDto teamAddDto) {
		Team newTeam = this.teamDao.getById(teamAddDto.getId());
		newTeam.setTeamName(teamAddDto.getTeamName());
		newTeam.setLogoURL(teamAddDto.getLogoURL());
		newTeam.setCity(teamAddDto.getCity());
		newTeam.setYearOfFounded(teamAddDto.getYearOfFounded());
		newTeam.getLeague().setId(teamAddDto.getLeagueId());
		this.teamDao.save(newTeam);
		return new SuccessResult("Data Güncellendi(Team).");
	}

	@Override
	public DataResult<List<TeamWPlayerListDto>> findById(int id) {
		return new SuccessDataResult<List<TeamWPlayerListDto>>(this.teamDao.findById(id).stream()
				.map(element -> modelMapper.map(element, TeamWPlayerListDto.class)).collect(Collectors.toList()),
				"Data Listelendi(Players in Team(id)).");
	}

}
