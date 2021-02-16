package com.rafa.api.repository;

import com.rafa.api.domain.Terapeuta;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TerapeutaRepository implements PanacheRepositoryBase<Terapeuta, Long> {
}
