package co.com.tecnologiaempresarial.gruas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.tecnologiaempresarial.gruas.entity.Clientes;
import co.com.tecnologiaempresarial.gruas.service.IClientesService;

@Controller
@RequestMapping("gruas")
public class AppController {

	@Autowired
	private IClientesService clienteService;

	@GetMapping("cliente")
	public ResponseEntity<List<Clientes>> getAllArticles() {
		List<Clientes> list = clienteService.getClientes();
		return new ResponseEntity<List<Clientes>>(list, HttpStatus.OK);
	}
}
