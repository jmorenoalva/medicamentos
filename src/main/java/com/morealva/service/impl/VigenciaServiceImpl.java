package com.morealva.service.impl;

import com.morealva.modelo.Pagina;
import com.morealva.modelo.Vigencia;
import com.morealva.repository.IGenericRepo;
import com.morealva.repository.IPaginaRepo;
import com.morealva.repository.IVigenciaRepo;
import com.morealva.service.IVigenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VigenciaServiceImpl extends CRUDImpl<Vigencia, Integer> implements IVigenciaService {

    private final IVigenciaRepo repo;
    private final IPaginaRepo paginaRepo;

    @Override
    protected IGenericRepo<Vigencia, Integer> getRepo() {
        return repo;
    }

    @Override
    public Vigencia createVigenciaAutomatico(String codigoPagina) {
        LocalDate date = LocalDate.now();

        Pagina pagina=paginaRepo.findByCodigo(codigoPagina);

        Vigencia vigencia = new Vigencia();
        vigencia.setAnio(date.getYear());
        vigencia.setMes(String.format("%02d",date.getMonthValue()));
        vigencia.setFecha(date);
        vigencia.setPagina(pagina);
        vigencia.setEstado(true);

        repo.save(vigencia);

        return vigencia;
    }

}
