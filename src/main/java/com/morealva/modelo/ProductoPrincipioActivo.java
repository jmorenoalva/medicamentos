package com.morealva.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ProductoPrincipioActivoPK.class)
public class ProductoPrincipioActivo {

    @Id
    private Producto producto;

    @Id
    private PrincipioActivo principioActivo;

    public ProductoPrincipioActivo(PrincipioActivo principio) {
        this.principioActivo = principioActivo;
    }
}
