package nl.novi.backend_hw11_techiteasy.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CIModules")
public class CIModule {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Television television;

    private String name;
    private String type;
    private Double price;

    public CIModule() {
    }
    public CIModule(long id, Television television, String name, String type, Double price) {
        this.id = id;
        this.television = television;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
