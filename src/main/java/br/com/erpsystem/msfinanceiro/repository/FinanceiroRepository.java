package br.com.erpsystem.msfinanceiro.repository;

import br.com.erpsystem.mscliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FinanceiroRepository extends JpaRepository<Cliente, UUID> {

    Cliente findClienteByCpf(String cpf);
}
