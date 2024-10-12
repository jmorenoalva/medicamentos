package com.morealva.service.impl;

import com.morealva.modelo.Laboratorio;
import com.morealva.repository.IGenericRepo;
import com.morealva.repository.ILaboratorioRepo;
import com.morealva.service.ILaboratorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LaboratorioServiceImpl extends CRUDImpl<Laboratorio, Integer> implements ILaboratorioService {

    private final ILaboratorioRepo repo;

    @Override
    protected IGenericRepo<Laboratorio, Integer> getRepo() {
        return repo;
    }
}
