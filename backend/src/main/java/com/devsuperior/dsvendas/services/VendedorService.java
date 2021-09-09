package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.VendedorDTO;
import com.devsuperior.dsvendas.entities.Vendedor;
import com.devsuperior.dsvendas.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<VendedorDTO> buscarTodos(){
        List<Vendedor> vendedores = this.vendedorRepository.findAll();
        return vendedores.stream().map(vendedor -> new VendedorDTO(vendedor)).collect(Collectors.toList());
    }
}
