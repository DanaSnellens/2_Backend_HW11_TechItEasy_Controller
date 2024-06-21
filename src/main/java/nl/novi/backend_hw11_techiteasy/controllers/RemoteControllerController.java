package nl.novi.backend_hw11_techiteasy.controllers;

import jakarta.validation.Valid;
import nl.novi.backend_hw11_techiteasy.dtos.input.RemoteControllerInputDto;
import nl.novi.backend_hw11_techiteasy.dtos.output.RemoteControllerOutputDto;
import nl.novi.backend_hw11_techiteasy.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remoteControllers")
public class RemoteControllerController {
    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @GetMapping
    public ResponseEntity<List<RemoteControllerOutputDto>> getAllRemoteControllers() {
        return ResponseEntity.ok().body(remoteControllerService.getAllRemoteControllers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerOutputDto> getRemoteControllerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(remoteControllerService.getRemoteControllerById(id));
    }

    @PostMapping
    public ResponseEntity<RemoteControllerOutputDto> addRemoteController
            (@Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerOutputDto remoteControllerOutput = remoteControllerService.createRemoteController(remoteControllerInputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(remoteControllerOutput.getId()).toUri();
        return ResponseEntity.created(uri).body(remoteControllerOutput);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRemoteControllerById(@PathVariable Long id) {
        remoteControllerService.deleteRemoteControllerById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerOutputDto> updateRemoteController(@PathVariable Long id, @Valid @RequestBody RemoteControllerInputDto updatedRemoteController) {
        RemoteControllerOutputDto remoteControllerOutputDto = remoteControllerService.updateRemoteController(id, updatedRemoteController);
        return ResponseEntity.ok().body(remoteControllerOutputDto);
    }

}
