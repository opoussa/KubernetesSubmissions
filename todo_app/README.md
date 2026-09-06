# 2.8. The project, step 11

### PostgreSQL database implemented as a stateful set
The todo-backend now stores todos into a postgreSQL table. The postgreSQL database is deployed as a stateful set with one replica at a time:
```yaml
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: todo-psql-stset
  namespace: project
spec:
  serviceName: psql-svc
  replicas: 1
  selector:
    matchLabels:
      app: psqlapp
  template:
    metadata:
      labels:
        app: psqlapp
    spec:
      containers:
        - name: postgres
          image: postgres:16
          imagePullPolicy: IfNotPresent
          envFrom:
            - secretRef:
                name: postgres-credentials
          ports:
            - name: web
              containerPort: 5432
          volumeMounts:
            - name: psql-data-storage
              mountPath: /var/lib/postgresql/data
  volumeClaimTemplates:
    - metadata:
        name: psql-data-storage
      spec:
        accessModes: ["ReadWriteOnce"]
        storageClassName: local-path
        resources:
          requests:
            storage: 100Mi
```
Service to go along with the statefulSet:
```yaml
apiVersion: v1
kind: Service
metadata:
  name: todo-psql-svc
  namespace: project
  labels:
    app: psqlapp
spec:
  ports:
  - port: 5432
    name: web
  clusterIP: None
  selector:
    app: psqlapp
```
Postgres configuration env values implemented as base64 encoded Secrets:
```yaml
apiVersion: v1
kind: Secret
metadata:
  name: postgres-credentials
  namespace: project
data:
  POSTGRES_USER: dG9kby1iYWNrZW5k
  POSTGRES_PASSWORD: d2hhdHRvZG93aGF0dG9kbw==
  POSTGRES_DB: dG9kb2Ri
  POSTGRES_URL: amRiYzpwb3N0Z3Jlc3FsOi8vdG9kby1wc3FsLXN2Yzo1NDMyL3RvZG9kYg==
```

----
### How to run

Select namespace `project` as kubectl context

Build the docker images:
```
docker build -t todoapp .
docker build -t todo-backend .
```

Import images to k3d cluster:
```
k3d image import todo_app
```
Apply new statefulSet, service and configs from backend folder:
```
kubectl apply -f manifests
```

Home page with random image and input form should now be visible at _http://localhost:8081/todo_
