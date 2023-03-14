package br.com.erpsystem.msfinanceiro.services;

import br.com.erpsystem.msfinanceiro.dto.LimiteCreditoDTO;
import br.com.erpsystem.msfinanceiro.entity.Credito;
import br.com.erpsystem.msfinanceiro.mapper.FinanceiroMapper;
import br.com.erpsystem.msfinanceiro.repository.FinanceiroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FinanceiroServiceImpl implements FinanceiroService {

    private final FinanceiroRepository financeiroRepository;
    private final FinanceiroMapper mapper;

    @Override
    public LimiteCreditoDTO salvarCliente(LimiteCreditoDTO clienteDTO) {
        log.info("ClienteServiceImpl.salvarCliente - Start - clienteDTO: {}", clienteDTO);
        Credito savedCliente = financeiroRepository.save(mapper.clienteDtoToCliente(clienteDTO));
        log.info("ClienteServiceImpl.salvarCliente - End - cliente: {}", savedCliente);
        return mapper.clienteToClienteDTO(savedCliente);
    }

    @Override
    public LimiteCreditoDTO buscarClientePorCpf(String cpf) {
        log.info("ClienteServiceImpl.salvarCliente - Start - Cpf Cliente: {}", cpf);
        LimiteCreditoDTO clienteDTO = mapper.clienteToClienteDTO(financeiroRepository.findClienteByCpf(cpf));
        log.info("ClienteServiceImpl.salvarCliente - End - cliente: {}", clienteDTO);
        return clienteDTO;
    }
}
