package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
@JsonIgnoreProperties({"user"})
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "amount")
    private double amount;
    @Column(name = "invoiceDate")
    private LocalDate invoiceDate;

    public Invoice() {
    }

    public Invoice(long id, double amount, LocalDate invoiceDate) {
        this.id = id;
        this.amount = amount;
        this.invoiceDate = invoiceDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
