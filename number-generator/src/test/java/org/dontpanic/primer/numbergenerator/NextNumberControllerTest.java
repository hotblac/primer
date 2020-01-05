package org.dontpanic.primer.numbergenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = NextNumberController.class)
class NextNumberControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private NumberGenerator generator;

    @Test
    void start_startsNumberGenerator() throws Exception {
        mockMvc.perform(get("/start").param("startAt", "42"));
        verify(generator).start(42);
    }

    @Test
    void start_startsAtZeroByDefault() throws Exception {
        mockMvc.perform(get("/start"));
        verify(generator).start(0);
    }

    @Test
    void start_returnsOkResponse() throws Exception {
        mockMvc.perform(get("/start"))
                .andExpect(status().isOk());
    }

    @Test
    void stop_stopsNumberGenerator() throws Exception {
        mockMvc.perform(get("/stop"));
        verify(generator).stop();
    }

    @Test
    void stop_returnsOkResponse() throws Exception {
        mockMvc.perform(get("/stop"))
                .andExpect(status().isOk());
    }
}