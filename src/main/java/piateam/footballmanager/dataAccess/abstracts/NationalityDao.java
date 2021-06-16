package piateam.footballmanager.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import piateam.footballmanager.entities.concretes.Nationality;

public interface NationalityDao extends JpaRepository<Nationality, Integer> {

}
