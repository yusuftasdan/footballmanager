package piateam.footballmanager.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerListDto {
	
	private int id;

	private String firstName;

	private String lastName;

	private String number;

	private String nationalityNationalityName;

	private String positionPositionCode;

	private String teamTeamName;

}
