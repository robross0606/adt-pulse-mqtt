ARG BUILD_FROM
FROM $BUILD_FROM

ENV LANG C.UTF-8
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

RUN apk add --no-cache \
    nodejs \
    npm

WORKDIR /usr/src/app

# Install app dependencies
COPY package.json .
RUN npm install --production

# Bundle app source
COPY [. .]

# Copy data for add-on
COPY run.sh /
RUN chmod a+x /run.sh

CMD [ "/run.sh" ]

#  Labels 

ARG BUILD_DESCRIPTION="Home Assistant Add On Version of BigThunderSR/onstar2mqtt for Vehicle 1"
ARG BUILD_NAME="OnStar2MQTT Home Assistant Add-on (BigThunderSR) for Vehicle 1"
ARG BUILD_REPOSITORY="BigThunderSR/homeassistant-addons-onstar2mqtt"

LABEL \
    maintainer="BigThunderSR (https://github.com/BigThunderSR)" \
    org.opencontainers.image.title="${BUILD_NAME}" \
    org.opencontainers.image.description="${BUILD_DESCRIPTION}" \
    org.opencontainers.image.vendor="Home Assistant OnStar2MQTT Add-ons by BigThunderSR" \
    org.opencontainers.image.authors="BigThunderSR (https://github.com/BigThunderSR)" \    
    org.opencontainers.image.url="https://github.com/BigThunderSR" \
    org.opencontainers.image.source="https://github.com/${BUILD_REPOSITORY}" \
    org.opencontainers.image.documentation="https://github.com/${BUILD_REPOSITORY}/blob/main/README.md" 

ARG BUILD_FROM=balenalib/amd64-alpine:3.13-run
FROM $BUILD_FROM

ENV LANG C.UTF-8
ENV NODE_ENV production

# Install node and npm (Node 14 LTS)
RUN apk add --update nodejs=~14
RUN apk add --update nodejs-npm=~14

# Install node and npm (Node 18 LTS)
#RUN apk add --update nodejs=~18
#RUN apk add --update nodejs-npm=~18

WORKDIR /usr/src/app

# Install app dependencies
COPY package.json .
RUN npm install --production

# Bundle app source
COPY . .

# Copy data for add-on
COPY run.sh /
RUN chmod a+x /run.sh

CMD [ "/run.sh" ]
