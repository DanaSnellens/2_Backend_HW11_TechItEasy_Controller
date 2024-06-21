package nl.novi.backend_hw11_techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.backend_hw11_techiteasy.dtos.output.CIModuleOutputDto;
import nl.novi.backend_hw11_techiteasy.models.CIModule;
import nl.novi.backend_hw11_techiteasy.services.CIModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ci-modules")
public class CIModuleController {
    private final CIModuleService ciModuleService;

    public CIModuleController(CIModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping
    public ResponseEntity<List<CIModuleOutputDto>> getAllCIModules() {
        return ResponseEntity.ok().body(ciModuleService.getAllTelevisions());
    }

/*    @GetMapping
    public ResponseEntity.............ResponseEntity*/

    @PostMapping
    public ResponseEntity<String> createCIModule(@Valid @RequestBody CIModuleOutputDto ciModuleOutputDto) {

    }
}
