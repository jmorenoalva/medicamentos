package com.morealva.service.impl;

import com.morealva.modelo.Presentacion;
import com.morealva.repository.IGenericRepo;
import com.morealva.repository.IPresentacionRepo;
import com.morealva.service.IPresentacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PresentacionServiceImpl extends CRUDImpl<Presentacion, Integer> implements IPresentacionService {

    private final IPresentacionRepo repo;

    @Override
    protected IGenericRepo<Presentacion, Integer> getRepo() {
        return repo;
    }
}
