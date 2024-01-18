package com.example.compshop.model;

import java.util.Optional;

import javax.persistence.*;


@Entity
@Table(name="computers")
public class ComputerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;

	private String brand;
	
	private String model;
	
	private Integer price;
	
	private String description;
	
	private Boolean is_new;
	@Column(length = 100000)
	private String image;
	
	private Integer memory;
	
	private String cpu;
	
	private Integer drive_memory;
	
	
	

	public ComputerModel(Integer id, String brand, String model, Integer price, String description, Boolean is_new,
			String image, Integer memory, String cpu, Integer drive_memory, String username) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.description = description;
		this.is_new = is_new;
		this.image = image;
		this.memory = memory;
		this.cpu = cpu;
		this.drive_memory = drive_memory;
		this.username = username;
		
	}

	public ComputerModel() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIs_new() {
		return is_new;
	}

	public void setIs_new(Boolean is_new) {
		this.is_new = is_new;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getMemory() {
		return memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public Integer getDrive_memory() {
		return drive_memory;
	}

	public void setDrive_memory(Integer drive_memory) {
		this.drive_memory = drive_memory;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ComputerModel [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price
				+ ", description=" + description + ", is_new=" + is_new + ", image=" + image + ", memory=" + memory
				+ ", cpu=" + cpu + ", drive_memory=" + drive_memory  + "]";
	}
	
	
	
	
}
