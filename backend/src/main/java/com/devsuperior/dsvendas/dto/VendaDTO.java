package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.entities.Venda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaDTO implements Serializable {
    private final static long serialVersionUID= 1L;

    private Long id;
    private Integer visitado;
    private Integer vendaComSucesso;
    private Double valorVendido;
    private LocalDate data;

    private VendedorDTO vendedorDTO;

    public VendaDTO(Venda venda) {
        id= venda.getId();
        visitado= venda.getVisitado();
        vendaComSucesso= venda.getVendaComSucesso();
        valorVendido= venda.getValorVendido();
        data= venda.getData();
        vendedorDTO= new VendedorDTO(venda.getVendedor());
    }
}
