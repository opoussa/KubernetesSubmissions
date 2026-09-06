package dev.opoussa.ping_pong.service;
import org.springframework.stereotype.Service;

import dev.opoussa.ping_pong.repository.PingPongRepository;
@Service
public class PingService {

    private final PingPongRepository repository;

    public PingService(PingPongRepository pingPongRepository) {
        this.repository = pingPongRepository;
    }
    
    public void logPingPongCount() {
        Integer count = repository.incrementCount();
        System.out.println("Ping pong count increased. Current count: " + count);
    }

    public String getPingPongCount() {
       System.out.println("Ping pong count requested.");
       return repository.getCount().toString();
    }
}