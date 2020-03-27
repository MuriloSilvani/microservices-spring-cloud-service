package br.com.murilo.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.murilo.microservice.loja.dto.InfoFornecedorDto;
import br.com.murilo.microservice.loja.dto.ItemDaCompraDto;
import br.com.murilo.microservice.loja.dto.infoPedidoDto;

@FeignClient("fornecedor")
public interface FornecedorClient {

	@RequestMapping("/info/{estado}")
	public InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);

	@RequestMapping(method= RequestMethod.POST, value= "/pedido")
	public infoPedidoDto realizaPedido(List<ItemDaCompraDto> itens);
}
