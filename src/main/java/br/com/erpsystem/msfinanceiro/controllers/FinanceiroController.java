package br.com.erpsystem.msfinanceiro.controllers;

import br.com.erpsystem.msfinanceiro.dto.LimiteCreditoDTO;
import br.com.erpsystem.msfinanceiro.services.FinanceiroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/financeiro")
@RequiredArgsConstructor
public class FinanceiroController {

    private final FinanceiroService financeiroService;

    @GetMapping(value = "/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LimiteCreditoDTO> buscarLimiteCreditoPorCpf(@PathVariable("cpf") String cpf){
        log.info("FinanceiroController.buscarLimiteCreditoPorCpf - Start - cpf: {}", cpf);
        LimiteCreditoDTO clienteDTO = financeiroService.buscarClientePorCpf(cpf);
        log.info("FinanceiroController.buscarLimiteCreditoPorCpf - End");
        return ResponseEntity.ok(clienteDTO);
    }

}
