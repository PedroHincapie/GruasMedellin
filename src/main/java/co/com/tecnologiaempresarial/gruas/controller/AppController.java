package co.com.tecnologiaempresarial.gruas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.com.tecnologiaempresarial.gruas.entity.Clientes;
import co.com.tecnologiaempresarial.gruas.service.IClientesService;

@RestController
@RequestMapping("gruas")
public class AppController {

	@Autowired
	private IClientesService clienteService;

	@GetMapping("cliente")
	public ResponseEntity<List<Clientes>> getAllArticles() {
		List<Clientes> list = clienteService.getClientes();
		return new ResponseEntity<List<Clientes>>(list, HttpStatus.OK);
	}

	@GetMapping("cliente/{id}")
	public ResponseEntity<Clientes> getClienteId(@PathVariable long id) {
		Clientes cli =  clienteService.getClienteById(id);
		return new ResponseEntity<Clientes>(cli, HttpStatus.OK);
	}

	@DeleteMapping("cliente/{id}")
	public void deleteStudent(@PathVariable long id) {
		clienteService.deleteCliente(id);
	}


	@RequestMapping(value = "cliente", method = RequestMethod.POST)
	public void createStudent(@RequestBody Clientes cliente) {
		System.err.println("Pedro :" + cliente.toString());
		Clientes cli = clienteService.saveCliente(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cli.getId_cliente()).toUri();


	}

	@PutMapping("clientes/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Clientes student, @PathVariable long id) {

		Clientes studentOptional = clienteService.getClienteById(id);

		if (studentOptional.getId_cliente() != id)
			return ResponseEntity.notFound().build();

		student.setId_cliente(id);

		clienteService.saveCliente(student);

		return ResponseEntity.noContent().build();
	}

}
