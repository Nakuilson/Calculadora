package org.clases.integracion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OperacionesServicesTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSuma() throws Exception {
        mockMvc.perform(get(new StringBuilder("/operaciones/suma/").append(10).append("/").append(20).toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("30"));;
    }

    @Test
    void getResta() throws Exception {
        mockMvc.perform(get(new StringBuilder("/operaciones/resta/").append(10).append("/").append(20).toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("-10"));
    }
    @Test
    void getSumaConParametroNull() throws Exception {
        mockMvc.perform(get(new StringBuilder("/operaciones/suma/").append(10).append("/").append("").toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRestaConParametroNull() throws Exception {
        mockMvc.perform(get(new StringBuilder("/operaciones/resta/").append(10).append("/").append("").toString())
               .contentType(MediaType.APPLICATION_JSON)
               .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
