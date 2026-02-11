package dev.opoussa.ping_pong.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    private static int pingPongCount = 0;

    @GetMapping({"/pingpong", "/pingpong/", "/", ""})
    public String pingPong() {
        pingPongCount++;
        return "pong " + pingPongCount;
    }

}