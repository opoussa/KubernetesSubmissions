# 2.4. The project, step 9

### Project Namespace
Todo app and its backend have been moved into namespace `project`

Namespace has been added to the metadata of services, deployments and the ingress.

```yaml
...
metadata:
  name: pingpong-dep
  namespace: exercises
...
```

### How to run

Create and select new namespace `project` as kubectl context

Build the docker image:
```
docker build -t todo_app .
```

Import image to k3d cluster:
```
k3d image import todo_app
```
Apply new persistent volume and the persistent volume claim:

```
kubectl apply -f volumes
```

Apply new deployment to cluster:

```
kubectl apply -f manifests
```

Home page with random image and input form should now be visible at _http://localhost:8081/_
