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
public class Presentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPresentacion;

    @Column(nullable = false)
    private Integer idCodigo;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable = false, foreignKey = @ForeignKey(name="FK_PRESENTACION_PRODUCTO"))
    private Producto producto;

    @Column(nullable = false)
    private Integer idCodProd;

    @Column(nullable = false, length = 150)
    private String nombre;


    private Double pvf;

    private Double pvp;

    @Column(length = 250)
    private String modificaciones;

    @Column(nullable = false)
    private Boolean estado;
}
