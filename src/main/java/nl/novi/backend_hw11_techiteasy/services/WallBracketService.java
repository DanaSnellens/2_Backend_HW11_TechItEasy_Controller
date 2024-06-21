package nl.novi.backend_hw11_techiteasy.services;

import nl.novi.backend_hw11_techiteasy.dtos.input.WallBracketInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.mapper.WallBracketMapper;
import nl.novi.backend_hw11_techiteasy.dtos.output.WallBracketOutputDto;
import nl.novi.backend_hw11_techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend_hw11_techiteasy.models.WallBracket;
import nl.novi.backend_hw11_techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {
    private final WallBracketRepository wallBracketRepository;

    //Constructor injection
    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public WallBracketOutputDto createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wb = wallBracketRepository.save(WallBracketMapper.fromInputDtoToModel(wallBracketInputDto));
        return WallBracketMapper.fromModelToOutputDto(wb);
    }

    public List<WallBracketOutputDto> getAllWallBrackets() {
        List<WallBracket> allWallBrackets = wallBracketRepository.findAll();
        List<WallBracketOutputDto> allWallBracketsOutput = new ArrayList<>();
        for (WallBracket wb : allWallBrackets) {
            allWallBracketsOutput.add(WallBracketMapper.fromModelToOutputDto(wb));
        }
        return allWallBracketsOutput;
    }

    public WallBracketOutputDto getWallBracketById(Long id) {
        Optional<WallBracket> wb = wallBracketRepository.findById(id);
        if (wb.isPresent()) {
            return WallBracketMapper.fromModelToOutputDto(wb.get());
        } else {
            throw new RecordNotFoundException("No wallBracket found with id: " + id);
        }
    }

    public void deleteTvById(Long id) {
        Optional <WallBracket> wb = wallBracketRepository.findById(id);
        if (wb.isPresent()) {
            wallBracketRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No wallBracket found with id: " + id);
        }
    }

    public WallBracketOutputDto updateWallBracket(Long id, WallBracketInputDto updatedWallBracket) {
        Optional<WallBracket> wb = wallBracketRepository.findById(id);
        if (wb.isPresent()) {
            return WallBracketMapper.fromModelToOutputDto(wb.get());
        } else {
            throw new RecordNotFoundException("No wallBracket found with id: " + id);
        }
    }
}
