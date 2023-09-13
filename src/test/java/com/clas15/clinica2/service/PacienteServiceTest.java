package com.clas15.clinica2.service;

import com.clas15.clinica2.model.PacienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
//@RunWith(SpringRunner.class)
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;
    @Test
    public void testCrearPaciente(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        PacienteDTO.setNombre("Eliana");
        PacienteDTO.setApellido("Osorio");
        pacienteService.crearPaciente(pacienteDTO);
        PacienteDTO pacienteEliana = pacienteService.leerPaciente(1);

        assertTrue(pacienteEliana != null);
    }

}