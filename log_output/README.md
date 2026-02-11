# Log Output App (Spring Boot)
Build the docker image for log output app:
```
docker build -t log_output:latest .
```

Build the docker image for ping-pong app:
```
docker build -t pingpong:latest .
```


Import images to cluster
```
k3d image import log_output:latest
k3d image import pingpong:latest
```

Apply `deployment` and `service` manifests by applying all manifests in BOTH app folders:
```
kubectl apply -f manifests
```
<br>

Then apply shared ingress in root folder
```
kubectl apply -f ingress
```

Now you can access the hash output from the browser at _http://localhost:8081/_ and ping-pong at _http://localhost:8081/pingpong_
