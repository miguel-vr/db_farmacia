package com.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.generation.farmacia.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
	public List <Produto> findAllByNomeContainingIgnoreCase(String nome);
	public List <Produto> findByNomeAndLaboratorio(String nome, String laboratorio);
	public List <Produto> findByNomeOrLaboratorio(String nome, String laboratorio);
	@Query(value = "select * from tb_produtos where preco between :inicio and :fim", nativeQuery = true)
	public List <Produto> buscarProdutosEntre(@Param("inicio") BigDecimal inicio, @Param("fim") BigDecimal fim);
}
