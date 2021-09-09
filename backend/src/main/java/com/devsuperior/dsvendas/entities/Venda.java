package com.devsuperior.dsvendas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer visitado;
    private Integer vendaComSucesso;
    private Double valorVendido;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

}
