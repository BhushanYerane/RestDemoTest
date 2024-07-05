package coreJavaz.oopz;

class Electronics extends Product {
    private String brand;

    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
      //  return "Electronics [brand=" + brand + ", name=" + getName() + ", price=" + getPrice() + "]";
        return "Electronics [" + "brand=" + brand + ", " + super.toString() + "]";
    }
}

