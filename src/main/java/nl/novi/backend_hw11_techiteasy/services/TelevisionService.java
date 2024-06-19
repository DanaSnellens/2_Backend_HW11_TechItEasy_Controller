package nl.novi.backend_hw11_techiteasy.services;

import nl.novi.backend_hw11_techiteasy.dtos.input.TelevisionInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.mapper.TelevisionMapper;
import nl.novi.backend_hw11_techiteasy.dtos.output.TelevisionOutputDto;
import nl.novi.backend_hw11_techiteasy.models.Television;
import nl.novi.backend_hw11_techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    //Constructor injection
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public TelevisionOutputDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television t = televisionRepository.save(TelevisionMapper.fromInputDtoToModel(televisionInputDto));
        return TelevisionMapper.fromModelToOutputDto(t);
    }
}
