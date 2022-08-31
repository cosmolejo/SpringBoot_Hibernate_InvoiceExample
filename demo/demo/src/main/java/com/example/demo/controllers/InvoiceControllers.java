package com.example.demo.controllers;

import com.example.demo.entities.Invoice;
import com.example.demo.entities.User;
import com.example.demo.services.InvoiceServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceControllers {

    InvoiceServices service;

    public InvoiceControllers(InvoiceServices services) {
        this.service = services;
    }

    @GetMapping("/invoice")
    public List<Invoice> getInvoices(){
        return this.service.getInvoices();
    }

    @GetMapping("/invoice/{id}")
    public Invoice getInvoice(@PathVariable("id") long id){
        return this.service.getInvoice(id);

    }

    @PostMapping("/invoice")
    public Invoice createInvoice(@RequestBody Invoice invoice){
        return  this.service.createInvoice(invoice);
    }

    @PutMapping("/invoice/{id}")
    public Invoice updateUser(@PathVariable("id") long id, @RequestBody Invoice invoice){
        return this.service.updateInvoice(id,invoice);
    }

    @DeleteMapping("/invoice/{id}")
    public Boolean deleteInvoice(@PathVariable("id") long id){
        return this.service.deleteInvoice(id);

    }

}
