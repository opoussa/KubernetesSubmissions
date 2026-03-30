# 1.11 Persisting data (Spring Boot)
Apply the new `Persistent Volume` and `Persistent Volume Claim` from the volume folder:
```
kubectl apply -f volumes
```
Apply `deployment` and `service` manifests from manifest folder:
```
kubectl apply -f manifests
```

Apply shared `ingress` in ingress folder:
```
kubectl apply -f ingress
```
Now you can hash output and amount of Ping-Pongs from `read service` at _http://localhost:8081/_
