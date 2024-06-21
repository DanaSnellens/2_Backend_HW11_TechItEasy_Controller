package nl.novi.backend_hw11_techiteasy.models;

import jakarta.persistence.*;

@Entity
@Table (name = "WallBrackets")
public class WallBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String size;
    private Boolean adjustable;

    public WallBracket() {
    }

    public WallBracket(Long id, String name, Double price, String size, Boolean adjustable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.adjustable = adjustable;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }
}
