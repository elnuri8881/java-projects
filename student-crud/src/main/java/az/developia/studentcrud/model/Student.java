package az.developia.studentcrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	
	@NotEmpty(message = "Bos qoymaq olmaz!")
	@Size(min=2,message = "Minimum 2 simvol yazılmalıdır")
	@Size(max=30,message = "Maxsimum 30 simvol yazılmalıdır")
private String name;
	
	@NotEmpty(message = "Bos qoymaq olmaz!")
	@Size(min=2,message = "Minimum 2 simvol yazılmalıdır")
	@Size(max=30,message = "Maxsimum 30 simvol yazılmalıdır")
private String surname;
	
	private String teacher;
	
	private String profilePhoto;
	
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
public String getTeacher() {
	return teacher;
}
public void setTeacher(String teacher) {
	this.teacher = teacher;
}
public String getProfilePhoto() {
	return profilePhoto;
}
public void setProfilePhoto(String profilePhoto) {
	this.profilePhoto = profilePhoto;
}



}
