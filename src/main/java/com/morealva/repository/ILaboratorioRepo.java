package com.morealva.repository;

import com.morealva.modelo.Laboratorio;
import com.morealva.modelo.Pagina;

public interface ILaboratorioRepo extends IGenericRepo<Laboratorio, Integer>{

    Laboratorio findByNombre(String nombre);
}
