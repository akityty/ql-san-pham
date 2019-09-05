package model;
public class Product {
  private int id;
  private String name;
  private float price;
  private String description;
  private String supplier;
  private String image;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public Product(int id, String name, float price, String description, String supplier, String image) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.supplier = supplier;
    this.image = image;
  }

  public Product() {
  }
}
