#!/bin/sh

docker login -u="devopsicon+autobuilder" -p="$DOCKER_SECRET" quay.io
docker build . quay.io/devopsicon/salesmicroservice
docker push quay.io/devopsicon/salesmicroservice
