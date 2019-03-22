package com.example.demo;

public class Item {
  private int id;
  private String name;
  private int price;
  private final int quantity;

  public Item(int id, String name, int price, int quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String toString() {
    return String.format("Item[%d,%s,%a,%d]", id, name, price, quantity);
  }
}
