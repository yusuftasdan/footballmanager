package piateam.footballmanager.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import piateam.footballmanager.entities.concretes.Player;

public interface PlayerDao extends JpaRepository<Player, Integer> {
	
	int countByTeam_Id(int id);
	int countByTeam_IdAndNationality_Id(int teamId, int positionId);
	int countByTeam_IdAndPosition_Id(int teamId, int positionId);

}
