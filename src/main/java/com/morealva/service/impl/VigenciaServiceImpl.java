package com.morealva.service.impl;

import com.morealva.modelo.Vigencia;
import com.morealva.repository.IGenericRepo;
import com.morealva.repository.IVigenciaRepo;
import com.morealva.service.IVigenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VigenciaServiceImpl extends CRUDImpl<Vigencia, Integer> implements IVigenciaService {

    private final IVigenciaRepo repo;

    @Override
    protected IGenericRepo<Vigencia, Integer> getRepo() {
        return repo;
    }
}
