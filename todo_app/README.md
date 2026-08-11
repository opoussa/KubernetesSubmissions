# 2.6. The project, step 10

### New ConfigMap
New ConfigMap `todo-app-config` containing all environment variables for PORTs file paths and URIs:
```
apiVersion: v1
kind: ConfigMap
metadata:
  name: todo-app-config
  namespace: project
data:
  PORT: "8081"
  SHARED_FOLDER_PATH: "/shared/"
  IMAGE_FILE_PATH: "/app/images/"
  BACKEND_URL: "http://todo-backend-svc:2345"
  IMAGE_API_URL: "https://picsum.photos/id/"
```
Frontend and backend deployments create environment variables from the ConfigMap:
```
spec:
      containers:
      ...
        envFrom:
          - configMapRef:
              name: todo-app-config
```

----
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
