package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.service.PurchaseOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/po")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    // CREATE PO
    @PostMapping
    public PurchaseOrder create(@RequestParam Long vendorId,
                                @RequestParam Long requisitionId,
                                @RequestParam(required = false) Double totalAmount) {
        return service.create(vendorId, requisitionId, totalAmount);
    }

    // GET ALL
    @GetMapping
    public List<PurchaseOrder> all() {
        return service.all();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Optional<PurchaseOrder> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET BY REQUISITION ID
    @GetMapping("/requisition/{id}")
    public List<PurchaseOrder> getByRequisition(@PathVariable Long id) {
        return service.getByRequisition(id);
    }

    // SEARCH
    @GetMapping("/search")
    public List<PurchaseOrder> search(@RequestParam String keyword) {
        return service.search(keyword);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "PO deleted successfully";
    }
}