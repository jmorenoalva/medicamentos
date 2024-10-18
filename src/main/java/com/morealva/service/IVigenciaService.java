package com.morealva.service;

import com.morealva.modelo.Vigencia;

public interface IVigenciaService extends ICRUD<Vigencia, Integer>{


    Vigencia createVigenciaAutomatico(String codigoPagina);

}
