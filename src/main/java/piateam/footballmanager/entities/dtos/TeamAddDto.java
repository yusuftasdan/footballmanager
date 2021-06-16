package piateam.footballmanager.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamAddDto {

	private int id;

	private String teamName;

	private String logoURL;

	private String city;

	private String yearOfFounded;

	private String colors;

	private int leagueId;

}
