package dao;

import domain.Produto;

import java.util.List;

public interface IProdutoDao {

   public Produto cadastrar(Produto produto);

   public void excluir(Produto produto);

   public Produto buscarPorId(Long id);

   public List<Produto> buscarTodos();
}

