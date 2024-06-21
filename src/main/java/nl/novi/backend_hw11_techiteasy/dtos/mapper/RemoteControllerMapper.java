package nl.novi.backend_hw11_techiteasy.dtos.mapper;

import nl.novi.backend_hw11_techiteasy.dtos.input.RemoteControllerInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.output.RemoteControllerOutputDto;
import nl.novi.backend_hw11_techiteasy.models.RemoteController;

public class RemoteControllerMapper {
    public static RemoteController fromInputDtoToModel(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController rc = new RemoteController();
        rc.setName(remoteControllerInputDto.name);
        rc.setBrand(remoteControllerInputDto.brand);
        rc.setPrice(remoteControllerInputDto.price);
        rc.setCompatibleWith(remoteControllerInputDto.compatibleWith);
        rc.setBatteryType(remoteControllerInputDto.batteryType);
        rc.setOriginalStock(remoteControllerInputDto.originalStock);

        return rc;
    }

    public static RemoteControllerOutputDto fromModelToOutputDto(RemoteController remoteController) {
        RemoteControllerOutputDto remoteControllerOutputDto = new RemoteControllerOutputDto();
        remoteControllerOutputDto.setId(remoteController.getId());
        remoteControllerOutputDto.setName(remoteController.getName());
        remoteControllerOutputDto.setBrand(remoteController.getBrand());
        remoteControllerOutputDto.setPrice(remoteControllerOutputDto.getPrice());
        remoteControllerOutputDto.setCompatibleWith(remoteControllerOutputDto.getCompatibleWith());
        remoteControllerOutputDto.setBatteryType(remoteControllerOutputDto.getBatteryType());

        return remoteControllerOutputDto;
    }
}
