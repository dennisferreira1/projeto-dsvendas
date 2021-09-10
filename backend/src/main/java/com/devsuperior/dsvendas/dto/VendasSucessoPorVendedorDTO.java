package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.entities.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendasSucessoPorVendedorDTO implements Serializable {
    private final static long serialVersionUID= 1L;

    private String nomeVendedor;
    private Long totalVisitado;
    private Long totalVendasComSucesso;

    public VendasSucessoPorVendedorDTO(Vendedor vendedor, Long totalVisitado, Long totalSucesso) {
        nomeVendedor= vendedor.getNome();
        this.totalVisitado= totalVisitado;
        totalVendasComSucesso= totalSucesso;
    }
}
