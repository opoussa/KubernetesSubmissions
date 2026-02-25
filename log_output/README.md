# Log Output App (1.10) (Spring Boot)
Build the docker images for write and read apps:
```
docker build -t write-service:latest .
docker build -t read-service:latest .
```

Import images to cluster
```
k3d image import write-service:latest
k3d image import read-service:latest
```

Apply `deployment` and `service` manifests from manifest folder:
```
kubectl apply -f manifests
```
The Deployment creates a shared folder volume between the apps:
```
...
containers:
        - name: write-service
          image: write-service:latest
          imagePullPolicy: IfNotPresent
          volumeMounts: # Mount volume
          - name: shared
            mountPath: /shared
          env:
          - name: SHARED_FOLDER_PATH
            value: /shared/logs.txt
        
        - name: read-service
          image: read-service:latest
          imagePullPolicy: IfNotPresent
          volumeMounts: # Mount volume
          - name: shared
            mountPath: /shared
          env:
          - name: SHARED_FOLDER_PATH
            value: /shared/logs.txt
```

Apply shared ingress in ingress folder:
```
kubectl apply -f ingress
```

Now you can access read-service's hash output at _http://localhost:8081/_
