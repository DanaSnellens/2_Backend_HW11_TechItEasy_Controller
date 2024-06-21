package nl.novi.backend_hw11_techiteasy.models;

import jakarta.persistence.*;

@Entity
@Table (name = "RemoteControllers")
public class RemoteController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "remoteController")
    private Television television;

    private String name;
    private String brand;
    private Double price;
    private String compatibleWith;
    private String batteryType;
    private Integer originalStock;

    public RemoteController() {
    }
    public RemoteController(Long id, String name, String brand, Double price, String compatibleWith, String batteryType, Integer originalStock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.compatibleWith = compatibleWith;
        this.batteryType = batteryType;
        this.originalStock = originalStock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }
}
