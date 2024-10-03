package com.aula.micreoservice01.MicroService01.producers;

import com.aula.micreoservice01.MicroService01.dtos.EmailDto;
import com.aula.micreoservice01.MicroService01.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;


    public void publishMessageEmail(UserModel userModel){
        var emailDto =  new EmailDto();
        emailDto.setUserId(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userModel.getName() +", seja bem vindo(a)!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
