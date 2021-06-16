package piateam.footballmanager.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import piateam.footballmanager.entities.concretes.Team;

public interface TeamDao extends JpaRepository<Team, Integer> {
	
	int countByLeague_Id(int id);

	List<Team> findById(int id);
	
}
