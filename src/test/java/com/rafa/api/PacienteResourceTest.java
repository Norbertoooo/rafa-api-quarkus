package com.rafa.api;

import com.rafa.api.domain.Paciente;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class )
public class PacienteResourceTest {

    @Test
    @Order(1)
    public void findAllPacienteTest() {
        given()
                .when().get("/pacientes")
                .then()
                .statusCode(200)
                .body(is(new ArrayList<Paciente>().toString()));
    }

    @Test
    @Order(2)
    public void savePacienteTest() {
        Paciente paciente = new Paciente("vitor");
        given()
                .contentType("application/json")
                .body(paciente)
                .when().post("/pacientes")
                .then()
                .statusCode(201);
    }

    @Test
    @Order(3)
    public void getPacienteByIdFailTest() {
        given()
                .when().get("/pacientes/2")
                .then()
                .statusCode(404);
    }

    @Test
    @Order(4)
    public void getPacienteByIdSucessTest() {
        given()
                .when().get("/pacientes/1")
                .then()
                .statusCode(200);
    }

    @Test
    @Order(5)
    public void updatePacienteTest() {

        Paciente paciente = new Paciente(1L,"vitor norberto");
        given()
                .contentType("application/json")
                .body(paciente)
                .when().put("/pacientes")
                .then()
                .statusCode(200);

    }

    @Test
    @Order(6)
    public void deletePacienteTest() {

        given()
                .when().delete("/pacientes/1")
                .then()
                .statusCode(200);
        given()
                .when().get("/pacientes/1")
                .then()
                .statusCode(404);
    }
}
