package br.com.erpsystem.msfinanceiro.listeners;

import br.com.erpsystem.msfinanceiro.constants.RabbitMQConstants;
import br.com.erpsystem.msfinanceiro.dto.LimiteCreditoDTO;
import br.com.erpsystem.msfinanceiro.services.FinanceiroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class LimiteCreditoListener {

    private final FinanceiroService financeiroService;

    @RabbitListener(queues = RabbitMQConstants.LIMITE_CREDITO_QUEUE)
    public void listen(@Payload LimiteCreditoDTO clienteDTO){
        log.info("ClienteListener.listen - Start - clienteDTO: {}", clienteDTO);

        financeiroService.salvarCliente(clienteDTO);

        log.info("ClienteListener.listen - End");
    }
}
