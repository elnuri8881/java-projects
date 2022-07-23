package az.developia.crmprojectelnur.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	
	private Double price;
	
	@Column(name = "from_column")
	private String fromn;
	private String too;
	private LocalDate beginn;
	private LocalDate endd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getFromn() {
		return fromn;
	}
	public void setFromn(String fromn) {
		this.fromn = fromn;
	}
	public String getToo() {
		return too;
	}
	public void setToo(String too) {
		this.too = too;
	}
	public LocalDate getBeginn() {
		return beginn;
	}
	public void setBeginn(LocalDate beginn) {
		this.beginn = beginn;
	}
	public LocalDate getEndd() {
		return endd;
	}
	public void setEndd(LocalDate endd) {
		this.endd = endd;
	}
	 

}
