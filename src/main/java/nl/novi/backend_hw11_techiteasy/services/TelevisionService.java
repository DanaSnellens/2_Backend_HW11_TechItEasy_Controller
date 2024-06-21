package nl.novi.backend_hw11_techiteasy.services;

import nl.novi.backend_hw11_techiteasy.dtos.input.TelevisionInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.mapper.TelevisionMapper;
import nl.novi.backend_hw11_techiteasy.dtos.output.TelevisionOutputDto;
import nl.novi.backend_hw11_techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend_hw11_techiteasy.models.Television;
import nl.novi.backend_hw11_techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public List<TelevisionOutputDto> getAllTelevisions() {
        //Alle tvs ophalen uit database
        List<Television> allTvs = televisionRepository.findAll();
        List<TelevisionOutputDto> allTvsOutput = new ArrayList<>();
        for (Television t : allTvs) {
            allTvsOutput.add(TelevisionMapper.fromModelToOutputDto(t));
        }
        return allTvsOutput;
    }

    public TelevisionOutputDto getTvById(Long id) {
        Optional<Television> t = televisionRepository.findById(id);
        if (t.isPresent()) {
            return TelevisionMapper.fromModelToOutputDto(t.get());
        } else {
            throw new RecordNotFoundException("No television found with id: " + id);
        }
    }

    public void deleteTvById(Long id) {
        Optional <Television> t = televisionRepository.findById(id);
        if (t.isPresent()) {
            televisionRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No television found with id: " + id);
        }
    }

    public TelevisionOutputDto updateTv(Long id, TelevisionInputDto updatedTelevision) {
        Optional<Television> t = televisionRepository.findById(id);
        if (t.isPresent()) {
            return TelevisionMapper.fromModelToOutputDto(t.get());
        } else {
            throw new RecordNotFoundException("Geen televisie gevonden met id: " + id);
        }
    }
}