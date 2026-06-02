package com.mywaysai.smartprocurementvendormanagementsystem.service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Delivery;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.DeliveryRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PurchaseOrderRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;

    // CREATE DELIVERY
    @Override
    public Delivery createDelivery(Long purchaseOrderId, String trackingNumber, String deliveryStatus) {

        PurchaseOrder po = purchaseOrderRepository.findById(purchaseOrderId)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found"));

        Delivery delivery = new Delivery();
        delivery.setTrackingNumber(trackingNumber);
        delivery.setDeliveryStatus(deliveryStatus);
        delivery.setPurchaseOrder(po);

        return deliveryRepository.save(delivery);
    }

    // GET ALL
    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    // TRACK DELIVERY
    public Delivery track(Delivery d) {
        return deliveryRepository.save(d);
    }

    // GET BY REQUISITION
    public List<Delivery> getByRequisition(Long requisitionId) {
        return deliveryRepository.findByPurchaseOrderRequisitionId(requisitionId);
    }
}