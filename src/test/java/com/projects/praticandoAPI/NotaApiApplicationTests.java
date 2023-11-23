package com.projects.praticandoAPI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.projects.praticandoAPI"})
@SpringBootTest
@AutoConfigureMockMvc


public class NotaApiApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testCreateNotaDefault() throws Exception{
    	final String expectedNome = "Python";
    	final double expectedNota = 10;
        final Boolean expectedFinalizado = true;
        
        mockMvc
            .perform(MockMvcRequestBuilders.post("/Nota").contentType(MediaType.APPLICATION_JSON).content("{\n"
            		+ "  \"nomeCurso\": \"" + expectedNome + "\",\n"
            		+ "  \"nota\": " + expectedNota + "\n"
            		+ "}"))
            
            .andExpect(MockMvcResultMatchers.status().is(201))
            .andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
            .andExpect((ResultMatcher) jsonPath("finalizado").value(expectedFinalizado))
            .andExpect((ResultMatcher) jsonPath("nota").value(expectedNota));
    }
    
    @Test
    public void testGetNotaDefault() throws Exception{        
        mockMvc
            .perform(MockMvcRequestBuilders.get("/Nota?nomeCurso=Python"))            
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect((ResultMatcher) jsonPath("nota").value("8.0"))
            .andExpect((ResultMatcher) jsonPath("nomeCurso").value("Python"));
    }
    
}
