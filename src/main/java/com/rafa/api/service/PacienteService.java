package com.rafa.api.service;

import com.rafa.api.domain.Paciente;
import com.rafa.api.exceptionHandler.NotFoundException;
import com.rafa.api.repository.PacienteRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PacienteService {

    @Inject
    PacienteRepository pacienteRepository;

    public List<Paciente> listAll() {
        return pacienteRepository.listAll();
    }

    public Paciente getById(Long id) throws NotFoundException {
        return pacienteRepository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void save(Paciente paciente) {
        pacienteRepository.persist(paciente);
    }

    @Transactional
    public void update(Paciente paciente) throws NotFoundException {
        Paciente pacienteExistente = getById(paciente.getId());
        pacienteExistente.setNome(paciente.getNome());
        save(pacienteExistente);
    }

    @Transactional
    public void delete(Long id) throws NotFoundException {
        Paciente pacienteExistente = getById(id);
        pacienteRepository.deleteById(id);
    }
}
