package org.dontpanic.primer.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class SsePushNotificationController {

    @Autowired
    private FluxBuilder<PrimeCandidate> primeCandidateFluxBuilder;

    @GetMapping(path = "/sse/notification", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "*")
    public Flux<String> latestNumberNotification() {
        return primeCandidateFluxBuilder.getFlux().map(numberEvent -> Integer.toString(numberEvent.getNumber()));
    }
}
