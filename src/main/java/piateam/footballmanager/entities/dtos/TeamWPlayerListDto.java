package piateam.footballmanager.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import piateam.footballmanager.entities.concretes.Player;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamWPlayerListDto {

	private int id;

	private String teamName;

	private String logoURL;

	private String leagueLeagueName;
	
	private List<Player> players;


}
