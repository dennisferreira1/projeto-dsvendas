package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dto.VendaDTO;
import com.devsuperior.dsvendas.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<Page<VendaDTO>> buscarVendas(Pageable pageable) {
        Page<VendaDTO> vendas = vendaService.buscarVendas(pageable);
        return ResponseEntity.ok(vendas);
    }
}
