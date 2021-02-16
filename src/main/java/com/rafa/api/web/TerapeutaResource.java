package com.rafa.api.web;

import com.rafa.api.domain.Terapeuta;
import com.rafa.api.exceptionHandler.NotFoundException;
import com.rafa.api.service.TerapeutaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/terapeutas")
public class TerapeutaResource {

    @Inject
    TerapeutaService terapeutaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTerapeutas() {
        return Response.ok(terapeutaService.listAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarTerapeutaPeloId(@PathParam("id") Long id) throws NotFoundException {
        return Response.ok(terapeutaService.getById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarTerapeuta(Terapeuta terapeuta) {
        terapeutaService.save(terapeuta);
        return Response.ok().status(CREATED).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarPaciente(Terapeuta terapeuta) throws NotFoundException {
        terapeutaService.update(terapeuta);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarPaciente(@PathParam("id") Long id) throws NotFoundException {
        terapeutaService.delete(id);
        return Response.ok().build();
    }

}
