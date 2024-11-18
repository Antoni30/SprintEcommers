package com.curso.ecommerce.sprintecommerce.repository;

import com.curso.ecommerce.sprintecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

}
