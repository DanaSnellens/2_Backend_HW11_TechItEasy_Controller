package nl.novi.backend_hw11_techiteasy.controllers;


import jakarta.validation.Valid;
import nl.novi.backend_hw11_techiteasy.dtos.input.TelevisionInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.output.TelevisionOutputDto;
import nl.novi.backend_hw11_techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend_hw11_techiteasy.models.Television;
import nl.novi.backend_hw11_techiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    // Constructor injection
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions() {
        return ResponseEntity.ok().body(televisionService.getAllTelevisions());
    }

    // Return 1 televisie met een specifiek id
    @GetMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevisionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(televisionService.getTvById(id));
    }

    @PostMapping
    public ResponseEntity<TelevisionOutputDto> addTelevision
            (@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionOutputDto tvOutput = televisionService.createTelevision(televisionInputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tvOutput.getId()).toUri();
        return ResponseEntity.created(uri).body(tvOutput);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteTvById(@PathVariable Long id) {
        televisionService.deleteTvById(id);

        // Return een 204 status
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> updateTv(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto updatedTelevision) {
        TelevisionOutputDto outputDto = televisionService.updateTv(id, updatedTelevision);
        return ResponseEntity.ok().body(outputDto);
    }
}

