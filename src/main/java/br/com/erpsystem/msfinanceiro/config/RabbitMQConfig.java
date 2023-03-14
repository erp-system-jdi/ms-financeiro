package br.com.erpsystem.msfinanceiro.config;

import br.com.erpsystem.msfinanceiro.constants.RabbitMQConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue limiteCreditoQueue(){
        return QueueBuilder.durable(RabbitMQConstants.LIMITE_CREDITO_QUEUE).build();
    }

    @Bean
    public TopicExchange limiteCreditoExchange(){
        return ExchangeBuilder.topicExchange(RabbitMQConstants.LIMITE_CREDITO_EXCHANGE).durable(true).build();
    }

    @Bean
    public Binding limiteCreditoBinding(){
        return BindingBuilder.bind(limiteCreditoQueue()).to(limiteCreditoExchange()).with(RabbitMQConstants.LIMITE_CREDITO_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public AmqpTemplate rabbitTemplateConfig(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        rabbitTemplate.setUseDirectReplyToContainer(false);
        return rabbitTemplate;
    }
}
