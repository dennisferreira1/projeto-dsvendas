package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.entities.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendedorDTO implements Serializable {
    private final static long serialVersionUID= 1L;

    private Long id;
    private String nome;

    public VendedorDTO(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
    }
}
