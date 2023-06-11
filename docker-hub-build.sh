#!/bin/bash

cd adt-pulse-mqtt

# amd64 build is automated on Docker Hub from Github Repo
# docker build -f "Dockerfile-amd64" -t adtpulsemqtt/adt-pulse-mqtt:amd64-latest .

# armhf is failing cross-build on Docker Hub, so build locally and push
#docker build -f "Dockerfile-armhf" -t adtpulsemqtt/adt-pulse-mqtt:armhf-latest .
#docker push adtpulsemqtt/adt-pulse-mqtt:armhf-latest

docker build -f "Dockerfile-armhf" -t robross0606/adt-pulse-mqtt:armhf-latest .
docker push robross0606/adt-pulse-mqtt:armhf-latest

#docker build -f "Dockerfile-armhf" -t ghcr.io/robross0606/adt-pulse-mqtt:armhf-latest .
#docker push ghcr.io/robross0606/adt-pulse-mqtt:armhf-latest