package org.example.kapsejladsf24b.controller;

import org.example.kapsejladsf24b.model.Sailboat;
import org.example.kapsejladsf24b.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sailboats")
public class SailboatRestController {

    @Autowired
    SailboatRepository sailboatRepository;

    @GetMapping("")
    public List<Sailboat> allDataRod() {
        return new ArrayList<>();
        //return sailboatRepository.findAll();
    }

    @GetMapping("/")
    public List<Sailboat> allData() {
        return sailboatRepository.findAll();
    }

    @PutMapping("/x/{id}")
    public ResponseEntity<Sailboat> updateSailboatx(@PathVariable int id, @RequestBody Sailboat sailboat) {
        Optional<Sailboat> sailboat1 = sailboatRepository.findById(id);
        if (sailboat1.isPresent()) {
            sailboat.setBoatID(sailboat1.get().getBoatID());
            sailboatRepository.save(sailboat);
            return new ResponseEntity<>(sailboat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Sailboat(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sailboat> updateSailboat(@PathVariable int id, @RequestBody Sailboat sailboat) {
        return sailboatRepository.findById(id)
                .map(existingSailboat -> {
                    sailboat.setBoatID(existingSailboat.getBoatID()); // Ensure ID is preserved
                    Sailboat updatedSailboat = sailboatRepository.save(sailboat);
                    return ResponseEntity.ok(updatedSailboat);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    


}
