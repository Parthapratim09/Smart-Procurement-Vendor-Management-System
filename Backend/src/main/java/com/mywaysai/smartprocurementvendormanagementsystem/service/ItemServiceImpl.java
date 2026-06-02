package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    // CREATE
    @Override
    public Item add(Item item) {
        return repository.save(item);
    }

    // READ ALL
    @Override
    public List<Item> list() {
        return repository.findAll();
    }

    // READ BY ID
    @Override
    public Item getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found: " + id));
    }

    // UPDATE
    @Override
    public Item update(Long id, Item updated) {
        Item existing = getById(id);
        existing.setItemName(updated.getItemName());
        existing.setCategory(updated.getCategory());
        existing.setUnitPrice(updated.getUnitPrice());
        return repository.save(existing);
    }

    // DELETE
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}