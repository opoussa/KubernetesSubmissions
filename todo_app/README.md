# 1.12. The project, step 6

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

Home page with random image should now be visible at _http://localhost:8081/_

### Persistent images

The app writes a link to a lorem picsum image source in a text file inside a persistent volume.
The url is saved with a UNIX timestamp indicating last modification to the file.
Contents of file look like the following:
```
https://picsum.photos/id/{random_number}/200/300
1775460848848
```

On every request, the timestamp is read. If 10 minutes have passed since the stamp, a new url with random photo id is inserted.
The old link is still served one more time on that request. New link will be server on the next request.
The volume with the file outlives any containers inside the pod.
