package br.com.murilo.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.microservice.loja.dto.CompraDto;
import br.com.murilo.microservice.loja.model.Compra;
import br.com.murilo.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
    @PostMapping("")
    public Compra realizarCompra(@RequestBody CompraDto compra) {

    	return compraService.realizaCompra(compra);
    }

}