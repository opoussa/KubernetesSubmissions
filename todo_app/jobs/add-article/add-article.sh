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