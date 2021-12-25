package com.support.ticketManagement.Services;

import java.util.List;

import com.support.ticketManagement.Models.TicketManagement;

public interface TicketManagementServices {

	//Get All Tickets
	List<TicketManagement> getAllTickets();
	//Get Specific Tickets
	TicketManagement getSpecificTicket(long ticket_number);
	//Get Tickets beased on owner assigned
	List<TicketManagement> getTicketByOwner(String owner);
	//Create the new ticket
	TicketManagement createNewTicket(TicketManagement ticket);
	//update the ticket
	TicketManagement updateTicket(TicketManagement tm,long ticket_number);
	//delete the ticket
	void deleteTicket(long ticket_number);
}
