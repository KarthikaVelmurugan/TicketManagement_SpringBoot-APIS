package com.support.ticketManagement.Services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.support.ticketManagement.Exceptions.ResourceNotFoundException;
import com.support.ticketManagement.Models.TicketManagement;
import com.support.ticketManagement.Repository.TicketManagementRepository;
import com.support.ticketManagement.Services.TicketManagementServices;

@Service
public class TicketManagementServicesImpl implements TicketManagementServices {

	private TicketManagementRepository ticketmanagementrepository;

	public TicketManagementServicesImpl(TicketManagementRepository ticketmanagementrepository) {
		super();
		this.ticketmanagementrepository = ticketmanagementrepository;
	}

	// Get all tickets
	@Override
	public List<TicketManagement> getAllTickets() {

		return ticketmanagementrepository.findAll();
	}

	// Create the new Ticket
	@Override
	public TicketManagement createNewTicket(TicketManagement ticket) {

		return ticketmanagementrepository.save(ticket);
	}
	// get speicific ticket based on ticket number

	@Override
	public TicketManagement getSpecificTicket(long ticket_number) {
		return ticketmanagementrepository.findById(ticket_number).orElseThrow(
				() -> new ResourceNotFoundException("Ticket Management", "Get Sepicific Ticket", ticket_number));
	}

	// Get The Ticket based on Owner
	@Override
	public List<TicketManagement> getTicketByOwner(String owner) {
		List<TicketManagement> getExistingAllTickets = ticketmanagementrepository.findAll();
		List<TicketManagement> newEntries = new ArrayList<TicketManagement>(30);

		long ticket_no = 0;
		int i;
		for (i = 0; i < getExistingAllTickets.size(); i++) {

			if (getExistingAllTickets.get(i).getOwner().equalsIgnoreCase(owner)) {

				ticket_no = getExistingAllTickets.get(i).getTicket_number();

				Optional<TicketManagement> m = ticketmanagementrepository.findById(ticket_no);
				if (m.isPresent()) {
					TicketManagement mm = m.get();
					System.out.println(mm.getTicket_number());

					newEntries.add(mm);
				}

			}

			// System.out.println(newEntries);

		}

		return newEntries;

	}

	// update the ticket details
	public TicketManagement updateTicket(TicketManagement m, long ticket_no) {
		TicketManagement existingTicket = ticketmanagementrepository.findById(ticket_no).orElseThrow(()->new ResourceNotFoundException("Ticket Management","Update failed",ticket_no));
	    existingTicket.setCustomer_id(m.getCustomer_id());
	    existingTicket.setOwner(m.getOwner());
	    existingTicket.setProduct_FM(m.getProduct_FM());
	    existingTicket.setStatus(m.getStatus());
	    existingTicket.setTenant_id(m.getTenant_id());
	    return existingTicket;
	
	}

	@Override
	public void deleteTicket(long ticket_number) {
	 TicketManagement tm = ticketmanagementrepository.findById(ticket_number).orElseThrow(()-> new ResourceNotFoundException("ticket management", "ID Not found", ticket_number));
	 ticketmanagementrepository.deleteById(tm.getTicket_number());
	}

}
