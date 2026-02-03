# todoapp 1.8

### How to run

Build the docker image:
```
docker build -t todo_app:latest .
```

Import image to k3d cluster:
```
k3d image import todo_app:latest -c k3s-default
```

Make sure the PORT environment variable matches the loadbalancer target port by editing the deployment manifest:
```yaml
...

spec:
      containers:
        - name: todoapp
          image: todo_app:latest
          imagePullPolicy: IfNotPresent
          env:
            - name: PORT
              value: "8081"
...
```

Apply all manifests to cluster `deployment`, `ingress` and `service`:

```
kubectl apply -f manifests
```


Home page of todoapp should now be visible at _http://localhost:8081/_