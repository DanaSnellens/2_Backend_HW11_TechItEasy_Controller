package nl.novi.backend_hw11_techiteasy.services;


import nl.novi.backend_hw11_techiteasy.dtos.input.RemoteControllerInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.mapper.RemoteControllerMapper;
import nl.novi.backend_hw11_techiteasy.dtos.output.RemoteControllerOutputDto;
import nl.novi.backend_hw11_techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend_hw11_techiteasy.models.RemoteController;
import nl.novi.backend_hw11_techiteasy.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {
    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public RemoteControllerOutputDto createRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController rc = remoteControllerRepository.save(RemoteControllerMapper.fromInputDtoToModel(remoteControllerInputDto));
        return RemoteControllerMapper.fromModelToOutputDto(rc);
    }
    public List<RemoteControllerOutputDto> getAllRemoteControllers() {
        List<RemoteController> allRemoteControllers = remoteControllerRepository.findAll();
        List<RemoteControllerOutputDto> allRemoteControllerOutputDtos = new ArrayList<>();

        for (RemoteController remoteController : allRemoteControllers) {
            allRemoteControllerOutputDtos.add(RemoteControllerMapper.fromModelToOutputDto(remoteController));
        }
        return allRemoteControllerOutputDtos;
    }

    public RemoteControllerOutputDto getRemoteControllerById(Long id) {
        Optional<RemoteController> rc = remoteControllerRepository.findById(id);
        if (rc.isPresent()) {
            return RemoteControllerMapper.fromModelToOutputDto(rc.get());
        } else {
            throw new RecordNotFoundException("No CI-module found with id: " + id);
        }
    }

    public void deleteRemoteControllerById(Long id) {
        Optional <RemoteController> rc = remoteControllerRepository.findById(id);
        if (rc.isPresent()) {
            remoteControllerRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No CI-module found with id: " + id);
        }
    }

    public RemoteControllerOutputDto updateRemoteController(Long id, RemoteControllerInputDto updatedRemoteController) {
        Optional<RemoteController> rc = remoteControllerRepository.findById(id);
        if (rc.isPresent()) {
            return RemoteControllerMapper.fromModelToOutputDto(rc.get());
        } else {
            throw new RecordNotFoundException("No CI-module found with id: " + id);
        }
    }
}


