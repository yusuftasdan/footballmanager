package piateam.footballmanager.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamListDto {

	private String teamName;

	private String logoURL;

	private String city;

	private String yearOfFounded;

	private String colors;

	private String leagueLeagueName;

}
