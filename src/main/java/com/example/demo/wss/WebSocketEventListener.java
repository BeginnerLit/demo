package com.example.demo.wss;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Mouse Lee
 */
@Component
@Slf4j
public class WebSocketEventListener {
    @Autowired
    SimpMessageSendingOperations simpMessageSendingOperations;
    public static List<String> list=new ArrayList<>();

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event){
        StompHeaderAccessor accessor=StompHeaderAccessor.wrap(event.getMessage());
        System.out.println(accessor);
        Map map= (Map) event.getMessage().getHeaders().get("simpSessionAttributes");
        System.out.println(map.get("bbb"));
        list.add((String) event.getMessage().getHeaders().get("simpSessionId"));
        simpMessageSendingOperations.convertAndSend("/topic/string","小妞你好！");
        log.info("有用户进入。。");


    }

    @EventListener
    public void handleWebSocketDisConnectListener(SessionDisconnectEvent event){
        /*StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());
        String s= (String) headerAccessor.getSessionAttributes().get("aa");*/
        list.remove(event.getSessionId());
        log.info("有用户断开连接");
    }
}
