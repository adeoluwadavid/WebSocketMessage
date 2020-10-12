/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webSspringIo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author Adewole
 */
@Controller
public class GreetingController {
    
    @MessageMapping("/hello") // Message is sent to this url
    @SendTo("/topic/greetings") // Message is broadcast to this url subscribers
    public Greeting greeting(HelloMessage message) throws Exception{
        Thread.sleep(1000); // 1 Second delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
