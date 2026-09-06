# 2.7. Stateful applications
### New PostgreSQL Stateful set and service created
Initiated a PostgreSQL database to store pingpong count as a statefulSet with only one replica.

 ```yaml
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: psql-stset
  namespace: exercises
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
            - configMapRef:
                name: pingpong-config
```

Service to go with the statefulSet:
```yaml
apiVersion: v1
kind: Service
metadata:
  name: psql-svc
  namespace: exercises
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

Pingpong app's environment variables including postgreSQL database properties were moved to a configmap:

```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: pingpong-config
  namespace: exercises
data:
  POSTGRES_USER: "pingpong-app"
  POSTGRES_PASSWORD: "boing!"
  POSTGRES_DB: "pingpong"
  POSTGRES_URL: "jdbc:postgresql://psql-svc:5432/pingpong"
```

----
### How to run
Create and select new namespace `exercises` as kubectl context

Apply both log output and pingpong app and psql related manifests in their own folders respectively:
```
kubectl apply -f manifests
```

Apply shared `ingress` in ingress folder:
```
kubectl apply -f ingress
```
Now you can see the `information.txt` and `message.env` values, hash output and amount of Ping-Pongs from `read service` at _http://localhost:8081/_ 

Use _http://localhost:8081/pingpong_ to increase ping-pong count.
