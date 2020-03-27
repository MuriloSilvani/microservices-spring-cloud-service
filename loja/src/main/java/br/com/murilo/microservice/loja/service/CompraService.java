package br.com.murilo.microservice.loja.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.microservice.loja.client.FornecedorClient;
import br.com.murilo.microservice.loja.dto.CompraDto;
import br.com.murilo.microservice.loja.dto.InfoFornecedorDto;
import br.com.murilo.microservice.loja.dto.infoPedidoDto;
import br.com.murilo.microservice.loja.model.Compra;

@Service
public class CompraService {

	private static final Logger log = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDto compra) {

		log.info("Buscando fornecedor de {}", compra.getEndereco().getEstado());
		InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

		log.info("Realizando pedido");
		infoPedidoDto pedido = fornecedorClient.realizaPedido(compra.getItens());

		Compra compraSalva = new Compra();

		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(info.getEndereco().toString());
		
		return compraSalva;
		
	}
}
