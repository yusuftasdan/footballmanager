package piateam.footballmanager.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "team_logo")
	private String logoURL;

	@Column(name = "team_city")
	private String city;

	@Column(name = "year_of_founded")
	private String yearOfFounded;

	@Column(name = "colors")
	private String colors;

	@ManyToOne
	@JoinColumn(name = "league_id", referencedColumnName = "id")
	private League league;

	@OneToMany
	private List<Player> player;

}
