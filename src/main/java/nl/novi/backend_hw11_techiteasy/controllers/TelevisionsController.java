package nl.novi.backend_hw11_techiteasy.controllers;
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
        if (tele)
        return ResponseEntity.ok(televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Television> getTelevisionById(@PathVariable int id) {
        if (id >= 0 && id < televisions.size()) {
            return ResponseEntity.ok(televisions.get(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
        televisions.add(television);
        return ResponseEntity.created(null).body(television);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTv(@PathVariable int id, @RequestBody Television updatedTelevision) {
        if (id >= 0 && id < televisions.size()) {
            televisions.set(id, updatedTelevision);
            return ResponseEntity.ok(updatedTelevision);
        } else {
            return ResponseEntity.badRequest().body("Id is invalid");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTvById(@PathVariable int id) {
        if (id >= 0 && id < televisions.size()) {
            televisions.remove(id);
            return ResponseEntity.ok(id + " deleted");
        } else {
            return ResponseEntity.badRequest().body("Id is invalid");
        }
    }
}
