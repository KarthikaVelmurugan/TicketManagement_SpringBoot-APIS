package com.support.ticketManagement.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.support.ticketManagement.Models.TicketManagement;
import com.support.ticketManagement.Services.TicketManagementServices;

@RestController
@RequestMapping("api/otrs")
public class TicketManagementController {

	private TicketManagementServices ticketmanagementservice;


	public TicketManagementController(TicketManagementServices ticketmanagementservice) {
		super();
		this.ticketmanagementservice = ticketmanagementservice;
	}
	
	/* REST API for get All ticket Tickets */
	@GetMapping("/getAllTickets")
	List<TicketManagement> getAllTickets(){
		return ticketmanagementservice.getAllTickets();
	}
	
	/*Rest API for Create the new ticket */
	@PostMapping
	ResponseEntity<TicketManagement> createNewTicket(@RequestBody TicketManagement ticket) {
		return new ResponseEntity<TicketManagement>(ticketmanagementservice.createNewTicket(ticket),HttpStatus.CREATED);
	}
	
	/*Rest Api for get the ticket based on ticket number */
	@GetMapping("/getSprificTicket/{ticket_no}")
	ResponseEntity<TicketManagement> getSpecifyTicket(@PathVariable(name="ticket_no") long ticket_no) {
		return new ResponseEntity<TicketManagement>(ticketmanagementservice.getSpecificTicket(ticket_no),HttpStatus.OK);
		
	}
	
	/*Rest Api for get the ticket details based on the owner */
	
	@GetMapping("/getTicketInfoByOwner/{owner}")
	List<TicketManagement> getTicketsBasedOnOwner(@PathVariable(name="owner") String owner){
		return ticketmanagementservice.getTicketByOwner(owner);
	}
	
	
	/* REST API for update the ticket details based on the id */
	@PutMapping("/updateTicket/{ticket_no}")
	ResponseEntity<TicketManagement> updateTicket(@RequestBody TicketManagement tm,@PathVariable(name="ticket_no") long ticket_no){
		return new ResponseEntity<TicketManagement>(ticketmanagementservice.updateTicket(tm, ticket_no),HttpStatus.OK);
		
	}
	
	/*REST API for delete the data by Ticket Number */
	@DeleteMapping("/deleteTicket/{ticket_number}")

	ResponseEntity<String> deleteTicket(@PathVariable(name="ticket_number") long ticket_number) {
		ticketmanagementservice.deleteTicket(ticket_number);
		return new ResponseEntity<String>("Deleted Successfull",HttpStatus.OK);
	}
	
}

