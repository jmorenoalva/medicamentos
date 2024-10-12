package com.morealva.service.impl;

import com.morealva.modelo.PrincipioActivo;
import com.morealva.repository.IGenericRepo;
import com.morealva.repository.IPrincipioActivoRepo;
import com.morealva.service.IPrincipioActivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipioActivoServiceImpl extends CRUDImpl<PrincipioActivo, Integer> implements IPrincipioActivoService {

    private final IPrincipioActivoRepo repo;

    @Override
    protected IGenericRepo<PrincipioActivo, Integer> getRepo() {
        return repo;
    }
}
