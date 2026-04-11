package dev.opoussa.ping_pong.service;
import org.springframework.stereotype.Service;
@Service
public class PingService {

    private static int pingPongCount = 0;
    
    public void logPingPongCount() {
        pingPongCount++;
        System.out.println("Ping pong count increased. Current count: " + pingPongCount);
    }

    public String getPingPongCount() {
       System.out.println("Ping pong count requested.");
       return String.valueOf(pingPongCount);
    }
}