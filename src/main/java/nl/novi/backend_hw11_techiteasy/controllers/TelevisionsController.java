package nl.novi.backend_hw11_techiteasy.controllers;
import nl.novi.backend_hw11_techiteasy.exceptions.InvalidNameException;
import nl.novi.backend_hw11_techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend_hw11_techiteasy.models.Television;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {

    private ArrayList<Television> televisions = new ArrayList<Television>();

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        if (!televisions.isEmpty()) {
            return ResponseEntity.ok(televisions);
        }
        else {
            throw new RecordNotFoundException("No televisions found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <Television> getTelevisionById(@PathVariable int id) {
        if (id >= 0 && id < televisions.size()) {
            return ResponseEntity.ok(televisions.get(id));
        } else {
            throw new RecordNotFoundException("There is no tv with ID " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
        if (television.name.length() < 20) {
            televisions.add(television);
            return ResponseEntity.created(null).body(television);
        }
        else {
            throw new InvalidNameException("This name is too long. Name must be < 20 characters");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTv(@PathVariable int id, @RequestBody Television updatedTelevision) {
        if (id >= 0 && id < televisions.size()) {
            televisions.set(id, updatedTelevision);
            return ResponseEntity.ok(updatedTelevision);
        } else {
            throw new RecordNotFoundException("Id " + id + " is invalid");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTvById(@PathVariable int id) {
        if (id >= 0 && id < televisions.size()) {
            televisions.remove(id);
            return ResponseEntity.ok(id + " deleted");
        } else {
           throw new RecordNotFoundException("Id " + id + " is invalid");
        }
    }
}
