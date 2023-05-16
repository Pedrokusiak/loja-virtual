package com.LojaVirtual.LojaVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LojaVirtual.LojaVirtual.service.EstadoService;

@RestController
@RequestMapping("/api")
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;

    @GetMapping("/list")
    public List<Estado> listarTodos(){
        return estadoService listarTodos();
    }
}
