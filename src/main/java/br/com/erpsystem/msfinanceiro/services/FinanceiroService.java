package br.com.erpsystem.msfinanceiro.services;


import br.com.erpsystem.msfinanceiro.dto.LimiteCreditoDTO;

public interface FinanceiroService {

    LimiteCreditoDTO salvarCliente(LimiteCreditoDTO clienteDTO);

    LimiteCreditoDTO buscarClientePorCpf(String cpf);
}
