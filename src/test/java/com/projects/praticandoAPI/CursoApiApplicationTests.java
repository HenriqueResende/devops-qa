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


public class CursoApiApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testCreateCursoDefault() throws Exception{
    	final String expectedNome = "C++";
    	final double expectedNota = 0;
        final Boolean expectedFinalizado = true;
        
        mockMvc
            .perform(MockMvcRequestBuilders.post("/Cursos").contentType(MediaType.APPLICATION_JSON).content("{\n"
            		+ "  \"finalizado\": " + expectedFinalizado + ",\n"
            		+ "  \"nome\": \"" + expectedNome + "\",\n"
            		+ "  \"nota\":" + expectedNota
            		+ "}"))
            
            .andExpect(MockMvcResultMatchers.status().is(201))
            .andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
            .andExpect((ResultMatcher) jsonPath("finalizado").value(expectedFinalizado))
            .andExpect((ResultMatcher) jsonPath("nota").value(expectedNota));
    }
    
    @Test
    public void testGetCursoDefault() throws Exception{        
        mockMvc
            .perform(MockMvcRequestBuilders.get("/Cursos"))            
            .andExpect(MockMvcResultMatchers.status().isOk())          
            .andExpect(MockMvcResultMatchers.content().string("[{\"id\":1,\"nome\":\"Python\",\"nota\":8.0,\"finalizado\":true}]"));
    }
    
}
