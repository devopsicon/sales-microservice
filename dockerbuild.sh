#!/bin/sh

if [ $TRAVIS_BRANCH == 'develop' ]; then
    docker login -u="devopsicon+autobuilder" -p="$docker-secret" quay.io
    docker build . quay.io/devopsicon/salesmicroservice
    docker push quay.io/devopsicon/salesmicroservice
fi