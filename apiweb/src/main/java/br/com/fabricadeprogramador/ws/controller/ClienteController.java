package br.com.fabricadeprogramador.ws.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.ws.model.Cliente;

@RestController
public class ClienteController {
	
	Map<Integer, Cliente> clientes;
	Integer proximoId = 1;
	
	private Cliente cadastro(Cliente cliente) {
		if(clientes == null) {
			clientes = new HashMap<>();
		}
		cliente.setId(proximoId);
		proximoId++;
		clientes.put(cliente.getId(), cliente);
		return cliente;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cadastrarCliente(@RequestBody Cliente cliente) {
		System.out.println("Chamou /clientes");
	}
}
