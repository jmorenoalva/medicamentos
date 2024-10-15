package com.morealva.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class ProductoPrincipioActivoPK {

    @ManyToOne
    @JoinColumn(name = "id_producto", foreignKey = @ForeignKey(name = "FK_PRODUCTO_PRODUCTOPRINCIPIOACTIVOPK"))
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_principio_activo", foreignKey = @ForeignKey(name = "FK_PRINCIPIOACTIVO_PRODUCTOPK"))
    private PrincipioActivo principioActivo;
}
