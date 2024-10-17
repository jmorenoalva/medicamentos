package com.morealva.service.impl;

import com.morealva.aggregates.request.ProductosListRequest;
import com.morealva.aggregates.response.ProductoDTOResponse;
import com.morealva.aggregates.response.ProductoListDTOResponse;
import com.morealva.feignclient.FarmapreciosAll;
import com.morealva.feignclient.FarmapreciosProductos;
import com.morealva.modelo.Laboratorio;
import com.morealva.modelo.Producto;
import com.morealva.modelo.Vigencia;
import com.morealva.service.ILaboratorioService;
import com.morealva.service.IProductoListService;
import com.morealva.service.IProductoService;
import com.morealva.service.IVigenciaService;
import com.morealva.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoListServiceImpl implements IProductoListService {
    
    private final FarmapreciosAll farmapreciosAll;
    private final FarmapreciosProductos farmapreciosProductos;
    private final IVigenciaService vigenciaService;
    private final ILaboratorioService laboratorioService;

    private final IProductoService productoService;
    private final MapperUtil mapperUtil;

    @Override
    public ProductoListDTOResponse getListaProductosFarmaprecios(ProductosListRequest request) {

        Vigencia vigencia =vigenciaService.createVigenciaAutomatico("0001");

        ProductoListDTOResponse productoListDTOResponse = farmapreciosAll.busquedaProductos(request);

        productoListDTOResponse.getProductos().forEach(productoListDTO -> {


            try{
                ProductoDTOResponse productoDTOResponse = farmapreciosProductos.buscarProductoPorId(productoListDTO.getId());

                //productoService.save(mapperUtil.map(productoDTOResponse, Producto.class));
                productoService.createProductoAutomatico(productoDTOResponse, vigencia);
                System.out.println(productoDTOResponse);
                Thread.sleep(2000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }


        });

        return null;
    }
}
