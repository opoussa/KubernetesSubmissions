# 1.13. The project, step 7

### Todo input form
The app now has a form that takes text input that is under 140 characters, and a button for submitting the input.
```
<body>
        <h1>The Project App</h1>
        <img 
            th:src="${imageSrc}" 
            style="width: 200px; height: auto;" 
            alt="Random image from the internet"
        >
        <form>
            <input type="text" maxlength="140"/>
            <button type="submit">Create todo</button>
        </form>
        <ul>
            <li>Clean kitchen</li>
            <li>Learn Kubernetes</li>
            <li>Learn Terraform</li>
        </ul>
        <p>DevOps with Kubernetes 2026</p>
    </body>
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
