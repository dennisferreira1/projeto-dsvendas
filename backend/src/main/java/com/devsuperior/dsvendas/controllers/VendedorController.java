package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dto.VendedorDTO;
import com.devsuperior.dsvendas.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> buscarTodos() {
        List<VendedorDTO> vendedores = this.vendedorService.buscarTodos();
        return ResponseEntity.ok(vendedores);
    }
}
