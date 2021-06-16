package piateam.footballmanager.business.abstracts;

import java.util.List;

import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.entities.dtos.NationalityAddDto;
import piateam.footballmanager.entities.dtos.NationalityListDto;

public interface NationalityService {

	DataResult<List<NationalityListDto>> getAll();

	Result add(NationalityAddDto nationalityAddDto);

}
