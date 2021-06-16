package piateam.footballmanager.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import piateam.footballmanager.entities.concretes.League;

public interface LeagueDao extends JpaRepository<League, Integer> {

}
