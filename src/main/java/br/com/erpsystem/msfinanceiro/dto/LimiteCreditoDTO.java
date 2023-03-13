package br.com.erpsystem.msfinanceiro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LimiteCreditoDTO {

    private UUID id;
    @JsonProperty("valor_disponivel")
    private BigDecimal valorDisponivel;
}
