# Log Output App (Spring Boot)
Build the docker image:
```
docker build -t log_output:1.7 .
```

Import image to cluster
```
k3d image import log_output:1.7
```

Deploy `deployment`, `ingress` and `service` by applying all manifests:
```
kubectl apply -f manifests
```
<br>

Now you can access the hash output from the browser at _http://localhost:8081/_
