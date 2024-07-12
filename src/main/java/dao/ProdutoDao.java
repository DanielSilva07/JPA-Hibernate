package dao;
import domain.Produto;

import javax.persistence.*;
import java.util.List;

public class ProdutoDao implements IProdutoDao{

    @Override
    public Produto cadastrar(Produto produto) {

        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public void excluir(Produto produto) {

        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto );
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public Produto buscarPorId(Long id) {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Produto produto = entityManager.find(Produto.class,id);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto;

    }

    @Override
    public List<Produto> buscarTodos() {
        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Produto> list =
                entityManager.createQuery("SELECT p FROM Produto p",Produto.class).getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return list;
    }


}
