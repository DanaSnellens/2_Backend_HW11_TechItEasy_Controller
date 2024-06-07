package nl.novi.backend_hw11_techiteasy.controllers;
import nl.novi.backend_hw11_techiteasy.exceptions.TelevisionNameTooLongException;
import nl.novi.backend_hw11_techiteasy.exceptions.RecordNotFoundException;
import nl.novi.backend_hw11_techiteasy.models.Television;
import nl.novi.backend_hw11_techiteasy.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    // Vorige week maakten we nog gebruik van een List<String>, nu gebruiken we de repository met een echte database.
    // We injecteren de repository hier via de constructor, maar je mag ook @Autowired gebruiken.
    private final TelevisionRepository televisionRepository;

    // Constructor injection
    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    // We hebben hier de RequestParam "brand" toegevoegd om te laten zien hoe dat werkt.
    // Als de gebruiker een brand invult, dan zoeken we op brand, anders returnen we alle televisions.
    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {

        List<Television> televisions;

        if (brand == null) {
            // Vul de televisions lijst met alle televisions
            televisions = televisionRepository.findAll();
        } else {
            // Vul de televisions lijst met alle television die een bepaald brand hebben
            televisions = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        }


        // Return de televisions lijst en een 200 status
        return ResponseEntity.ok().body(televisions);
    }

    // Return 1 televisie met een specifiek id
    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable("id") Long id) {

        // Haal de television met het gegeven id uit de database.
        // Het Optional datatype betekent "wel of niet". Als er geen television gevonden wordt, dan is de Optional empty,
        // maar als er wel een television gevonden wordt, dan staat de television in de Optional en kun je deze er uit
        // halen met de get-methode. Op deze manier krijg je niet meteen een error als de tv niet in de database voorkomt.
        // Je kunt dat probleem zelf oplossen. In dit geval doen we dat door een RecordNotFoundException op te gooien met een message.
        Optional<Television> television = televisionRepository.findById(id);

        // Check of de optional empty is. Het tegenovergestelde alternatief is "television.isPresent()"
        if (television.isEmpty()) {
            // Als er geen television in de optional staat, roepen we hier de RecordNotFoundException constructor aan met message.
            throw new RecordNotFoundException("No television found with id: " + id);
        } else {
            // Als er wel een television in de optional staat, dan halen we die uit de optional met de get-methode.
            Television television1 = television.get();

            // Return de television en een 200 status
            return ResponseEntity.ok().body(television1);
        }
    }

    // We geven hier een television mee in de parameter. Zorg dat je JSON object exact overeenkomt met het Television object.
    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
        // Sla de nieuwe tv in de database op met de save-methode van de repository
        Television returnTelevision = televisionRepository.save(television);

        // Return de gemaakte television en een 201 status
        return ResponseEntity.created(null).body(returnTelevision);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteTvById(@PathVariable("id") Long id) {
        // Verwijder de television met het opgegeven id uit de database.
        televisionRepository.deleteById(id);

        // Return een 204 status
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTv(@PathVariable Long id, @RequestBody Television updatedTelevision) {

        //Haal de aan te passen tv uit de database met het gegeven id
        Optional<Television> television = televisionRepository.findById(id);

        //Als eerste checken we of de aan te passen tv wel in de database bestaat
        if (television.isEmpty()) {
            throw new RecordNotFoundException("No television found with id: " + id);
        } else {
            //Verander alle waardes van de television uit de database naar de waardes van de television uit de parameters
            // Behalve de id, als je de id verandert, dan wordt er een nieuw object aangemaakt in de database
            Television television1 = television.get();
            television1.setAmbiLight(updatedTelevision.getAmbiLight());
            television1.setAvailableSize(updatedTelevision.getAvailableSize());
            television1.setAmbiLight(updatedTelevision.getAmbiLight());
            television1.setBluetooth(updatedTelevision.getBluetooth());
            television1.setBrand(updatedTelevision.getBrand());
            television1.setHdr(updatedTelevision.getHdr());
            television1.setName(updatedTelevision.getName());
            television1.setOriginalStock(updatedTelevision.getOriginalStock());
            television1.setPrice(updatedTelevision.getPrice());
            television1.setRefreshRate(updatedTelevision.getRefreshRate());
            television1.setScreenQuality(updatedTelevision.getScreenQuality());
            television1.setScreenType(updatedTelevision.getScreenType());
            television1.setSmartTv(updatedTelevision.getSmartTv());
            television1.setSold(updatedTelevision.getSold());
            television1.setType(updatedTelevision.getType());
            television1.setVoiceControl(updatedTelevision.getVoiceControl());
            television1.setWifi(updatedTelevision.getWifi());

            // Sla de gewijzigde waarden op in de database onder dezelfde id. Dit moet je NIET VERGETEN
            Television returnTelevision = televisionRepository.save(television1);

            //Return de nieuwe versie van deze tv en een 200 code
            return ResponseEntity.ok().body(returnTelevision);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Television> updatePartialTelevision(@PathVariable Long id, @RequestBody Television updatedTelevision) {
        Optional<Television> television = televisionRepository.findById(id);

        if (television.isEmpty()) {
            throw new RecordNotFoundException("No television found with id: " + id);
        } else {
            // Het verschil tussen een patch en een put methode is dat een put een compleet object update,
            // waar een patch een gedeeltelijk object kan updaten.
            // Zet alles in een null-check, om te voorkomen dat je per ongeluk bestaande waardes overschrijft met null-waardes.
            // Intellij heeft een handige postfix voor null-checks. Dit doe je door bijvoorbeeld "newTelevision.getBrand().notnull" te typen en dan op tab te drukken.

            Television television1 = television.get();

            if (updatedTelevision.getAmbiLight() != null) {
                television1.setAmbiLight(updatedTelevision.getAmbiLight());
            }
            if (updatedTelevision.getAvailableSize() != null) {
                television1.setAvailableSize(updatedTelevision.getAvailableSize());
            }
            if (updatedTelevision.getBluetooth() != null) {
                television1.setBluetooth(updatedTelevision.getBluetooth());
            }
            if (updatedTelevision.getBrand() != null) {
                television1.setBrand(updatedTelevision.getBrand());
            }
            if (updatedTelevision.getHdr() != null) {
                television1.setHdr(updatedTelevision.getHdr());
            }
            if (updatedTelevision.getName() != null) {
                television1.setName(updatedTelevision.getName());
            }
            if (updatedTelevision.getOriginalStock() != null) {
                television1.setOriginalStock(updatedTelevision.getOriginalStock());
            }
            if (updatedTelevision.getPrice() != null) {
                television1.setPrice(updatedTelevision.getPrice());
            }
            if (updatedTelevision.getRefreshRate() != null) {
                television1.setRefreshRate(updatedTelevision.getRefreshRate());
            }
            if (updatedTelevision.getScreenQuality() != null) {
                television1.setScreenQuality(updatedTelevision.getScreenQuality());
            }
            if (updatedTelevision.getScreenType() != null) {
                television1.setScreenType(updatedTelevision.getScreenType());
            }
            if (updatedTelevision.getSmartTv() != null) {
                television1.setSmartTv(updatedTelevision.getSmartTv());
            }
            if (updatedTelevision.getSold() != null) {
                television1.setSold(updatedTelevision.getSold());
            }
            if (updatedTelevision.getType() != null) {
                television1.setType(updatedTelevision.getType());
            }
            if (updatedTelevision.getVoiceControl() != null) {
                television1.setVoiceControl(updatedTelevision.getVoiceControl());
            }
            if (updatedTelevision.getWifi() != null) {
                television1.setWifi(updatedTelevision.getWifi());
            }

            Television returnTelevision = televisionRepository.save(television1);
            return ResponseEntity.ok().body(returnTelevision);
        }
    }
}
