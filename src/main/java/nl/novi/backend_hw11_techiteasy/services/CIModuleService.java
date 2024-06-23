package nl.novi.backend_hw11_techiteasy.services;

import nl.novi.backend_hw11_techiteasy.dtos.input.CIModuleInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.mapper.CIModuleMapper;
import nl.novi.backend_hw11_techiteasy.dtos.output.CIModuleOutputDto;
import nl.novi.backend_hw11_techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend_hw11_techiteasy.models.CIModule;
import nl.novi.backend_hw11_techiteasy.models.Television;
import nl.novi.backend_hw11_techiteasy.repositories.CIModuleRepository;
import nl.novi.backend_hw11_techiteasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CIModuleService {
    private final CIModuleRepository ciModuleRepository;
    private final TelevisionRepository televisionRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository, TelevisionRepository televisionRepository) {
        this.ciModuleRepository = ciModuleRepository;
        this.televisionRepository = televisionRepository;
    }


    public CIModuleOutputDto createCIModule(CIModuleInputDto ciModuleInputDto) {
        CIModule ci = ciModuleRepository.save(CIModuleMapper.fromInputDtoToModel(ciModuleInputDto));
        return CIModuleMapper.fromModelToOutputDto(ci);
    }
    public List<CIModuleOutputDto> getAllCIModules() {
        List<CIModule> allCIModules = ciModuleRepository.findAll();
        List<CIModuleOutputDto> allCIModuleOutputDtos = new ArrayList<>();

        for (CIModule ciModule : allCIModules) {
            allCIModuleOutputDtos.add(CIModuleMapper.fromModelToOutputDto(ciModule));
        }
        return allCIModuleOutputDtos;
    }

    public CIModuleOutputDto getCIModuleById(Long id) {
        Optional<CIModule> ci = ciModuleRepository.findById(id);
        if (ci.isPresent()) {
            return CIModuleMapper.fromModelToOutputDto(ci.get());
        } else {
            throw new RecordNotFoundException("No CI-module found with id: " + id);
        }
    }

    public void deleteCiById(Long id) {
        Optional <CIModule> ci = ciModuleRepository.findById(id);
        if (ci.isPresent()) {
            ciModuleRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No CI-module found with id: " + id);
        }
    }

    public CIModuleOutputDto updateCi(Long id, CIModuleInputDto updatedCI) {
        Optional<CIModule> ci = ciModuleRepository.findById(id);
        if (ci.isPresent()) {
            return CIModuleMapper.fromModelToOutputDto(ci.get());
        } else {
            throw new RecordNotFoundException("No CI-module found with id: " + id);
        }
    }

    public void linkCiModuleAndTv(long ciModuleId, long tvId) {
        Optional<CIModule> ciModuleOptional = ciModuleRepository.findById(ciModuleId);
        Optional<Television> tvOptional = televisionRepository.findById(tvId);

        if (ciModuleOptional.isPresent() && tvOptional.isPresent()) {
            CIModule ciModule = ciModuleOptional.get();
            Television television = tvOptional.get();

            ciModule.setTelevision(television);
            ciModuleRepository.save(ciModule);
        } else {
            throw new RecordNotFoundException("Een van de id's bestaat niet");
        }
    }
}
