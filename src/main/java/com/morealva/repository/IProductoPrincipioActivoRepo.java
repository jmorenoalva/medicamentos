package com.morealva.repository;

import com.morealva.modelo.PrincipioActivo;
import com.morealva.modelo.ProductoPrincipioActivo;
import com.morealva.modelo.ProductoPrincipioActivoPK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductoPrincipioActivoRepo extends IGenericRepo<ProductoPrincipioActivo, ProductoPrincipioActivoPK> {

    @Modifying
    @Query(value = "INSERT INTO producto_principio_activo (id_producto, id_principio_activo) VALUES (:idProducto, :idPrincipioActivo)", nativeQuery = true)
    Integer savePrincipioActivo(@Param("idProducto") Integer idProducto, @Param("idPrincipioActivo") Integer idPrincipio);

    @Query("SELECT pp.principioActivo FROM ProductoPrincipioActivo pp WHERE pp.producto.idProducto=:idProducto")
    List<PrincipioActivo> getPrincipioActivosByProductoId(@Param("idProducto") Integer id);

    @Query("SELECT pp.principioActivo FROM ProductoPrincipioActivo pp WHERE pp.producto.idProducto=:idProducto AND pp.principioActivo.idPrincipio=:idPrincipio")
    ProductoPrincipioActivo findByProductoIdAndPrincipioActivoId(@Param("idProducto") Integer idProducto, @Param("idPrincipio") Integer idPrincipio);
}