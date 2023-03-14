package br.com.erpsystem.msfinanceiro.mapper;


import br.com.erpsystem.msfinanceiro.dto.LimiteCreditoDTO;
import br.com.erpsystem.msfinanceiro.entity.Credito;

@Mapper
public interface FinanceiroMapper {

    Credito clienteDtoToCliente(LimiteCreditoDTO clienteDTO);
    LimiteCreditoDTO clienteToClienteDTO(Credito cliente);
}
