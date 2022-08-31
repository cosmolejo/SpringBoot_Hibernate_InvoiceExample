package com.example.demo.services;

import com.example.demo.entities.Invoice;
import com.example.demo.repositories.InvoiceRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServices {

    private InvoiceRepository invoiceRepository;
    private UserRepository userRepository;

    public InvoiceServices(InvoiceRepository invoiceRepository, UserRepository userRepository) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
    }

    public List<Invoice> getInvoices(){
        return this.invoiceRepository.findAll();
    }

    public Invoice getInvoice(Long id){
        Optional<Invoice> invoice = this.invoiceRepository.findById(id);
        return invoice.orElse(null);
    }

    public  Invoice createInvoice(Invoice invoice){
//        invoice.setUser(this.userRepository.findBy(invoice.getUser().getId()));
        return this.invoiceRepository.save(invoice);

    }


    public Invoice updateInvoice(Long id, Invoice invoice){
        Optional<Invoice> dbData = this.invoiceRepository.findById(id);

        if(dbData.isPresent()){
            Invoice e = dbData.get();
            e.setAmount(invoice.getAmount());
            e.setInvoiceDate(invoice.getInvoiceDate());
            e.setUser(invoice.getUser());
            this.invoiceRepository.save(e);
            return e;
        }

        return null;
    }

    public Boolean deleteInvoice(Long id){
        try{
            this.invoiceRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
