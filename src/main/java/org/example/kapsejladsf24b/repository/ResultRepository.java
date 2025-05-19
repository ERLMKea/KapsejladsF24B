package org.example.kapsejladsf24b.repository;

import org.example.kapsejladsf24b.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer> {

    List<Result> findResultByRaceRaceID(int raceId);
    List<Result> findResultBySailboatBoatID(int sailboatId);





}
