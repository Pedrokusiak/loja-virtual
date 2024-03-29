package com.LojaVirtual.LojaVirtual.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.LojaVirtual.LojaVirtual.entity.Produto;
import com.LojaVirtual.LojaVirtual.repository.ProdutoRepository;



@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<Produto> listarTodos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).get();
    }

    public Produto salvar(Produto produto) {
        // produto.setDataCriacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public Produto atualizar(Produto produto) {
        // produto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public void excluir(Long id){
        produtoRepository.deleteById(id);
    }
}