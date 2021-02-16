package com.rafa.api.web;

import com.rafa.api.domain.Paciente;
import com.rafa.api.exceptionHandler.NotFoundException;
import com.rafa.api.service.PacienteService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pacientes")
public class PacienteResource {

    private static final Logger log = Logger.getLogger(PacienteResource.class);

    @Inject
    PacienteService pacienteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPacientes() {
        log.info("Request to find all pacient");
        return Response.ok(pacienteService.listAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPacientePeloId(@PathParam("id") Long id) throws NotFoundException {
        log.info("Request to find pacient by id");
        return Response.ok(pacienteService.getById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarPaciente(Paciente paciente) {
        log.info("Request to save pacient: " + paciente);
        pacienteService.save(paciente);
        return Response.ok().status(CREATED).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarPaciente(Paciente paciente) throws NotFoundException {
        log.info("Request to update pacient" + paciente);
        pacienteService.update(paciente);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarPaciente(@PathParam("id") Long id) throws NotFoundException {
        log.info("Request to delete pacient by id: " + id);
        pacienteService.delete(id);
        return Response.ok().build();
    }

}
