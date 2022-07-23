package az.developia.crmprojectelnur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.crmprojectelnur.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	@Query(value = "select * from tickets where customer_id=?1",nativeQuery = true)
	public List<Ticket> findAllByCustomerId(Integer customerId);

}
