# 2.3. Keep them separated
### New Namespace
Log output and pingpong services now live in the own namespace `exercises`

Namespace has been added to the metadata of services, deployments and the ingress.

```yaml
...
metadata:
  name: pingpong-dep
  namespace: exercises
...
```

### How to run
Create and select new namespace `exercises` as kubectl context

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
