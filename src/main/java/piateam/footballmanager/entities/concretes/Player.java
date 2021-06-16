package piateam.footballmanager.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "uniform_number")
	private String number;

	@ManyToOne
	@JoinColumn(name = "position_id", referencedColumnName = "id")
	private Position position;

	@ManyToOne
	@JoinColumn(name = "nationality_id", referencedColumnName = "id")
	private Nationality nationality;

	@ManyToOne
	@JoinColumn(name = "team_id", referencedColumnName = "id")
	private Team team;

}
