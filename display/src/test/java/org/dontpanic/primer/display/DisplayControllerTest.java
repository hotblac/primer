package org.dontpanic.primer.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Flux;

import static org.dontpanic.primer.display.DisplayController.DISPLAY_VIEW;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DisplayController.class)
class DisplayControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private FluxBuilder<PrimeCandidate> primeCandidateFluxBuilder;

    @BeforeEach
    void setUp() {
        when(primeCandidateFluxBuilder.getFlux())
                .thenReturn(Flux.empty());
    }

    @Test
    void index_displaysMainView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name(DISPLAY_VIEW));
    }
}