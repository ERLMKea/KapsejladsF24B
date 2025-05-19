package org.example.kapsejladsf24b.config;

import org.example.kapsejladsf24b.model.BoatType;
import org.example.kapsejladsf24b.model.Sailboat;
import org.example.kapsejladsf24b.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitData implements CommandLineRunner {

    @Autowired
    SailboatRepository sailboatRepository;

    @Override
    public void run(String... args) throws Exception {

        Sailboat sailboat = new Sailboat();
        sailboat.setBoatType(BoatType.LONGERTHAN40);
        sailboat.setName("F24");
        sailboatRepository.save(sailboat);

        Sailboat sailboat2 = new Sailboat();
        sailboat2.setBoatType(BoatType.SMALLERTHAN25);
        sailboat2.setName("Bæveren");
        sailboatRepository.save(sailboat2);

        Sailboat sailboat3 = new Sailboat();
        sailboat3.setBoatType(BoatType.FROM25TO40);
        sailboat3.setName("Blå Svane");
        sailboatRepository.save(sailboat3);

    }
}
