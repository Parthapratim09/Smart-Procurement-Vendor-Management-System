package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Invoice;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.InvoiceRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PurchaseOrderRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final PurchaseOrderRepository poRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              PurchaseOrderRepository poRepository) {
        this.invoiceRepository = invoiceRepository;
        this.poRepository = poRepository;
    }

    // CREATE
    public Invoice create(Invoice request) {

        if (request.getPurchaseOrder() == null ||
                request.getPurchaseOrder().getId() == null) {
            throw new RuntimeException("Purchase Order ID required");
        }

        PurchaseOrder po = poRepository
                .findById(request.getPurchaseOrder().getId())
                .orElseThrow(() -> new RuntimeException("PO not found"));

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(request.getInvoiceNumber());
        invoice.setAmount(request.getAmount());
        invoice.setPurchaseOrder(po);

        return invoiceRepository.save(invoice);
    }

    // READ ALL
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    // READ BY ID
    public Invoice getById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    // UPDATE
    public Invoice update(Long id, Invoice invoice) {

        Invoice existing = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        existing.setAmount(invoice.getAmount());

        return invoiceRepository.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }
}