package nl.novi.backend_hw11_techiteasy.dtos.mapper;

import nl.novi.backend_hw11_techiteasy.dtos.input.TelevisionInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.output.TelevisionOutputDto;
import nl.novi.backend_hw11_techiteasy.models.Television;

public class TelevisionMapper {
    public static Television fromInputDtoToModel(TelevisionInputDto televisionInputDto) {
        Television t = new Television();
        t.setType(televisionInputDto.type);
        t.setBrand(televisionInputDto.brand);
        t.setName(televisionInputDto.name);
        t.setPrice(televisionInputDto.price);
        t.setAvailableSize(televisionInputDto.availableSize);
        t.setRefreshRate(televisionInputDto.refreshRate);
        t.setScreenType(televisionInputDto.screenType);
        t.setScreenQuality(televisionInputDto.screenQuality);
        t.setSmartTv(televisionInputDto.smartTv);
        t.setWifi(televisionInputDto.wifi);
        t.setVoiceControl(televisionInputDto.voiceControl);
        t.setHdr(televisionInputDto.hdr);
        t.setBluetooth(televisionInputDto.bluetooth);
        t.setAmbiLight(televisionInputDto.ambiLight);
        t.setOriginalStock(televisionInputDto.originalStock);
        t.setSold(televisionInputDto.sold);

        return t;
    }

    public static TelevisionOutputDto fromModelToOutputDto(Television television) {
        TelevisionOutputDto televisionOutputDto = new TelevisionOutputDto();
        televisionOutputDto.setId(television.getId());
        televisionOutputDto.setType(television.getType());
        televisionOutputDto.setBrand(television.getBrand());
        televisionOutputDto.setName(television.getName());
        televisionOutputDto.setPrice(television.getPrice());
        televisionOutputDto.setAvailableSize(television.getAvailableSize());
        televisionOutputDto.setRefreshRate(television.getRefreshRate());
        televisionOutputDto.setScreenType(television.getScreenType());
        televisionOutputDto.setScreenQuality(television.getScreenQuality());
        televisionOutputDto.setSmartTv(television.getSmartTv());
        televisionOutputDto.setWifi(television.getWifi());
        televisionOutputDto.setVoiceControl(television.getVoiceControl());
        televisionOutputDto.setHdr(television.getHdr());
        televisionOutputDto.setBluetooth(television.getBluetooth());
        televisionOutputDto.setAmbiLight(television.getAmbiLight());

        return televisionOutputDto;
    }
}
