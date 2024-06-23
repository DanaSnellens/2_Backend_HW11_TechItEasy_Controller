package nl.novi.backend_hw11_techiteasy.dtos.mapper;

import nl.novi.backend_hw11_techiteasy.dtos.input.CIModuleInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.output.CIModuleOutputDto;
import nl.novi.backend_hw11_techiteasy.models.CIModule;

public class CIModuleMapper {
    public static CIModule fromInputDtoToModel(CIModuleInputDto ciModuleInputDto) {
        CIModule c = new CIModule();
        c.setName(ciModuleInputDto.name);
        c.setType(ciModuleInputDto.type);
        c.setPrice(ciModuleInputDto.price);

        return c;
    }

    public static CIModuleOutputDto fromModelToOutputDto(CIModule ciModule) {
        CIModuleOutputDto ciModuleOutputDto = new CIModuleOutputDto();
        ciModuleOutputDto.setId(ciModule.getId());
        ciModuleOutputDto.setName(ciModule.getName());
        ciModuleOutputDto.setType(ciModule.getType());
        ciModuleOutputDto.setPrice(ciModule.getPrice());
        if (ciModule.getTelevision() != null) {
            ciModuleOutputDto.setTelevisionId(ciModule.getTelevision().getId());
        }

        return ciModuleOutputDto;
    }
}
