package com.morealva.service.impl;

import com.morealva.modelo.Producto;
import com.morealva.repository.IGenericRepo;
import com.morealva.repository.IProductoRepo;
import com.morealva.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

    private final IProductoRepo repo;
    @Override
    protected IGenericRepo<Producto, Integer> getRepo() {
        return repo;
    }
}
