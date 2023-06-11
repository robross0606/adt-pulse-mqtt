ARG BUILD_FROM=balenalib/amd64-alpine:3.13-run
FROM $BUILD_FROM

ENV LANG C.UTF-8
ENV NODE_ENV production

# Install node and npm
RUN apk add --update-cache nodejs npm

WORKDIR /usr/src/app

# Install app dependencies
COPY package.json .
RUN npm install --omit=dev

# Bundle app source
COPY . .

# Copy data for add-on
COPY run.sh /
RUN chmod a+x /run.sh

CMD [ "/run.sh" ]
