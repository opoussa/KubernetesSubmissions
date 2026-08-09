# 2.5. Documentation and ConfigMaps
### New ConfigMap created
Created a ConfigMap from two files: `information.txt` & `message.env`

```
Name:         log-output-config
Namespace:    exercises
Labels:       <none>
Annotations:  <none>
Data
====
information.txt:
----
This is text from the file infromation.txt

message.env:
----
MESSAGE=Hello from the environment variable!

BinaryData
====

Events:  <none>
```

An env variable was configured into the logoutput deployment for the contents of `message.env`:
```yaml
...
env:
  ...
  - name: MESSAGE
    valueFrom:
      configMapKeyRef:
        name: log-output-config
        key: message.env
```
----
### How to run
Create and select new namespace `exercises` as kubectl context

Apply `Persistent Volume` and `Claim` for read and write services from the volume folder:
```
kubectl apply -f volumes
```
Apply `deployment` and `service` manifests from manifest folder (also in ping-pong subdirectory):
```
kubectl apply -f manifests
```

Apply shared `ingress` in ingress folder:
```
kubectl apply -f ingress
```
Now you can see the `information.txt` and `message.env` values, hash output and amount of Ping-Pongs from `read service` at _http://localhost:8081/_ 

Use _http://localhost:8081/pingpong_ to increase ping-pong count.
