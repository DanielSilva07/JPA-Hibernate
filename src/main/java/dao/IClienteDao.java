package dao;

import domain.Cliente;

public interface IClienteDao {

    public Cliente cadastrar(Cliente cliente);
    Cliente excluir(Cliente cliente) ;


}
