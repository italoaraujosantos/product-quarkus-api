package br.com.product.quarkus.api.services;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.product.quarkus.api.models.Produto;
import br.com.product.quarkus.api.repositories.ProdutoRepository;

@Transactional
@ApplicationScoped
public class ProdutoService {

	@Inject
	private ProdutoRepository produtoRepository;
	
	public Produto cadastrar(Produto produto) {
		return produtoRepository.cadastrar(produto);
	}
	
	public Produto  atualizar(Produto produto) {
		Produto produtoDB = Produto.findById(produto.id);
		produtoDB.setDescricao(produto.getDescricao());
		produtoDB.setPreco(produto.getPreco());
		return produtoRepository.cadastrar(produtoDB);
	}
	
	public Optional<Produto> consultar(Long idProduto) {
		return produtoRepository.consultar(idProduto);
	}
	
	public void deletar(Long idProduto) {
		produtoRepository.deletar(idProduto);
	}
}
