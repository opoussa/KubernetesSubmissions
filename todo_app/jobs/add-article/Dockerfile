FROM alpine:latest

RUN apk add --no-cache bash curl ca-certificates

WORKDIR /app
COPY add-article.sh .

RUN chmod +x add-article.sh

CMD ["bash", "/app/add-article.sh"]