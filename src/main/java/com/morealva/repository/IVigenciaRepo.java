package com.morealva.repository;

import com.morealva.modelo.Pagina;
import com.morealva.modelo.Vigencia;

import java.time.LocalDate;

public interface IVigenciaRepo extends IGenericRepo<Vigencia, Integer>{

    Vigencia findByPaginaAndFecha(Pagina pagina, LocalDate fecha);

}
