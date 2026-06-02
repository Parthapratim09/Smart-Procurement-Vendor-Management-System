package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PurchaseOrderRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RequisitionRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepository;
    private final VendorRepository vendorRepository;
    private final RequisitionRepository requisitionRepository;

    // CREATE PO
    @Override
    public PurchaseOrder create(Long vendorId, Long requisitionId, Double totalAmount) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        Requisition requisition = requisitionRepository.findById(requisitionId)
                .orElseThrow(() -> new RuntimeException("Requisition not found"));

        PurchaseOrder po = new PurchaseOrder();
        po.setPoNumber("PO-" + System.currentTimeMillis());
        po.setStatus("CREATED");
        po.setOrderDate(LocalDate.now());
        po.setVendor(vendor);
        po.setRequisition(requisition);

        if (totalAmount != null) {
            po.setTotalAmount(totalAmount);
        }

        return poRepository.save(po);
    }

    // GET ALL
    @Override
    public List<PurchaseOrder> all() {
        return poRepository.findAll();
    }

    // GET BY ID
    @Override
    public Optional<PurchaseOrder> getById(Long id) {
        return poRepository.findById(id);
    }

    // GET BY REQUISITION
    @Override
    public List<PurchaseOrder> getByRequisition(Long id) {
        return poRepository.findByRequisitionId(id);
    }

    // DELETE
    @Override
    public void delete(Long id) {
        poRepository.deleteById(id);
    }

    // SEARCH
    @Override
    public List<PurchaseOrder> search(String keyword) {
        return poRepository.searchByKeyword(keyword);
    }
}