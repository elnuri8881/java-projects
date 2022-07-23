package az.developia.crmprojectelnur.model;

import java.util.List;

public class CustomerDTO {
	
	private Integer id;
	private String name;
	private List<Ticket> tickets;
	
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
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	

}
