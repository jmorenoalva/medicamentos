package com.morealva.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pagina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPagina;

    @Column(nullable = false, length = 4)
    private String codigo;

    @Column(nullable = false, length = 250)
    private String nombre;

    @Column(nullable = false, length = 250)
    private String url;

    @Column(nullable = false)
    private Boolean estado;
}
