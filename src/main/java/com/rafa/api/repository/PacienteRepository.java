package com.rafa.api.repository;

import com.rafa.api.domain.Paciente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PacienteRepository implements PanacheRepositoryBase<Paciente, Long> {
}
