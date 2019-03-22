package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

  @Autowired private ItemRepository repository;

  public Item retreiveHardcodedItem() {

    return new Item(1, "Ball", 10, 100);
  }

  public List<Item> retrieveAllItems() {
    return repository.findAll();
  }
}
