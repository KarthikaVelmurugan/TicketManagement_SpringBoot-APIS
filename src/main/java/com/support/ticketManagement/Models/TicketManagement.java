package com.support.ticketManagement.Models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="otrs_tickets")
public class TicketManagement {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long ticket_number;
 
 @Column(name="customer_id",nullable = false)
 private String customer_id;
 
 @Column(name="tenant_id",nullable = false)
 private String tenant_id;
 
 @Column(name="owner",nullable = false)
 private String owner;
 
 @Column(name="status",nullable=true)
 private String status;
 
 @Column(name="product_fm",nullable=true)
 private String Product_FM;
 
 @Column(name = "created_at", columnDefinition = "timestamp default current_timestamp not null")
 private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
}
