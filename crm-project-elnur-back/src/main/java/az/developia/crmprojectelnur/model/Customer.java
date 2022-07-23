package az.developia.crmprojectelnur.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Boş qoymaq olmaz !!!")
	@Size(min = 2,message = "Minimum 2 simvol yazılmalıdır !")
	@Size(max = 30,message = "Maksimum 30 simvol yazılmalıdır !")
	private String name;
	
	@NotEmpty(message = "Boş qoymaq olmaz !!!")
	@Size(min = 2,message = "Minimum 2 simvol yazılmalıdır !")
	@Size(max = 30,message = "Maksimum 30 simvol yazılmalıdır !")
	private String surname;
	private String phone;
	private String email;
	private LocalDate birthday;
	private String description;
	private String adress;
	private String gender;
	private String idNumber;
	private String idFin;
	
	
	
	@ManyToOne
	@JoinColumn(name = "nationality_id")
	private Nationality nationality;
	
	

	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getIdFin() {
		return idFin;
	}
	public void setIdFin(String idFin) {
		this.idFin = idFin;
	}
	public Nationality getNationality() {
		return nationality;
	}
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
	
}
