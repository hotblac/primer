package org.dontpanic.primer.display;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class SsePushNotificationController {

    private final Logger logger = LoggerFactory.getLogger(SsePushNotificationController.class);

    private final FluxBuilder<PrimeCandidate> primeCandidateFluxBuilder;
    private final ObjectMapper jsonMapper;

    public SsePushNotificationController(FluxBuilder<PrimeCandidate> primeCandidateFluxBuilder, ObjectMapper jsonMapper) {
        this.primeCandidateFluxBuilder = primeCandidateFluxBuilder;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping(path = "/sse/notification", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "*")
    public Flux<String> latestNumberNotification() {
        return primeCandidateFluxBuilder.getFlux().map(this::toJson);
    }

    private String toJson(PrimeCandidate pc) {
        try {
            return jsonMapper.writeValueAsString(pc);
        } catch (JsonProcessingException e) {
            logger.error("Failed to convert PrimeCandiate to JSON string", e);
            return "";
        }
    }
}
