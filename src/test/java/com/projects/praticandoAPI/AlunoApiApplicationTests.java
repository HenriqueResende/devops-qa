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


public class AlunoApiApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testCreateAlunoDefault() throws Exception{
    	final String expectedNome = "Lando Norris";
        mockMvc
            .perform(MockMvcRequestBuilders.post("/Aluno").contentType(MediaType.APPLICATION_JSON).content("{\n"
            		+ "  \"cursos\": [\n"
            		+ "    \"Python\"\n"
            		+ "  ],\n"
            		+ "  \"nome\": \"" + expectedNome + "\"\n"
            		+ "}"))
            .andExpect(MockMvcResultMatchers.status().is(201))
            .andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
            .andExpect((ResultMatcher) jsonPath("$.cursos[0].id").value("1"))
            .andExpect((ResultMatcher) jsonPath("$.cursos[0].nome").value("Python"))
            .andExpect((ResultMatcher) jsonPath("$.cursos[0].nota").value("8.0"))
            .andExpect((ResultMatcher) jsonPath("$.cursos[0].finalizado").value("true"));
    }
    
    @Test
    public void testGetAlunoDefault() throws Exception{        
        mockMvc
            .perform(MockMvcRequestBuilders.get("/Aluno"))            
            .andExpect(MockMvcResultMatchers.status().isOk())          
            .andExpect(MockMvcResultMatchers.content().string("[{\"id\":1,\"nome\":\"Lando Norris\",\"cursos\":[{\"id\":1,\"nome\":\"Python\",\"nota\":8.0,\"finalizado\":true}]}]"));
    }
    
}
