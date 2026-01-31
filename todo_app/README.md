# todoapp 1.6

### How to run

Build the docker image:
```
docker build -t todo_app:1.6 .
```
Create a cluster with an exposed `node port` and also set a `target port` for the load balancer:

```
k3d cluster create --port 8082:30080@agent:0 -p 8081:80@loadbalancer --agents 2
```

Import image to k3d cluster:
```
k3d image import todo_app:1.6 -c k3s-default
```

Make sure the PORT environment variable matches the loadbalancer target port by editing the deployment manifest:
```yaml
...

spec:
      containers:
        - name: todoapp
          image: todo_app:1.6
          imagePullPolicy: IfNotPresent
          env:
            - name: PORT
              value: "8081"
...
```

Create a deployment for the image to the cluster using deployment manifest:

```
kubectl apply -f manifests/deployment.yaml
```

And finally create a NodePort Service for the deployment with the new service manifest:

```
kubectl apply -f manifests/service.yaml
```

Index page should now be accessible on exposed node port (8082 in the above example).
