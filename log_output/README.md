# Log Output App (Spring Boot)
Build the docker image:
```
docker build -t log_output:latest .
```
<br>

Deploy to a cluster by using the new deployment manifest file
```
kubectl apply -f manifests/deployment.yaml
```

<br>

Check the deployment pod's `name`:
```
kubectl get pods
```
<br>

And finally to see the output logs inside the pod:
```
kubectl logs -f {$POD_NAME}
```
