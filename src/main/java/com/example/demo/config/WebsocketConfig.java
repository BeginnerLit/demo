package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Mouse Lee
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic","/queue");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .addInterceptors(myHndlerInterceptor())
                .setHandshakeHandler(mydefaultHandshakeHandler())
                .withSockJS();
    }

    private HandshakeInterceptor myHndlerInterceptor(){
        return new HandshakeInterceptor(){
            @Override
            public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
                ServletServerHttpRequest req= (ServletServerHttpRequest) serverHttpRequest;
                System.out.println("握手之前");
                Principal user=()->"1111";
                map.put("aaa",user);
                map.put("bbb","222");
                String s=req.getServletRequest().getParameter("aaa");
                System.out.println(s);
                return true;
            }

            @Override
            public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
                System.out.println("握手之后");
            }

        };
    }

    private DefaultHandshakeHandler mydefaultHandshakeHandler(){
        return new DefaultHandshakeHandler(){
            @Override
            protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
                //把用户放进session里
                if (attributes.get("aaa")!=null){
                    return (Principal) attributes.get("aaa");
                }
                return new Principal() {
                    @Override
                    public String getName() {
                        return "222";
                    }
                };
            }
        };
    }

/*    public static void main(String[] args) {
        ConcurrentMap<String,String> aa=new ConcurrentHashMap<>();
        aa.put("aaa","bbb");
        aa.remove("aaa");
        System.out.println(((ConcurrentHashMap<String, String>) aa).contains("aaa"));
    }*/
}
