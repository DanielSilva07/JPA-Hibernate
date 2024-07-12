package dao;

import domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDao implements IClienteDao{

    @Override
    public Cliente cadastrar(Cliente cliente) {

        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return cliente;
    }

    @Override
    public Cliente excluir(Cliente cliente) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return cliente;
    }
}
