package piateam.footballmanager.business.abstracts;

import java.util.List;

import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.dtos.PositionAddDto;
import piateam.footballmanager.entities.dtos.PositionListDto;

public interface PositionService {
	
	DataResult<List<PositionListDto>> getAll();
	
	Result add(PositionAddDto positionAddDto);

}
