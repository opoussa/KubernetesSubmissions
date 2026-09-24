# 2.9 The project, step 12

### New CronJob created
A new CronJob that posts a todo every hour with a link to a random Wikipedia article was created:
```yaml
apiVersion: batch/v1
kind: CronJob
metadata: 
  name: add-article
  namespace: project
spec:
  schedule: "0 * * * *"
  jobTemplate:
    spec:
      template:
        spec:
          containers:
            - name: add-article
              image: add-article:latest
              imagePullPolicy: IfNotPresent
              envFrom:
                - configMapRef:
                    name: todo-app-config
          restartPolicy: Never
```
The job runs a bash script pulling a random wikipedia article from https://en.wikipedia.org/wiki/Special:Random:
```bash
#!/usr/bin/env bash

: "${BACKEND_URL:?BACKEND_URL must be set}"

location=$(curl --silent --show-error --dump-header - --output /dev/null \
	https://en.wikipedia.org/wiki/Special:Random \
	| awk 'BEGIN { IGNORECASE = 1 } /^location:/ { sub(/\r$/, "", $2); print $2; exit }')

article_url="https:${location}"
printf '%s\n' "$article_url"

curl --fail --silent --show-error \
	--header 'Content-Type: text/plain; charset=utf-8' \
	--data-raw "Read this article: $article_url" \
	"$BACKEND_URL"
```

----
### How to run

Select namespace `project` as kubectl context

Build the script docker image:
```
docker build -t add-article .
```

Import image to k3d cluster:
```
k3d image import add-article:latest
```
Apply new CronJob with other manifests from todo-app folder:
```
kubectl apply -f /todo-app/manifests
```

Home page with a random wikipedia article listed should now be visible at _http://localhost:8081/todo_. If not, check back on the next clock hour.
