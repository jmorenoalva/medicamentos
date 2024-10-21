package com.morealva.service.impl;

import com.morealva.modelo.PrincipioActivo;
import com.morealva.repository.IProductoPrincipioActivoRepo;
import com.morealva.service.IProductoPrincipioActivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoPrincipioActivoServiceImpl implements IProductoPrincipioActivoService {

    private final IProductoPrincipioActivoRepo productoPrincipioActivoRepo;

    @Override
    public List<PrincipioActivo> getPrincipioActivosByProductoId(Integer id) {
        return productoPrincipioActivoRepo.getPrincipioActivosByProductoId(id);
    }
}
