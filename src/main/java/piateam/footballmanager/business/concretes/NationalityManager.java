package piateam.footballmanager.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballmanager.business.abstracts.NationalityService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.core.utilities.results.SuccessDataResult;
import piateam.footballmanager.core.utilities.results.SuccessResult;
import piateam.footballmanager.dataAccess.abstracts.NationalityDao;
import piateam.footballmanager.entities.concretes.Nationality;
import piateam.footballmanager.entities.dtos.NationalityAddDto;
import piateam.footballmanager.entities.dtos.NationalityListDto;

@Service
public class NationalityManager implements NationalityService {

	private NationalityDao nationalityDao;
	private ModelMapper modelMapper;

	@Autowired
	public NationalityManager(NationalityDao nationalityDao, ModelMapper modelMapper) {
		super();
		this.nationalityDao = nationalityDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<NationalityListDto>> getAll() {
		return new SuccessDataResult<List<NationalityListDto>>(this.nationalityDao.findAll().stream()
				.map(element -> modelMapper.map(element, NationalityListDto.class)).collect(Collectors.toList()),
				"Data Listelendi(Natioonality).");
	}

	@Override
	public Result add(NationalityAddDto nationalityAddDto) {
		Nationality nationality = modelMapper.map(nationalityAddDto, Nationality.class);
		this.nationalityDao.save(nationality);
		return new SuccessResult("Data Eklendi(Nationality).");
	}

}
