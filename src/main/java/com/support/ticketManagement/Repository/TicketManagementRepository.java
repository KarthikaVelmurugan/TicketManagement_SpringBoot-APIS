package com.support.ticketManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.support.ticketManagement.Models.TicketManagement;

public interface TicketManagementRepository extends JpaRepository<TicketManagement, Long>{

}
