package dev.opoussa.ping_pong.service;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import dev.opoussa.ping_pong.repository.PingPongRepository;
@Service
@Slf4j 
public class PingService {

    private final PingPongRepository repository;

    public PingService(PingPongRepository pingPongRepository) {
        this.repository = pingPongRepository;
    }
    
    public void logPingPongCount() {
        Integer count = repository.incrementCount();
        log.info("Ping pong count increased. Current count: {}", count);
    }

    public String getPingPongCount() {
       log.info("Ping pong count requested.");
       return repository.getCount().toString();
    }
}