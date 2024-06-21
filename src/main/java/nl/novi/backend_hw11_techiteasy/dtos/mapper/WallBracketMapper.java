package nl.novi.backend_hw11_techiteasy.dtos.mapper;

import nl.novi.backend_hw11_techiteasy.dtos.input.WallBracketInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.output.WallBracketOutputDto;
import nl.novi.backend_hw11_techiteasy.models.WallBracket;

public class WallBracketMapper {
    public static WallBracket fromInputDtoToModel(WallBracketInputDto wallBracketInputDto) {
        WallBracket wb = new WallBracket();
        wb.setName(wallBracketInputDto.name);
        wb.setPrice(wallBracketInputDto.price);
        wb.setSize(wallBracketInputDto.size);
        wb.setAdjustable(wallBracketInputDto.adjustable);

        return wb;
    }

    public static WallBracketOutputDto fromModelToOutputDto(WallBracket wallBracket) {
        WallBracketOutputDto wallBracketOutputDto = new WallBracketOutputDto();
        wallBracketOutputDto.setId(wallBracket.getId());
        wallBracketOutputDto.setName(wallBracket.getName());
        wallBracketOutputDto.setPrice(wallBracket.getPrice());
        wallBracketOutputDto.setSize(wallBracket.getSize());
        wallBracketOutputDto.setAdjustable(wallBracket.getAdjustable());

        return wallBracketOutputDto;
    }
}
