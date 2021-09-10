package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.dto.VendasPorVendedorDTO;
import com.devsuperior.dsvendas.dto.VendasSucessoPorVendedorDTO;
import com.devsuperior.dsvendas.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query("SELECT new com.devsuperior.dsvendas.dto.VendasPorVendedorDTO(obj.vendedor, SUM(obj.valorVendido))"
            + " FROM Venda AS obj GROUP BY obj.vendedor")
    List<VendasPorVendedorDTO> somaValorTotalVendasPorVendedor();

    @Query("SELECT new com.devsuperior.dsvendas.dto.VendasSucessoPorVendedorDTO(obj.vendedor, SUM(obj.visitado), SUM(obj.vendaComSucesso))"
            + " FROM Venda AS obj GROUP BY obj.vendedor")
    List<VendasSucessoPorVendedorDTO> vendasSucessoPorVendedor();
}
