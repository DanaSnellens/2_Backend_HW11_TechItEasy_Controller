package nl.novi.backend_hw11_techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.backend_hw11_techiteasy.dtos.input.CIModuleInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.output.CIModuleOutputDto;
import nl.novi.backend_hw11_techiteasy.models.CIModule;
import nl.novi.backend_hw11_techiteasy.services.CIModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    public ResponseEntity<CIModuleOutputDto> getCIModuleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(ciModuleService.getCIModuleById(id));
    }

    @PostMapping
    public ResponseEntity<CIModuleOutputDto> addCIModule
            (@Valid @RequestBody CIModuleInputDto ciModuleInputDto) {
        CIModuleOutputDto ciModuleOutput = ciModuleService.createCIModule(ciModuleInputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ciModuleOutput.getId()).toUri();
        return ResponseEntity.created(uri).body(ciModuleOutput);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCIModuleById(@PathVariable Long id) {
        ciModuleService.deleteCiById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CIModuleOutputDto> updateCIModule(@PathVariable Long id, @Valid @RequestBody CIModuleInputDto updatedCIModule) {
        CIModuleOutputDto ciModuleOutputDto = ciModuleService.updateCi(id, updatedCIModule);
        return ResponseEntity.ok().body(ciModuleOutputDto);
    }
}
