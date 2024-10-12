package com.morealva.service.impl;

import com.morealva.modelo.Pagina;
import com.morealva.repository.IGenericRepo;
import com.morealva.repository.IPaginaRepo;
import com.morealva.service.IPaginaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaginaServiceImpl extends CRUDImpl<Pagina, Integer> implements IPaginaService {

    private final IPaginaRepo repo;

    @Override
    protected IGenericRepo<Pagina, Integer> getRepo() {
        return repo;
    }
}
