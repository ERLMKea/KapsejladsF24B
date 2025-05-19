package org.example.kapsejladsf24b.controller;

import org.example.kapsejladsf24b.model.Result;
import org.example.kapsejladsf24b.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultRestController {

    @Autowired
    ResultRepository resultRepository;

    @GetMapping("")
    public List<Result> allResultsRod() {
        return resultRepository.findAll();
    }

    @GetMapping("/")
    public List<Result> allResults() {
        return resultRepository.findAll();
    }

    @GetMapping("/raceid/{id}")
    public List<Result> getResultsByRaceId(@PathVariable String id) {
        int i1 = Integer.parseInt(id);
        return resultRepository.findResultByRaceRaceID(i1);
        //return resultService.getResultsByRaceId(id);
    }

    @GetMapping("/boatid/{id}")
    public List<Result> getResultsByBoatId(@PathVariable String id) {
        int i1 = Integer.parseInt(id);
        return resultRepository.findResultBySailboatBoatID(i1);
    }

    @PostMapping("/")
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        Result savedResult = resultRepository.save(result);
        URI location = URI.create("/results/" + savedResult.getResultID());
        return ResponseEntity.created(location).body(savedResult);
    }


}


