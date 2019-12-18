package org.dontpanic.primer.numbergenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = NextNumberController.class)
class NextNumberControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private NumberGenerator generator;
    @MockBean private NumberSender sender;

    @Test
    void next_sendsNextNumber() throws Exception {
        when(generator.next()).thenReturn(42);
        mockMvc.perform(get("/next"));
        verify(sender).sendNumber(42);
    }

    @Test
    void next_returnsOkResponse() throws Exception {
        mockMvc.perform(get("/next"))
                .andExpect(status().isOk());
    }
}