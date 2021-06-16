package piateam.footballmanager.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballmanager.business.abstracts.PositionService;
import piateam.footballmanager.core.utilities.results.DataResult;
import piateam.footballmanager.core.utilities.results.Result;
import piateam.footballmanager.core.utilities.results.SuccessDataResult;
import piateam.footballmanager.core.utilities.results.SuccessResult;
import piateam.footballmanager.dataAccess.abstracts.PositionDao;
import piateam.footballmanager.entities.concretes.Position;
import piateam.footballmanager.entities.dtos.PositionAddDto;
import piateam.footballmanager.entities.dtos.PositionListDto;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;
	private ModelMapper modelMapper;

	@Autowired
	public PositionManager(PositionDao positionDao, ModelMapper modelMapper) {
		super();
		this.positionDao = positionDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<PositionListDto>> getAll() {
		return new SuccessDataResult<List<PositionListDto>>(this.positionDao.findAll().stream()
				.map(element -> modelMapper.map(element, PositionListDto.class)).collect(Collectors.toList()),
				"Data Listelendi(Position).");
	}

	@Override
	public Result add(PositionAddDto positionAddDto) {
		Position position = modelMapper.map(positionAddDto, Position.class);
		this.positionDao.save(position);
		return new SuccessResult("Data Eklendi(Position).");
	}

}
