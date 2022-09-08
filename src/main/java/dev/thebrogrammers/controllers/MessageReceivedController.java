package dev.thebrogrammers.controllers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;

@Controller
public class MessageReceivedController {
    @JmsListener(destination = "message-queue", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessages(String message){
        System.out.println(message);
    }
}
