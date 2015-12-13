package com.example;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

/**
 * Created by peter.ty on 15/11/13.
 */
@ClientEndpoint
public class EchoClientEndpoint {

    private static CountDownLatch latch;

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected..."+session.getId());
        try {
            session.getBasicRemote().sendText("start");
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnMessage
    public String OnMessage(String message, Session session) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Received..."+message);
            String userInput = br.readLine();
            return userInput;
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {

        System.out.println(String.format("Session %s close because of %s", session.getId(), closeReason));
    }

    public static void main(String[] args) {

        latch = new CountDownLatch(1);
        ClientManager client = ClientManager.createClient();
        try {
            client.connectToServer(EchoClientEndpoint.class, new URI("ws://localhost:8080/websocket-example/websocket/echoAnnotation"));
            latch.await();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
