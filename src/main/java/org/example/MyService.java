package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public final class MyService implements CommandLineRunner {

    @Autowired
    MyExtractService myExtractService;
    @Autowired
    MyTransformService myTransformService;

    @Override
    public void run(final String... args) {
        myTransformService.transform(
                myExtractService.extract())
                .subscribe();
    }

}
