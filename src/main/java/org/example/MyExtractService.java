package org.example;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public final class MyExtractService {

    public Flux<Long> extract() {
        return Flux.interval(Duration.ofSeconds(1)); //Actual would be an aggressive flux from Kafka or http
    }

}
