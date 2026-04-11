package dev.opoussa.read_service.client;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "http://pingpong-svc:2345")
public interface IPingClient {

    @GetExchange("/amount")
    public String getPingPongAmount();
}
