package dev.opoussa.ping_pong.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.opoussa.ping_pong.service.PingService;
@RestController
public class PingController {

    private final PingService pingService;

    public PingController(PingService pingService) {
        this.pingService = pingService;
    }

    @GetMapping({"/", "", "/pingpong"})
    public String pingPong() {
        if (pingService == null) {
            return "Error: ping service not initialized";
        }
        pingService.logPingPongCount();
        try {
            String pingPongCount = pingService.getPingPongCount();
            return "pong " + pingPongCount;
        } catch (Exception e ) {
            e.printStackTrace();
            return "Error retrieving ping pong count. " + e.getMessage();
        }
    }

}