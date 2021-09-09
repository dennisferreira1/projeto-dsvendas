package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.VendaDTO;
import com.devsuperior.dsvendas.entities.Venda;
import com.devsuperior.dsvendas.repositories.VendaRepository;
import com.devsuperior.dsvendas.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Transactional(readOnly = true)
    public Page<VendaDTO> buscarVendas(Pageable pageable) {
        vendedorRepository.findAll();
        Page<Venda> vendas = vendaRepository.findAll(pageable);
        return vendas.map(venda -> new VendaDTO(venda));
    }
}
