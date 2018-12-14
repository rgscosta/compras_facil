package br.com.comprasfacil.compras_facil.controller;

import br.com.comprasfacil.compras_facil.model.Produto;
import br.com.comprasfacil.compras_facil.repository.ProdutoRepository;
import br.com.comprasfacil.compras_facil.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.update(produto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findProdutoById(@PathVariable Long id) {
        return new ResponseEntity<>(produtoService.findById(id), HttpStatus.OK);
    }

}
