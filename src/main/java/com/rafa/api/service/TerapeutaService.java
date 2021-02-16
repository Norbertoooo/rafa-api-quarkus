package com.rafa.api.service;

import com.rafa.api.domain.Terapeuta;
import com.rafa.api.exceptionHandler.NotFoundException;
import com.rafa.api.repository.TerapeutaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TerapeutaService {

    @Inject
    TerapeutaRepository terapeutaRepository;

    public List<Terapeuta> listAll() {
        return terapeutaRepository.listAll();
    }

    public Terapeuta getById(Long id) throws NotFoundException {
        return terapeutaRepository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void save(Terapeuta terapeuta) {
        terapeutaRepository.persist(terapeuta);
    }

    @Transactional
    public void update(Terapeuta terapeuta) throws NotFoundException {
        Terapeuta terapeutaExistente = getById(terapeuta.getId());
        terapeutaExistente.setNome(terapeuta.getNome());
        save(terapeutaExistente);
    }

    @Transactional
    public void delete(Long id) throws NotFoundException {
        getById(id);
        terapeutaRepository.deleteById(id);
    }
}
