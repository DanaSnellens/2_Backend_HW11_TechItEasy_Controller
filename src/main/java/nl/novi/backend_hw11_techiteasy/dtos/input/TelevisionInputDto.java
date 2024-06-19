package nl.novi.backend_hw11_techiteasy.dtos.input;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;

public class TelevisionInputDto {

    public Long id;
    public String type;
    public String brand;
    public String name;
    @Positive
    public Double price;
    public Double availableSize;
    public Double refreshRate;
    public String screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    @Positive
    public Integer originalStock;
    @Positive
    public Integer sold;
}
