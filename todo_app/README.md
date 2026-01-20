# todoapp 1.2

### How to run

Build the docker image:
```
docker build -t todo_app:1.2 .
```

<br>

Import the image to the cluster:
```
k3d image import todo_app:1.2
```

<br>

Create a deployment with the image:
```
kubectl create deployment todoapp-dep --image=todo_app:1.2
```
<br>

Open the deployment manifest:
```
kubectl edit deployment todoapp-dep
```

...and set a `PORT` environment variable to a desired port:
```yaml
...
    spec:
        containers:
        - env:
            - name: PORT
              value: "8082"
          image: todo_app:1.2
          imagePullPolicy: IfNotPresent
...                                                               
```
<br>

Check the deployment pod `name`:
```
kubectl get pods
```

And finally to see the output logs inside the pod:
```
kubectl logs -f {pod name}
```