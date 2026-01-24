# todoapp 1.4

### How to run

Build the docker image:
```
docker build -t todo_app:latest .
```

Deploy image to the cluster using the new deployment manifest:

```
kubectl apply -f manifests/deployment.yaml
```

Check the deployment pod `name`:
```
kubectl get pods
```

And finally to see the output logs inside the pod:
```
kubectl logs -f {pod name}
```
