package br.com.comprasfacil.compras_facil.repository;

import br.com.comprasfacil.compras_facil.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
