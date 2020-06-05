package com.example.demo.wss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mouse Lee
 */
@RestController
public class TopicMsgController {
    @Autowired
    SimpMessagingTemplate template;

    @MessageMapping("/hello")
    //@SendTo("/topic/string")
    public void hello(Message message){
        //simpMessageSendingOperations.convertAndSend("/topic/string","hello 小妞");
        String s=WebSocketEventListener.list.get(WebSocketEventListener.list.size()-1);
        String ss= (String) message.getHeaders().get("simpSessionId");
        template.convertAndSendToUser(s,"/queue/string","测试111？",createHeaders(s));
        //return "hello girl";
    }

    @PostMapping("/send")
    //@SendTo("/topic/string")
    public void send(String user,String talk){
        //simpMessageSendingOperations.convertAndSend("/topic/string","hello 小妞");
        //String s=WebSocketEventListener.list.get(WebSocketEventListener.list.size()-1);
        template.convertAndSendToUser(user,"/topic/string",talk);
        //return "hello girl";
    }

    //不同的方式通讯 效果一样两个方法 该注解实现还是用的simpMessageSendingOperations
    @MessageMapping("/hello1")
    @SendTo("/topic/string")
    public String hello1(){
        //simpMessageSendingOperations.convertAndSend("/topic/string","hello 小妞");
        return "hello girl";
    }

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }


}
