package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;

public interface ItemService {

    // CREATE
    Item add(Item item);

    // READ ALL
    List<Item> list();

    // READ BY ID
    Item getById(Long id);

    // UPDATE
    Item update(Long id, Item item);

    // DELETE
    void delete(Long id);
}