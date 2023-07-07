package org.example;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MyTransformService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyTransformService.class);

    public Flux<String> transform(final Flux<Long> consumerRecordFlux) {
        return consumerRecordFlux.map(this::transform);
    }

    @Timed("findme")
    public String transform(final Long message) {
        LOGGER.info("HERE SHOULD BE A COMPLEX TRANSFORMATION WHICH CONVERTS AN INPUT TO AN OUTPUT, I WOULD LIKE TO COUNT AND TIME THIS OPERATION ONLY. THERE IS NO METRIC FINDME " + message);
        return message.toString();
    }

}
