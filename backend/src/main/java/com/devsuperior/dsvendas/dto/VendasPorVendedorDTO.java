package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.entities.Venda;
import com.devsuperior.dsvendas.entities.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendasPorVendedorDTO implements Serializable {
    private final static long serialVersionUID= 1L;

    private String nomeVendedor;
    private Double somaValorTotal;

    public VendasPorVendedorDTO(Vendedor vendedor, Double soma) {
        nomeVendedor= vendedor.getNome();
        somaValorTotal= soma;
    }
}
