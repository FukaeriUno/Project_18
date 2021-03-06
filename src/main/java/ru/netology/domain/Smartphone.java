package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
  private String manufacturer;

  public Smartphone() {
    super();
  }

  public Smartphone(int id, String name, int price, String manufacturer) {
    super(id, name, price);
    this.manufacturer = manufacturer;
  }

  public String getManufacturer() {
    return this.manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Smartphone smartphone = (Smartphone) o;
    return manufacturer == smartphone.manufacturer &&
            Objects.equals(this.getTitle(), smartphone.getTitle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), manufacturer);
  }

  @Override
  public String toString() {
    return "Smartphone{" +
        "name='" + this.getTitle() + '\'' +
        ", manufacturer=" + manufacturer +
        '}';
  }
}
