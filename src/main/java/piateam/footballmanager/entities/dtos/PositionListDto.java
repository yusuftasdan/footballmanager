package piateam.footballmanager.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionListDto {

	private int id;

	private String positionName;

	private String positionCode;

}
