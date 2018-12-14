package br.com.comprasfacil.compras_facil.service;

import br.com.comprasfacil.compras_facil.exception.ObjectNotFoundException;
import br.com.comprasfacil.compras_facil.model.Produto;
import br.com.comprasfacil.compras_facil.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto) {
        verifyProdutoExist(produto.getId());
        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        verifyProdutoExist(id);
        produtoRepository.deleteById(id);
    }

    public Produto findById(Long id) {
        verifyProdutoExist(id);
        return produtoRepository.findById(id).get();
    }

    private void verifyProdutoExist(Long id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        obj.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado: " + id + ", tipo: " + Produto.class.getName()));
    }
}
