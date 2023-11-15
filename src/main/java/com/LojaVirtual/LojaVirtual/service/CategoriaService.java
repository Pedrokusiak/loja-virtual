package com.LojaVirtual.LojaVirtual.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.LojaVirtual.LojaVirtual.entity.Categoria;
import com.LojaVirtual.LojaVirtual.entity.Estado;
import com.LojaVirtual.LojaVirtual.repository.CategoriaRepository;



@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Page<Categoria> listarTodos(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).get();
    }

    public Categoria inserir(Categoria objeto) {
        objeto.setDataCriacao(new Date());
        Categoria objetoNovo = categoriaRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Categoria alterar(Categoria objeto) {
        objeto.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Categoria não encontrada."));
        categoriaRepository.delete(categoria);

    }
}