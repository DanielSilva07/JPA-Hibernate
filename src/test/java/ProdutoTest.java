import domain.Produto;
import dao.ClienteDao;
import dao.IClienteDao;
import dao.IProdutoDao;
import dao.ProdutoDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProdutoTest {
    private IClienteDao clienteDao;

    private IProdutoDao produtoDao;

    public ProdutoTest(){
        produtoDao = new ProdutoDao();
        clienteDao =  new ClienteDao();
    }

    @Test
    public void cadastrar(){
        Produto produto = new Produto();
        produto.setNome("CPU-I5");
        produto.setCodigo("B2");
        produto.setPrice(3.500);
        produto = produtoDao.cadastrar(produto);

        Assert.assertNotNull(produto);
        Assert.assertNotNull(produto.getId());
        System.out.println(produto.getNome());
    }

    @Test public void buscarPorId(){
        Produto produto = new Produto();
        produto.setId(7L);

        Produto produtoDAO = produtoDao.buscarPorId(produto.getId());
        Assert.assertNotNull(produtoDAO);
        Assert.assertEquals(produto.getId() , produtoDAO.getId());
        System.out.println(produtoDAO.getNome());
    }
    @Test
    public void buscarTodos()  {
        List<Produto> list = produtoDao.buscarTodos();
        list.forEach(produto ->
                System.out.println(produto.getNome()));
        Assert.assertNotNull(list);

    }
    @Test
    public void excluir(){
        Produto produto = new Produto();
        produto.setId(5L);

        Produto produtoDAO = produtoDao.buscarPorId(produto.getId());
        produtoDao.excluir(produto);
        Assert.assertNotNull(produtoDAO);
        System.out.println("Produto excluido foi " + produtoDAO.getNome());

    }
}