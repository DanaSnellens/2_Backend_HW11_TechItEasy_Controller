package nl.novi.backend_hw11_techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.backend_hw11_techiteasy.dtos.input.WallBracketInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.output.WallBracketOutputDto;
import nl.novi.backend_hw11_techiteasy.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {
    private final WallBracketService wallBracketService;

    // Constructor injection
    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping
    public ResponseEntity<List<WallBracketOutputDto>> getAllWallBrackets() {
        return ResponseEntity.ok().body(wallBracketService.getAllWallBrackets());
    }

    // Return 1 televisie met een specifiek id
    @GetMapping("/{id}")
    public ResponseEntity<WallBracketOutputDto> getWallBracketById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(wallBracketService.getWallBracketById(id));
    }

    @PostMapping
    public ResponseEntity<WallBracketOutputDto> addWallBracket
            (@Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketOutputDto wallBracketOutput = wallBracketService.createWallBracket(wallBracketInputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(wallBracketOutput.getId()).toUri();
        return ResponseEntity.created(uri).body(wallBracketOutput);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWallBracketById(@PathVariable Long id) {
        wallBracketService.deleteWallBracketById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketOutputDto> updateWallBracket(@PathVariable Long id, @Valid @RequestBody WallBracketInputDto updatedWallBracket) {
        WallBracketOutputDto outputDto = wallBracketService.updateWallBracket(id, updatedWallBracket);
        return ResponseEntity.ok().body(outputDto);
    }
}
