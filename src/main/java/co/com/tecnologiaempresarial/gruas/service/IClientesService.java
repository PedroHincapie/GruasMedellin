package co.com.tecnologiaempresarial.gruas.service;

import java.util.List;

import co.com.tecnologiaempresarial.gruas.entity.Clientes;

public interface IClientesService {
	List<Clientes> getClientes();
	Clientes saveCliente(Clientes cli);
	Clientes getClienteById(long id);
	void deleteCliente(long id);
}
