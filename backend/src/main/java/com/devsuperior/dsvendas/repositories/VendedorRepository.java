package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
