package nl.novi.backend_hw11_techiteasy.services;

import nl.novi.backend_hw11_techiteasy.dtos.output.CIModuleOutputDto;
import nl.novi.backend_hw11_techiteasy.models.CIModule;
import nl.novi.backend_hw11_techiteasy.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CIModuleService {
    private final CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CIModuleOutputDto> getAllCIModules() {
        List<CIModule> ciModules = ciModuleRepository.findAll();
        List<CIModuleOutputDto> ciModuleOutputDtos = new ArrayList<>();

        for (CIModule ciModule : ciModules) {
            CIModuleOutputDto outputDto = transferToDto(ciModule);
            ciModules.add(outputDto);
        }
        return ciModuleOutputDtos;
    }

    public CIModuleOutputDto  transferToDto(CIModule ciModule) {
        CIModuleOutputDto outputDto = new CIModuleOutputDto();
        return outputDto;
    }

    public CIModuleOutputDto addCIModule(CIModuleOutputDto outputDto) {
        CIModule ciModule = transferTo
    }
}
