package ra.entity;

public class Laptop {
    private String laptopId;
    private String laptopName;
    private String description;
    private String customerAddress;
    private int ram;
    private double weight;
    private double laptopPrice;
    private String typeId;
    private boolean isDeleted;

    public Laptop() {
    }

    public Laptop(String laptopId, String laptopName, String description, String customerAddress, int ram, double weight, double laptopPrice, String typeId, boolean isDeleted) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
        this.description = description;
        this.customerAddress = customerAddress;
        this.ram = ram;
        this.weight = weight;
        this.laptopPrice = laptopPrice;
        this.typeId = typeId;
        this.isDeleted = false;
    }

    public Laptop(String laptopId, String laptopName, String description, String customerAddress, int ram, double laptopPrice, String typeId) {
    }

    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(double laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
