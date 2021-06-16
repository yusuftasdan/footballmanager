package piateam.footballmanager.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerAddDto {

	private int id;

	private String firstName;

	private String lastName;

	private String number;

	private int positionId;

	private int nationalityId;

	private int teamId;

}
