#!/bin/bash

# Deploy to Docker
docker login -u="devopsicon+autobuilder" -p="$DOCKER_SECRET" quay.io
docker build . -t quay.io/devopsicon/salesmicroservice
docker push quay.io/devopsicon/salesmicroservice

# Deploy to Heroku Staging
docker login -u=_ -p="$HEROKU_API" registry.heroku.com
docker tag quay.io/devopsicon/salesmicroservice  registry.heroku.com/devopsicon-sales-staging/web
docker push registry.heroku.com/devopsicon-sales-staging/web 