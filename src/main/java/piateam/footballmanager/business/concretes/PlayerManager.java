package piateam.footballmanager.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballmanager.business.abstracts.PlayerService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.ErrorResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.core.utilities.results.SuccessDataResult;
import piateam.footballmanager.core.utilities.results.SuccessResult;
import piateam.footballmanager.dataAccess.abstracts.PlayerDao;
import piateam.footballmanager.entities.concretes.Player;
import piateam.footballmanager.entities.dtos.PlayerAddDto;
import piateam.footballmanager.entities.dtos.PlayerListDto;

@Service
public class PlayerManager implements PlayerService {

	private PlayerDao playerDao;
	private ModelMapper modelMapper;

	@Autowired
	public PlayerManager(PlayerDao playerDao, ModelMapper modelMapper) {
		super();
		this.playerDao = playerDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<PlayerListDto>> getAll() {
		return new SuccessDataResult<List<PlayerListDto>>(this.playerDao.findAll().stream()
				.map(element -> modelMapper.map(element, PlayerListDto.class)).collect(Collectors.toList()),
				"Data Listelendi(Player");
	}

	/*
	 * nationalityid=2 (yabancı uyruklu oyuncu) ----- positionid=1 (Kaleci id)
	 */

	@Override
	public Result add(PlayerAddDto playerAddDto) {
		Player player = modelMapper.map(playerAddDto, Player.class);
		if (this.playerDao.countByTeam_Id(player.getTeam().getId()) == 18) {
			return new ErrorResult("Oyuncu Eklenemedi. Takımda 18 oyuncu bulunmakta.");
		} else if (player.getNationality().getId() == 2
				&& this.playerDao.countByTeam_IdAndNationality_Id(player.getTeam().getId(), 2) == 6) {
			return new ErrorResult("Oyuncu Eklenemedi. Takımda 6 yabancı uyruklu oyuncu bulunmakta.");
		} else if (player.getPosition().getId() == 1
				&& this.playerDao.countByTeam_IdAndPosition_Id(player.getTeam().getId(), 1) == 2) {
			return new ErrorResult("Oyuncu Eklenemedi. Takımda 2 kaleci bulunmakta.");
		} else {
			this.playerDao.save(player);
			return new SuccessResult("Data Eklendi(Player).");
		}
	}

	@Override
	public Result delete(Player player) {
		this.playerDao.delete(player);
		return new SuccessResult("Data Silindi(Player).");
	}

	@Override
	public Result update(PlayerAddDto playerAddDto) {
		Player newPlayer=this.playerDao.getById(playerAddDto.getId());
		newPlayer.setFirstName(playerAddDto.getFirstName());
		newPlayer.setLastName(playerAddDto.getLastName());
		newPlayer.setNumber(playerAddDto.getNumber());
		newPlayer.getPosition().setId(playerAddDto.getPositionId());
		newPlayer.getNationality().setId(playerAddDto.getNationalityId());
		newPlayer.getTeam().setId(playerAddDto.getTeamId());
		this.playerDao.save(newPlayer);
		return new SuccessResult("Data Güncellendi(Player).");
	}

}
