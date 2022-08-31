package com.example.demo.entities;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "document")
    private String document;
    @Column(name = "phone")
    private long phone;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)

    private List<Invoice> invoices;

    public User() {
    }

    public User(String name, String document, long phone) {
        this.name = name;
        this.document = document;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice){
        this.invoices.add(invoice);
        invoice.setUser(this);
    }

    public void removeInvoice(Invoice invoice){
        this.invoices.remove(invoice);
        invoice.setUser(null);
    }
}
