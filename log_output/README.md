# 2.1. Connecting pods (Spring Boot)
### Connection via HTTP
Read service now gets ping-pong count from ping-pong service through a HTTP request.

```java
// Read controller's HTTP client
@HttpExchange(url = "http://pingpong-svc:2345")
public interface IPingClient {

    @GetExchange("/amount")
    public String getPingPongAmount();
}
```
```java
// Ping-pong service's HTTP endpoint
@GetMapping("/amount")
public String getMethodName() {
    return pingService.getPingPongCount();
}
```

Ping-pong service does not know about the persistent volume now, and stores ping-pong count in memory instead.


### How to run
Apply `Persistent Volume` and `Claim` for read and write services from the volume folder:
```
kubectl apply -f volumes
```
Apply `deployment` and `service` manifests from manifest folder (also in ping-pong subdirectory):
```
kubectl apply -f manifests
```

Apply shared `ingress` in ingress folder:
```
kubectl apply -f ingress
```
Now you can see hash output and amount of Ping-Pongs from `read service` at _http://localhost:8081/_ 

Use _http://localhost:8081/pingpong_ to increase ping-pong count.
