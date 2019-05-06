#!/usr/bin/env bash

set -e

REMOTE_IP=12479283
DOCKER_IMAGE_NAME=Docker
VERSION=v1.0.0


case $1 in
     "qa")
        sbt clean compile dist
        docker build --no-cache -t $DOCKER_IMAGE_NAME .
        docker tag $DOCKER_IMAGE_NAME:latest $REMOTE_IP/$DOCKER_IMAGE_NAME:qa
        docker push $REMOTE_IP/$DOCKER_IMAGE_NAME:qa
    ;;
    "prod")
        sbt clean compile dist
        docker build --no-cache -t $PROD_DOCKER_IMAGE_NAME:$VERSION .
        docker tag $PROD_DOCKER_IMAGE_NAME:$VERSION $PROD_REMOTE_IP/$PROD_DOCKER_IMAGE_NAME:$VERSION
        docker push $PROD_REMOTE_IP/$PRO
        D_DOCKER_IMAGE_NAME:$VERSION
    ;;
esac