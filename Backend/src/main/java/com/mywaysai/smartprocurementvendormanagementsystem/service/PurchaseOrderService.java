package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;

public interface PurchaseOrderService {

    // CREATE
    PurchaseOrder create(Long vendorId, Long requisitionId, Double totalAmount);

    // READ ALL
    List<PurchaseOrder> all();

    // READ BY ID
    Optional<PurchaseOrder> getById(Long id);

    // READ BY REQUISITION
    List<PurchaseOrder> getByRequisition(Long id);

    // DELETE
    void delete(Long id);

    // SEARCH
    List<PurchaseOrder> search(String keyword);
}