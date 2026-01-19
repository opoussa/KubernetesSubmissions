# Log Output App (Spring Boot)
Build the docker image:
```
docker build -t log_output:latest .
```

<br>

Deploy to a cluster by creating a deployment:
```
kubectl create deployment hashgenerator-dep --image=log_output:latest
```
<br>

Edit the deployment manifest to use local images:
```
kubectl edit deployment hashgenerator-dep
```

...and change `imagePullPolicy` to `IfNotPresent`

<br>

Import the image to the cluster:
```
k3d image import log_output:latest
```

<br>

Check the deployment pod's `name`:
```
kubectl get pods
```

And finally to see the output logs inside the pod:
```
kubectl logs -f {$POD_NAME}
```