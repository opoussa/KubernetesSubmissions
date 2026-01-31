# todoapp 1.5

### How to run

Build the docker image:
```
docker build -t todo_app:latest .
```

Import image to k3d cluster if needed:
```
k3d image import todo_app:1.5 -c k3s-default
```

Set a desired value to PORT environment variable by editing the deployment manifest:
```yaml
...

spec:
      containers:
        - name: todoapp
          image: todo_app:1.5
          imagePullPolicy: IfNotPresent
          env:
            - name: PORT
              value: "8081"
...
```

Create deployment for the image to the cluster using deployment manifest:

```
kubectl apply -f manifests/deployment.yaml
```

Check the deployment pod `name`:
```
kubectl get pods
```

And finally expose the app port:
```
kubectl port-forward {pod name} 8080:8081
```
