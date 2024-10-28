package com.morealva.service.impl;

import com.morealva.modelo.PrincipioActivo;
import com.morealva.modelo.Producto;
import com.morealva.modelo.ProductoPrincipioActivo;
import com.morealva.repository.IProductoPrincipioActivoRepo;
import com.morealva.repository.IProductoRepo;
import com.morealva.service.IProductoPrincipioActivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoPrincipioActivoServiceImpl implements IProductoPrincipioActivoService {

    private final IProductoPrincipioActivoRepo productoPrincipioActivoRepo;
    private final IProductoRepo productoRepo;

    @Override
    public List<PrincipioActivo> getPrincipioActivosByProductoId(Integer id) {
        return productoPrincipioActivoRepo.getPrincipioActivosByProductoId(id);
    }

    @Override
    public ProductoPrincipioActivo getProductoByIdAndPrincipioActivoById(Integer productoId, Integer principioActivoId) {
        return productoPrincipioActivoRepo.findByProductoIdAndPrincipioActivoId(productoId, principioActivoId);
    }

    @Override
    public List<Producto> getProductoByPrincipioActivoId(Integer principioActivoId) {
        return productoPrincipioActivoRepo.getProductoAndPrincipioActivoId(principioActivoId);
    }


}
