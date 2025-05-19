package org.example.kapsejladsf24b.model;

import org.example.kapsejladsf24b.repository.RaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RaceTest {

    @Autowired
    RaceRepository raceRepository;

    @Test
    void getWednesdaysIn2025() {
        var obj = Stream.iterate(LocalDate.of(2025, 1, 1), date -> date.plusDays(1))
                .limit(365)
                .filter(date -> date.getDayOfWeek() == DayOfWeek.WEDNESDAY)
                .toList();
        System.out.println(obj.size());
    }

    @Test
    void getWednesdaysIn2025Save() {
        List<LocalDate> wdates = Stream.iterate(LocalDate.of(2025, 5, 1), date -> date.plusDays(1))
                .limit(365)
                .filter(date -> date.getDayOfWeek() == DayOfWeek.WEDNESDAY)
                .toList();
        System.out.println(wdates.size());

        Race race1 = new Race();
        race1.setBoatType(BoatType.LONGERTHAN40);
        Race race2 = new Race();
        race2.setBoatType(BoatType.FROM25TO40);
        Race race3 = new Race();
        race3.setBoatType(BoatType.SMALLERTHAN25);
        wdates.forEach(date -> {
            LocalDate dateStop = LocalDate.of(2025, 11, 1);
            if (date.compareTo(dateStop) < 0) {
                System.out.println(date);
                System.out.println(date.compareTo(dateStop));
                race1.setRaceStart(date);
                race1.setRaceID(0);
                raceRepository.save(race1);
                race2.setRaceStart(date);
                race2.setRaceID(0);
                raceRepository.save(race2);
                race3.setRaceStart(date);
                race3.setRaceID(0);
                raceRepository.save(race3);
            }
        });

    }



}