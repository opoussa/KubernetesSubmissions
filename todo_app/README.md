# 2.2. The project, step 8

### Todo app now has a backend
The app is now split into a frontend and a separate backend. Todos may be added and fetched to and from the backend using the form.

Client calling the backend service:
```
@HttpExchange(url = "http://todo-backend-svc:2345")
public interface ITodoClient {
    @GetExchange
    public List<String> getTodos();

    @PostExchange
    public void addTodo(@RequestBody String todo);
```


### How to run

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
